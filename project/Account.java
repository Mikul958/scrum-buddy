package project;

import java.util.ArrayList;

/**
 * @author Miles Wedeking & Michael Pikula
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

    public Account(String firstName, String lastName, String email, String username, String password)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isVerified = false;
        this.projects = new ArrayList<Project>();
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
        // TODO create getters.
        return false;
    }
}