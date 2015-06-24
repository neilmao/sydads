package com.sydads.repository.dao;

import com.sydads.data.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
