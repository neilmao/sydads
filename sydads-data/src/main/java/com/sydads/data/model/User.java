package com.sydads.data.model;

import com.sydads.data.Guid;

import javax.persistence.*;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 8/05/15
 */

@Entity
@Table(name = "AdsUser")
public class User extends Guid {

    private String email;
    private String password;

    private String firstName;
    private String lastName;
    private String mobile;
    private Date registerDate;
    private Date verifyDate;
    private Set<Role> roles;
    private UserStatus status;

    // as a vendor, I can publish some advertisements
    private Set<Advertisement> publishedAdvertisements;

    // as a pusher, I can push some advertisements
    private Set<Advertisement> pushedAdvertisements;

    // as a user, I can publish News
    private Set<News> publishedNews;


    public User() {
        roles = Collections.singleton(Role.Pusher);
        registerDate = new Date();
        status = UserStatus.WaitingVerify;
    }

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

    @Temporal(TemporalType.DATE)
    @Column(name = "RegisterDate")
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "VerifyDate")
    public Date getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(Date verifyDate) {
        this.verifyDate = verifyDate;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Column(name = "UserRole")
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Column(name = "UserStatus")
    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    public Set<Advertisement> getPublishedAdvertisements() {
        return publishedAdvertisements;
    }

    public void setPublishedAdvertisements(Set<Advertisement> publishedAdvertisements) {
        this.publishedAdvertisements = publishedAdvertisements;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "UserPushedAdvertisement",
            joinColumns = {@JoinColumn(name = "UserId", nullable = false, updatable = false) },
            inverseJoinColumns = {@JoinColumn(name = "AdvertisementId", nullable = false, updatable = false) })
    public Set<Advertisement> getPushedAdvertisements() {
        return pushedAdvertisements;
    }

    public void setPushedAdvertisements(Set<Advertisement> pushedAdvertisements) {
        this.pushedAdvertisements = pushedAdvertisements;
    }

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    public Set<News> getPublishedNews() {
        return publishedNews;
    }

    public void setPublishedNews(Set<News> publishedNews) {
        this.publishedNews = publishedNews;
    }
}
