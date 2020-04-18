package cn.tll.ssm.service.impl;

import cn.tll.ssm.dao.IUserDao;
import cn.tll.ssm.domain.Role;
import cn.tll.ssm.domain.UserInfo;
import cn.tll.ssm.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    //密码加密
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;

        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDatails
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false : true,
                true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @Override
    public List<UserInfo> findAll(Integer page,Integer size)throws Exception {
        PageHelper.startPage(page,size);
        return userDao.findAll();
    }

    /**
     * 保存用户
     * @param userInfo
     */
    @Override
    public void save(UserInfo userInfo)throws Exception {
        //使用spring security 对密码进行加密
        //userInfo.getPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    /**
     * 更具用户id来插叙详情
     * @param id
     * @return
     */
    @Override
    public UserInfo findById(String id)throws Exception {
        UserInfo userInfo = userDao.findById(id);
        return userInfo;
    }

    //查询用户可添加的角色
    @Override
    public List<Role> findOtherRoles(String userId)throws Exception {
        List<Role> roleList = userDao.findOtherRoles(userId);
        return roleList;
    }

    //给用户添加角色
    @Override
    public void addRoleToUser(String userId, String[] roleIds)throws Exception {
        //遍历一下所要添加的角色
        for (String roleId : roleIds) {
            //向数据库中一个一个添加
            userDao.addRoleToUser(userId,roleId);
        }
    }

    //条件查询
    @Override
    public List<UserInfo> findByInfo(Integer page, Integer size, UserInfo userInfo1)throws Exception {
        PageHelper.startPage(page,size);
        UserInfo userInfo = new UserInfo();
        String username ="%"+ userInfo1.getUsername()+"%";
        userInfo.setUsername(username);
        userInfo.setEmail("%"+userInfo1.getEmail()+"%");
        userInfo.setPhoneNum("%"+userInfo1.getPhoneNum()+"%");
        List<UserInfo> userInfoList = userDao.findByInfo(userInfo);
        return userInfoList;
    }
}
