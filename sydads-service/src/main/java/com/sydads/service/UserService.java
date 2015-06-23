package com.sydads.service;

import com.sydads.data.User;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 30/05/15
 */
public interface UserService {

    boolean checkIfEmailIsUsed(String email);

    User register(String email, String password);
}
