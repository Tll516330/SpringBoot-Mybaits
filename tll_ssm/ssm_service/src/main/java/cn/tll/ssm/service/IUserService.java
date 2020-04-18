package cn.tll.ssm.service;

import cn.tll.ssm.domain.Role;
import cn.tll.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    /**
     * 查询所有用户的信息
     */
    List<UserInfo> findAll(Integer page,Integer size)throws Exception;

    /**
     * 保存用户
     * @param userInfo
     */
    void save(UserInfo userInfo)throws Exception;

    /**
     * 更具用户id来查询详情
     * @param id
     * @return
     */
    UserInfo findById(String id)throws Exception;

    //根据用户id查询可添加的角色
    List<Role> findOtherRoles(String userId)throws Exception;

    //用户添加角色
    void addRoleToUser(String userId, String[] roleIds)throws Exception;

    //条件查询
    List<UserInfo> findByInfo(Integer page, Integer size, UserInfo userInfo)throws Exception;
}
