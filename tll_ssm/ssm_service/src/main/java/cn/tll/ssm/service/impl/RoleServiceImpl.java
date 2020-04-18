package cn.tll.ssm.service.impl;

import cn.tll.ssm.dao.IRoleDao;
import cn.tll.ssm.domain.Permission;
import cn.tll.ssm.domain.Role;
import cn.tll.ssm.service.IRoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findAll(Integer page,Integer size) throws Exception {
        PageHelper.startPage(page,size);
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    /**
     * 保存角色
     * @param role
     */
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    //根据id来查询角色
    @Override
    public Role findById(String roleId) throws Exception{
        return roleDao.findById(roleId);
    }

    //查询角色可添加的权限
    @Override
    public List<Permission> findOtherPermission(String roleId) throws Exception {
        return roleDao.findOtherPermission(roleId);
    }

    //角色添加权限
    @Override
    public void addPermissionToRole(String roleId, String[] ids) throws Exception {
        for (String id : ids) {
            roleDao.addPermissionToRole(roleId,id);
        }
    }
}
