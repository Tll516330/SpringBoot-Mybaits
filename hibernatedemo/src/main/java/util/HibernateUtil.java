package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

/**
 * hibernate工具类
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil(){

    }

    //静态代码块
    static {
        //hibernate核心类
        Configuration cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
    }

    /**
     * 获取SessionFactory
     * @return
     */
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    /**
     * 获取Session
     * @return
     */
    public static Session getSession(){
        return sessionFactory.openSession();
    }

    /**
     * 添加数据的方法
     * @param entity
     */
    public static void add(Object entity){
        Session s = null;
        Transaction tx =null;       //事务
        try {
            s =HibernateUtil.getSession();
            tx =s.beginTransaction();   //开启事务
            s.save(entity);             //保存
            tx.commit();
        } finally {
            if (s!=null){
                s.close();
            }
        }
    }

    /**
     * 根据id来查询
     * @param clazz
     * @param id
     * @return
     */
    public static Object get(Class clazz, Serializable id){
        Session s = null;
        try {
            s = HibernateUtil.getSession();
            Object obj = s.get(clazz, id);
            return obj;
        } finally {
            if (s!=null){
                s.close();
            }
        }
    }

}
