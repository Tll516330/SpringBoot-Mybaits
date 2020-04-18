package cn.tll.dao;

import cn.tll.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 持久层接口
 */
public interface UserDao {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id查询用户
     * @param id
     */
    User findByIdUser(Integer id);

    /**
     * 根据ID删除用户
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询用户总数
     * @return
     */
    int findTotal();
}
