package src;

import java.util.ArrayList;

public class TestUI
{
    public static ScrumSystem system = new ScrumSystem();
    public static void main(String[] args)
    {
        testLogin("googoogaga", "woohoo");    // Should fail, no such username yet.
        testLogin("MPikula1","apple456##");   // Should fail, incorrect password.

        testLogin("MPikula1", "Apple456##");  // Should succeed.
        system.logout();
        system.saveData();

        // Should not happen because this account is deleted each test, but will happen if account is not deleted.
        boolean success = system.createAccount("googoogaga", "woohoo", "googoogaga@aol.com", "Googoo", "Gaga");
        if (!success)
            System.out.println("Account creation failed: username already in use");

        // Should now succeed as account has been created with this info.
        testLogin("googoogaga", "woohoo");
        
        System.out.println("-------------------- TESTING ACCOUNT DELETION --------------------");
        
        AccountManager manager = AccountManager.getInstance();

        // Should print all accounts, including the googoogaga one
        System.out.println("Pre-deletion:");
        ArrayList<Account> newAccounts = manager.getAccounts();
        for (int i=0; i<newAccounts.size(); i++)
            System.out.println("  - " + newAccounts.get(i));
        
        // Should print the googoogaga one
        System.out.println("\nCURRENT USER:\n" + system.getCurrentAccount());

        // Should print true
        System.out.println("---------- Account Deleted: " + system.deleteCurrentAccount() + " ----------");

        // Should print all account before except the googoogaga one since it was just deleted
        System.out.println("Post-deletion:");
        newAccounts = manager.getAccounts();
        for (int i=0; i<newAccounts.size(); i++)
            System.out.println("  - " + newAccounts.get(i));

        // Should print null, as googoogaga was current user and that account was deleted.
        System.out.println("\nCURRENT USER:\n" + system.getCurrentAccount());

        system.saveData();
    }

    /**
     * Tests a login with specified credentials, prints account info if login successful.
     * @param username The username to test a login with.
     * @param password The password to test a login with.
     */
    public static void testLogin(String username, String password)
    {
        System.out.println("-----------------------------------------");
        if (system.login(username, password))
            System.out.println("Login Successful:\n" + system.getCurrentAccount());
        else
            System.out.println("Login Failed!");
    }
}
