package com.sydads.service;

import com.sydads.data.User;
import com.sydads.repository.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 30/05/15
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean checkIfEmailIsUsed(String email) {
        return false;
    }

    @Override
    public boolean register(String email, String password) {

        if (!checkIfEmailIsUsed(email)) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);


            return true;
        } else {
            return false;
        }

    }
}
