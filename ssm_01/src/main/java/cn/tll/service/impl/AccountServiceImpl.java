package cn.tll.service.impl;

import cn.tll.dao.AccountDao;
import cn.tll.domain.Account;
import cn.tll.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    //自动注入
    @Autowired
    private AccountDao accountDao;

    @Override
    public void saveAccount(Account account) {
        System.out.println("保存用户");
        accountDao.saveAccount(account);
    }

    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询用户");
        return accountDao.findAll();
    }
}
