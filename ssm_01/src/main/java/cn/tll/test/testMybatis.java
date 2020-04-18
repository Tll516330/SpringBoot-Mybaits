package cn.tll.test;

import cn.tll.dao.AccountDao;
import cn.tll.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class testMybatis {

    /**
     * 测试查询
     */
    @Test
    public void mybatis()throws Exception{
        //1.加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.获取代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        //查询所有
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        //关闭资源
        sqlSession.close();
        in.close();

    }

    /**
     * 测试保存
     */
    @Test
    public void savemybatis()throws Exception{
        //1.加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.获取代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        Account account = new Account();
        account.setName("哈哈");
        account.setMoney(1000d);
        dao.saveAccount(account);

        //提交事务  不改变表的操作都不需要提交事务  涉及到对表的增删改都要提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
        in.close();

    }
}
