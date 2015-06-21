package com.sydads.data;

import com.sydads.Guid;

import javax.persistence.*;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 8/05/15
 */

@Entity(name = "AdsUser")
public class User extends Guid {

    private String email;
    private String password;

    private String firstName;
    private String lastName;
    private String mobile;
    private Date registerDate;
    private Date verifyDate;
    private Set<UserRole> userRoles;
    private UserStatus userStatus;

    public User() {
        userRoles = Collections.singleton(Role.Pusher);
        registerDate = new Date();
        userStatus = UserStatus.WaitingVerify;
    }

    @Override
    @Column(name = "id", length = 64)
    public String getId() {
        return super.getId();
    }

    @Id
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "Mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "RegisterDate")
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Column(name = "VerifyDate")
    public Date getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(Date verifyDate) {
        this.verifyDate = verifyDate;
    }

    @OneToMany(mappedBy = "user")
    public Set<UserRole> getRoles() {
        return userRoles;
    }

    public void setRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Column(name = "UserStatus")
    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }
}
