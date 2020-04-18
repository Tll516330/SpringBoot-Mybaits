package cn.tll.test;

import cn.tll.dao.UserDao;
import cn.tll.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * mybatis的实质是让开发人员只关注sql语句本身其他连接数据库jdbc的操作都交给mybatis去
 * 完成,大大减少的开发的时间
 */
public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    //用于在测试方法之前执行
    @Before
    public void init()throws Exception{
        //1.读取配置文件,生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
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

    /**
     * 查询所有用户
     */
    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("每一个用户");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    /**
     * 保存用户
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("tll");
        user.setAddress("中国");
        user.setBirthday(new Date());
        user.setSex("男");
        System.out.println("保存之前："+user);
        userDao.saveUser(user);
        System.out.println("保存之后："+user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setUsername("小美");
        user.setId(49);
        user.setSex("女");
        user.setBirthday(new Date());
        user.setAddress("杭州");

        userDao.updateUser(user);
    }

    /**
     * 根据id来查询用户
     */
    @Test
    public void testFindById(){
        User u = userDao.findByIdUser(49);
        System.out.println(u);
    }

    /**
     * 根据id进行查询
     */
    @Test
    public void testdeleteById(){
        userDao.deleteUser(49);
        System.out.println("删除成功");
    }

    /**
     * 根据姓名进行模糊查询
     * 尽量在这里加%% 这里的是预处理查询 更加安全
     */
    @Test
    public void testMoHu(){
        String name = "%王%";
        List<User> users = userDao.findByName(name);
        for (User user : users) {
            System.out.println(user);

        }
    }

    @Test
    public void testCount(){
        int total = userDao.findTotal();
        System.out.println("总共有"+total+"记录");
    }

}
