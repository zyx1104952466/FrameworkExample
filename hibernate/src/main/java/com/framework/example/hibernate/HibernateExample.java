package com.framework.example.hibernate;

import com.framework.example.hibernate.model.SysUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;

/**
 * HibernateExample
 *
 * @author zhangyux
 * @since 2024/2/18 16:44
 */
public class HibernateExample {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
            new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(SysUser.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            System.out.println("start");
            System.out.printf(session.createQuery("from SysUser").list().toString());
            System.out.println(" ");
            System.out.println("====================================");
            System.out.println(session.get(SysUser.class, 1));
            System.out.println("end");
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
