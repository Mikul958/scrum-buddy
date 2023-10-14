package src;

import java.util.ArrayList;

/**
 * @author Michael Pikula
 */
public class Account
{
    private String username;
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

    // Getters go here
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
        return username.equals(account.getUsername())
            && password.equals(account.getPassword())
            && email.equals(account.getEmail())
            && firstName.equals(account.getFirstName())
            && lastName.equals(account.getLastName())
            && this.isVerified == account.getIsVerified();
    }
}