package cn.tll.ssm.dao;

import cn.tll.ssm.domain.Permission;
import cn.tll.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRoleDao {

    //更具用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId =#{userId})")
    @Results({
            @Result(id = true, column = "id",property = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",
                    javaType = java.util.List.class,many = @Many(select = "cn.tll.ssm.dao.IPermissionDao.findPermissionByRoleId"))

    })
    public List<Role> findRoleByUserId(String userId)throws Exception;


    //查询所有角色
    @Select("select * from role")
    List<Role> findAll()throws Exception;

    //保存角色
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc}) ")
    void save(Role role);

    //根据id来查询角色信息
    @Select("select * from role where id=#{roleId}")
    Role findById(String roleId)throws Exception;

    //根据roleId查询可添加的权限
    @Select("select * from permission where id not in(select permissionId from role_permission where roleId= #{roleId})")
    List<Permission> findOtherPermission(String roleId)throws Exception;

    //角色添加权限
    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{id})")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("id") String id)throws Exception;
}
