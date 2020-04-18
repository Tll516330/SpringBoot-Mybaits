package cn.tll.service;

import cn.tll.domain.Account;

import java.util.List;

/**
 * 账户的业务接口
 */
public interface AccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据ID 查询到一个用户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存用户
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新用户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 根据ID删除用户
     * @param accountId
     */
    void deleteAccount(Integer accountId);


}
