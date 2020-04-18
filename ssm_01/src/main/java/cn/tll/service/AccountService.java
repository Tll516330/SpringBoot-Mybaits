package cn.tll.service;

import cn.tll.domain.Account;

import java.util.List;

public interface AccountService {

    /**
     * 保存account
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 查询所有account信息
     * @return
     */
    List<Account> findAll();
}
