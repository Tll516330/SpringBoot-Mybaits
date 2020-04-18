package cn.tll.dao;

import cn.tll.domain.Account;

import java.util.List;

public interface AccountDao {

    /**
     * 查询account中所有账户,同时还要获取到当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();
}
