package edu.neu.msd.plagiarismdetector.service;

import edu.neu.msd.plagiarismdetector.model.User;
import edu.neu.msd.plagiarismdetector.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * class UserServiceImpl implements registering plagiarism detector
 * users to the system
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * The function saves the user and his encrypted password
     * to the database
     */
    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    /**
     * The function interacts with the database to 
     * find the user
     */
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}