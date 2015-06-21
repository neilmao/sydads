package com.sydads.service;

import com.sydads.data.User;
import com.sydads.data.Role;
import com.sydads.repository.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by neilmao on 22/06/2015.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserByEmail(username);

        List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());

        return buildUserForAuthentication(user, authorities);
    }

    private User buildUserForAuthentication(User user,
                                            List<grantedauthority> authorities) {
        return new User(user.getUsername(), user.getPassword(),
                user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<userrole> userRoles) {

        Set<grantedauthority> setAuths = new HashSet<grantedauthority>();

        // Build user's authorities
        for (Role userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<grantedauthority> Result = new ArrayList<grantedauthority>(
                setAuths);

        return Result;
    }
}
