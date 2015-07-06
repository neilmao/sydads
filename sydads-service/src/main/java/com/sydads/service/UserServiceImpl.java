package com.sydads.service;

import com.sydads.data.model.Pusher;
import com.sydads.data.model.Role;
import com.sydads.data.model.User;
import com.sydads.data.model.UserStatus;
import com.sydads.repository.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: neilmao
 * Date: 30/05/15
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserByEmail(username);

        if (user == null)
            throw new UsernameNotFoundException("Username " + username + " not found.");

        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());

        return buildUserForAuthentication(user, authorities);
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                UserStatus.isActive(user.getStatus()), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {

        List<GrantedAuthority> auths = new LinkedList<>();

        // Build user's authorities
        for (Role userRole : userRoles) {
            auths.add(new SimpleGrantedAuthority(userRole.toString()));
        }
        return auths;
    }

    @Override
    public boolean checkIfEmailIsUsed(String email) {
        return userDao.checkIfEmailIsUsed(email);
    }

    @Override
    public User register(String email, String password) {
        if (!checkIfEmailIsUsed(email)) {
            User user = new Pusher();
            user.setEmail(email);
            user.setPassword(password);
            return userDao.persist(user);
        } else {
            return null;
        }
    }

    @Override
    public void save(User user) {
        userDao.persist(user);
    }
}
