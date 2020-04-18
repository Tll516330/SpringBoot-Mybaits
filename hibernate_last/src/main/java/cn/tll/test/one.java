package cn.tll.test;


import cn.tll.domain.User;
import cn.tll.domain.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class one {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session session = sf.openSession();


        UserEntity entity = new UserEntity();
        entity.setName("美美");
        entity.setId(21);


        session.save(entity);

        session.close();
        sf.close();

    }
}
