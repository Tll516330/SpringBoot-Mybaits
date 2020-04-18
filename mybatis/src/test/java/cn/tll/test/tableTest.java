package cn.tll.test;

import cn.tll.dao.AccountDao;
import cn.tll.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 测试account
 */
public class tableTest {

    private InputStream in;
    private SqlSession sqlSession;
    private AccountDao accountDao;

    //在测试方法之前执行
    @Before
    public void init() throws Exception {
        //1.读取配置文件,生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.读取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao代理对象
        accountDao = sqlSession.getMapper(AccountDao.class);
    }

    //用于在测试方法执行之后执行
    @After
    public void destory()throws Exception{
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        in.close();
    }


    //查询所有账户
    @Test
    public void testAccount(){
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("每个account的账户信息");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

}
