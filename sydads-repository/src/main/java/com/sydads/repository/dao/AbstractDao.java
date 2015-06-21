//package com.sydads.repository.dao;
//
//import com.sydads.repository.RepositoryUtil;
//
//import javax.persistence.EntityManager;
//
///**
// * Created by neilmao on 22/06/2015.
// */
//public abstract class AbstractDao {
//
//    protected EntityManager entityManager;
//
//    public AbstractDao() {
//        entityManager = RepositoryUtil.getEntityManager();
//    }
//
//    protected void begin() {
//        entityManager.getTransaction().begin();
//    }
//
//    protected void commit() {
//        entityManager.getTransaction().commit();
//    }
//
//    protected void persist(Object object) {
//        entityManager.persist(object);
//    }
//
//    protected void close() {
//        entityManager.close();
//    }
//}
