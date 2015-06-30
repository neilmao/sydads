package com.sydads.repository.dao;

import com.sydads.data.model.User;

/**
 * Created by neilmao on 22/06/2015.
 */
public interface UserDao {

    User findUserByEmail(String email);

    boolean checkIfEmailIsUsed(String email);

    User persist(User user);
}