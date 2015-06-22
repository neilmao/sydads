package com.sydads.repository.dao;

import com.sydads.data.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by neilmao on 22/06/2015.
 */
@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public User findUserByEmail(String email) {

        Query query = sessionFactory.getCurrentSession().createQuery("select user from AdsUser user where user.email = :email");
        query.setParameter("email", email);
        List<User> result = query.list();
        if (result.size() > 0)
            return result.get(0);
        else
            return null;
    }

    public boolean checkIfEmailIsUsed(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery("select user from AdsUser user where user.email = :email");
        query.setParameter("email", email);
        List<User> result = query.list();
        return result.size() > 0;
    }
}