package edu.neu.msd.plagiarismdetector.model;

import javax.persistence.*;

/**
 * User class defines table "users" in the database
 */
@Entity
@Table(name = "users")
public class User {
    private Long id;
    @Column(name ="username")
    private String username;
    
    @Column(name ="password")
    private String password;
    private String passwordConfirm;

    @Column(name="emailAddress")
    private String emailAddress;
    
    @Column(name = "position")
    private String position;

    /**
     * @return id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    
    /**
     * The function sets id associated with the User object
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * The function sets the username associated with User object
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * The function sets the password associated with User object
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return passwordConfirm
     */
    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    /**
     * The function sets the password entered by User during login operation
     * @param passwordConfirm
     */
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }   
    
    
    /**
     * @return email-address
     */
    public String getemailAddress() {
        return emailAddress;
    }
    
    /**
     * The function sets the email address associated with User object
     * @param username
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    
    /**
     * @return position - Can be Instructor/TA
     */
    public String getPosition() {
        return position;
    }
    
    /**
     * The function sets the position associated with User object
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }
    

}

