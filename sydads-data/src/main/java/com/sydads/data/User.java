package com.sydads.data;


import com.sydads.Guid;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 8/05/15
 */

@Entity(name = "AdsUser")
public class User extends Guid {

    private String email;
    private boolean emailVerified;
    private String password;

    private String firstName;
    private String lastName;
    private String mobile;
    private UserType type;
    private Date registerDate;
    private Date verifyDate;
    private UserStatus userStatus;

}
