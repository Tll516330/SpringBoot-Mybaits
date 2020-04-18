package cn.tll.ssm.dao;

import cn.tll.ssm.domain.Role;
import cn.tll.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IUserDao {

    //登录验证
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id" ,column = "id"),
            @Result(property = "username" ,column = "username"),
            @Result(property = "email" , column = "email"),
            @Result(property = "password" , column = "password"),
            @Result(property = "phoneNum" , column = "phoneNum"),
            @Result(property = "status" , column = "status"),
            @Result(property = "roles", column = "id" ,javaType = java.util.List.class , many = @Many(select = "cn.tll.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;

    //查询所有用户信息
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo)throws Exception;

    //更具id 查询用户详细信息  涉及多表查询
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",
                    javaType = java.util.List.class,many = @Many(select = "cn.tll.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id)throws Exception;

    //查询用户可添加的角色
    @Select("select * from role where id not in(select roleId from users_role where userId = #{userId})")
    List<Role> findOtherRoles(String userId)throws Exception;

    //给用户添加角色
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId)throws Exception;

    //条件查询
    @Select("select * from users where username like #{username} and email like #{email} and phoneNum like #{phoneNum}")
    List<UserInfo> findByInfo(UserInfo userInfo)throws Exception;
}
