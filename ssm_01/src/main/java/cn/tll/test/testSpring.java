package cn.tll.test;

import cn.tll.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 单元测试Spring
 */
public class testSpring {

    @Test
    public void testspring(){

    //加载配置文件
    ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    //获取对象  强转类型
    AccountService as = (AccountService) ac.getBean("accountService");
    //调用方法
    as.findAll();

    }
}
