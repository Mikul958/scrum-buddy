package src;

import java.util.ArrayList;

/**
 * An account of a user, containing various information as well as a list of the user's projects.
 * @author Michael Pikula
 */
public class Account
{
    private String username;  // Username must be unique for account creation, no need for UUIDs.
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private boolean isVerified;
    private ArrayList<Project> projects;

    /**
     * Creates an account with the specified information.
     * @param username The username of the account.
     * @param password The password of the account.
     * @param email The email address associated with the account.
     * @param firstName The account user's real first name.
     * @param lastName The account user's real last name.
     * @param isVerified Whether or not the account has been verified by the user.
     */
    public Account(String username, String password, String email, String firstName, String lastName, boolean isVerified)
    {
        this.username = username;  // Uniqueness must be checked externally.
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isVerified = isVerified;
        this.projects = new ArrayList<Project>();
    }

    // Getters and setters
    public String getUsername()
    {
        return this.username;
    }
    public String getPassword()
    {
        return this.password;
    }
    public String getEmail()
    {
        return this.email;
    }
    public String getFirstName()
    {
        return this.firstName;
    }
    public String getLastName()
    {
        return this.lastName;
    }
    public boolean getIsVerified()
    {
        return this.isVerified;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setName(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Sets the value of isVerified to true.
     */
    public void verifyAccount()
    {
        this.isVerified = true;
    }
    /**
     * Creates a string containing all account information except for the password.
     * @return A string containing account information.
     */
    public String toString()
    {
        return "Username: " + username
        + "\nEmail: " + email
        + "\nName: " + firstName + " " + lastName
        + "\nIs User Verified: " + isVerified;
    }
    /**
     * Checks if this account and the specified account are equivalent via their usernames.
     * @param account The account to be compared to.
     * @return true if the accounts are equivalent.
     */
    public boolean equals(Account account)
    {
        return account != null && username.equals(account.getUsername());
    }
}