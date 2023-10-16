package src;

import java.util.ArrayList;

/**
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

    public Account(String username, String password, String email, String firstName, String lastName)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isVerified = false;
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
        this.username = username;  // Uniqueness of username must be checked externally.
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

    // Other methods
    public void verifyAccount()
    {
        this.isVerified = true;
    }
    public String toString()
    {
        return "\n Username: " + username
        + "\n Email: " + email
        + "\n Name: " + firstName + " " + lastName
        + "\n Is User Verified: " + isVerified;
    }
    public boolean equals(Account account)
    {
        return username.equals(account.getUsername());
    }
}