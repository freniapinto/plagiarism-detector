package edu.neu.msd.plagiarismdetector.service;

/**
 * Interface SecurityService includes functions
 * to allow authentication during login
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
