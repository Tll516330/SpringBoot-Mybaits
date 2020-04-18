package cn.tll.daoTest;

import cn.tll.dao.RoleDao;
import cn.tll.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class RoleTest {

    private InputStream in;
    private SqlSession sqlSession;
    private RoleDao roleDao;

    //用于在测试方法执行前执行
    @Before
    public void init()throws Exception{
        //1.读取配置文件,生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession                自动提交
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        roleDao = sqlSession.getMapper(RoleDao.class);
    }

    //用于在测试方法执行之后执行
    @After
    public void destroy()throws Exception{
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        in.close();

    }

    @Test
    public void  testFindAll(){
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println("----每个角色对应的职位");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
