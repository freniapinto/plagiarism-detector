package edu.neu.msd.plagiarismdetector.service;

import edu.neu.msd.plagiarismdetector.model.User;
import edu.neu.msd.plagiarismdetector.repository.UserRepository;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * class UserDetailsServiceImpl implements the login authentication feature
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    
    private static final Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);

    /**
     * The function determines if the user trying to log into the system exists and
     * if true, returns the details for authentication
     * @param username
     * @return UserDetails
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user ==null) {
        	logger.log(Level.ERROR, "User did not enter any username");
        	throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
