package com.sydads.service;

import com.sydads.data.model.User;
import com.sydads.repository.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 30/05/15
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean checkIfEmailIsUsed(String email) {
        return userDao.checkIfEmailIsUsed(email);
    }

    @Override
    public User register(String email, String password) {

        if (!checkIfEmailIsUsed(email)) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            return userDao.persist(user);
        } else {
            return null;
        }
    }
}
