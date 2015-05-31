//package com.sydads.data.jpa;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.hibernate.HibernateException;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//
///**
// * Created with IntelliJ IDEA.
// * User: neilmao
// * Date: 30/05/15
// */
//public class HibernateUtil {
//
//    private static final Log LOG = LogFactory.getLog(HibernateUtil.class);
//
//    private static SessionFactory sessionFactory;
//
//    static {
//
//        try {
//
//            Configuration configuration =  new Configuration();
//            configuration.configure("hibernate.cfg.xml");
//
//            StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//
//            sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
//
//        } catch (HibernateException ex) {
//            LOG.error("Error creating session:" + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//}
