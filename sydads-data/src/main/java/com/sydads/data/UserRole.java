package com.sydads.data;

import com.sydads.Guid;

import javax.persistence.*;

/**
 * Created by neilmao on 22/06/2015.
 */
@Entity(name = "UserRole")
public class UserRole extends Guid{

    private User user;
    private Role role;

    @Column(name = "SecuriyRole")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToOne
    @JoinColumn(name = "UserId", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
