package cn.tll;

import cn.tll.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Date;

public class h {

    @Test
    public void testSave(){
        //初始化
        Configuration cfg = new Configuration();
        cfg.configure();
        //获取连接工厂
        SessionFactory sf =cfg.buildSessionFactory();

        Session s = sf.openSession();
        //存入数据
        User user = new User();
        user.setName("小美");
        user.setBrithday(new Date());

        //使用hibernate进行保存
        s.save(user);

        System.out.println("使用hibernate成功");
        //关闭session会话
        s.close();
    }
}
