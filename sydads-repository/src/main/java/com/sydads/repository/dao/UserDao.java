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
public interface UserDao {

    User findUserByEmail(String email);

    boolean checkIfEmailIsUsed(String email);
}