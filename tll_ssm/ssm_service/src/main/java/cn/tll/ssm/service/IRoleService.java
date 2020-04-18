package cn.tll.ssm.service;

import cn.tll.ssm.domain.Permission;
import cn.tll.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    List<Role> findAll(Integer page,Integer size)throws Exception;


    //保存角色
    void save(Role role);

    //根据id查询角色
    Role findById(String roleId)throws Exception;

    //查询可添加的权限
    List<Permission> findOtherPermission(String roleId)throws Exception;

    //角色添加权限
    void addPermissionToRole(String roleId, String[] ids)throws Exception;
}
