package com.sydads.data.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 30/05/15
 */
public enum PersistenceManager {
    INSTANCE;

    private EntityManagerFactory entityManagerFactory;

    private PersistenceManager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("sydads-repository");
    }

    public EntityManager getEntityManger() {
        return this.entityManagerFactory.createEntityManager();
    }

    public void close() {
        this.entityManagerFactory.close();
    }
}
