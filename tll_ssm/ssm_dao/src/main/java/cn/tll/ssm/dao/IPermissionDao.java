package cn.tll.ssm.dao;

import cn.tll.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    //查询所有权限
    @Select("select * from permission")
    List<Permission> findAll()throws Exception;

    /**
     * 根据角色id 来查询角色所具有的权限
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    List<Permission> findPermissionByRoleId(String id)throws Exception;

    //保存权限
    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);
}
