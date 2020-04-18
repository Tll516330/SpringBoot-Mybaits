package cn.tll.test;

import cn.tll.domain.Account;
import cn.tll.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 测试代码  Spring 整合junit  注入IOC
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private AccountService as;

    @Test
    public void testFindAccountAll(){

        //3.执行方法
        List<Account> list = as.findAllAccount();
        for (Account account : list) {
            System.out.println(account);
        }

    }

    @Test
    public void testFindAccouuntById(){

        //3.执行方法
        Account accountById = as.findAccountById(3);
        System.out.println(accountById.getName());
    }

    @Test
    public void testsaveAccount(){

        //3.执行方法
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(12345f);       //folat类型
        as.saveAccount(account);
    }

    @Test
    public void testupdateAccount(){

        //3.执行方法
        Account account = new Account();
        account.setId(1);
        account.setName("tll");
        account.setMoney(888888f);

        as.updateAccount(account);
    }

    @Test
    public void tesdeleteAccount(){
        //1.获取容器

        //3.执行方法
        as.deleteAccount(2);
    }
}
