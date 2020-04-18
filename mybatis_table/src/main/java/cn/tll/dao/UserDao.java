package cn.tll.dao;

import cn.tll.domain.User;

import java.util.List;

public interface UserDao {

    /**
     * 查询多有用户
     * @return
     */
    List<User> findAll();
}
