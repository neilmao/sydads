package com.sydads.repository.dao;

import com.sydads.data.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 23/06/15
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    public User findUserByEmail(String email) {

        Query query = entityManager.createQuery("select user from AdsUser user where user.email = :email");
        query.setParameter("email", email);
        List<User> result = query.getResultList();
        if (result.size() > 0)
            return result.get(0);
        else
            return null;
    }

    public boolean checkIfEmailIsUsed(String email) {
        Query query = entityManager.createQuery("select user from AdsUser user where user.email = :email");
        query.setParameter("email", email);
        List<User> result = query.getResultList();
        return result.size() > 0;
    }
}
