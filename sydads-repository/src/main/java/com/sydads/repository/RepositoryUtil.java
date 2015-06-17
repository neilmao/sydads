package com.sydads.repository;

import com.sydads.data.jpa.PersistenceManager;

import javax.persistence.EntityManager;

/**
 * Created by neilmao on 7/06/2015.
 */
public class RepositoryUtil {

    public static EntityManager getEntityManager() {
        return PersistenceManager.INSTANCE.getEntityManger();
    }
}
