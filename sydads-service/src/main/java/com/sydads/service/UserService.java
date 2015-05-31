package com.sydads.service;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 30/05/15
 */
public interface UserService {

    public boolean checkIfEmailIsUsed(String email);

    public boolean register(String email, String password);

    public boolean login(String email, String password);
}
