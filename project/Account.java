package project;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Miles Wedeking
 */
public class Account
{
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private boolean isVerified;
    private ArrayList<Project> projects;

    public Account(String firstName, String lastName, String username, String password)
    {

    }
    public Account(UUID id, String firstName, String lastName, String username, String password)
    {
        
    }

    public void verifyAccount()
    {

    }
    public String toString()
    {
        return null;
    }
    public boolean equals(Account account)
    {
        return false;
    }
}