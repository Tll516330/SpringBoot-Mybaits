package testMain;

import entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class testadd {

    @Test
    public void fun1(){
        //Error:java:无效的目标发行版：11
        Configuration cfg = new Configuration().configure();

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        //开启事务
        Transaction transaction = session.beginTransaction();

        //添加
        UserEntity user = new UserEntity();
        user.setName("田亮");
        user.setPassword("123456");

        session.save(user);

        //提交事务
        transaction.commit();

        session.close();
        sessionFactory.close();

        System.out.println("1234");
    }

    @Test
    public void  aa(){
        System.out.println("hahah");
        //Waring:java:源值1.5已过时，将在未来所有发行版中删除
    }

    //根据姓名来查询
    @Test
    public void query(){
        query_obj();

    }

    //面向对象查询(不使用sql查询)
    static void query_obj(){
        Session s = null;
        Transaction tx = null;
        try {
            //获取session对象
            s = HibernateUtil.getSession();
            //开启事务
            tx = s.beginTransaction();

            //具体的crud查询方法
            //新的查询方式
            //1.创建CriteraBuilder对象
            CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
            //2.获取createCriter对象
            CriteriaQuery<UserEntity> query = criteriaBuilder.createQuery(UserEntity.class);
            //执行查询
            //List<UserEntity> list = s.createQuery(query).getResultList();

            //3.指定条件查询
            Root<UserEntity> root = query.from(UserEntity.class);
            query.where(criteriaBuilder.equal(root.get("password"),"123456"));
            query.where(criteriaBuilder.like(root.get("name"),"%美%"));

            //4.执行查询
            List<UserEntity> list = s.createQuery(query).getResultList();

            //输出
            for (UserEntity userEntity : list) {
                System.out.println(userEntity.getName());
            }

            //提交事务
            tx.commit();
        } finally {
            //无论是否成功都要释放资源
            s.close();
        }


    }
    //静态代码块
    //面向sql查询(使用sql查询)
    static void query_s(String name) {
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            String hql = "from UserEntity as user where user.name =:name";
            Query query = s.createQuery(hql);
            query.setParameter("name",name);
            //分页查询
            query.setFirstResult(1).setMaxResults(2);
            List<UserEntity> list = query.list();
            for (UserEntity userEntity : list) {
                System.out.println(userEntity.getName());
            }
        } finally {
            if (s!=null){
                s.close();
            }
        }

    }

}
