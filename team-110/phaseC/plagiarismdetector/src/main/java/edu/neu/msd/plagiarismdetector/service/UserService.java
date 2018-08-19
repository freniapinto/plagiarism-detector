package edu.neu.msd.plagiarismdetector.service;

import edu.neu.msd.plagiarismdetector.model.User;

/**
 * The interface provides function to ensure users
 * can register on plagiarism detector system
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
