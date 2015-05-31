package com.sydads.service;

import com.sydads.data.User;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 30/05/15
 */
public class UserServiceImpl implements UserService {

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

    @Override
    public boolean login(String email, String password) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
