package edu.neu.msd.plagiarismdetector.repository;

import edu.neu.msd.plagiarismdetector.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface UserRepository to interact with Database
 * @author Frenia Pinto
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
