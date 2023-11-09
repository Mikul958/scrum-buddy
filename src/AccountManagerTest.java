package src;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class AccountManagerTest
{
    AccountManager manager;
    
    @BeforeEach
    public void getManager()
    {
        manager = AccountManager.getInstance();
        ProjectManager temp = ProjectManager.getInstance();  // Required to load in projects from file.
    }

    @Test
    public void testGetAccount()
    {
        Account acc = manager.getAccountByUsername("MPikula1");  // Grab MPikula1 from acc list.

        // Check retrieved account attributes.
        boolean equal = acc != null &&
                        acc.getUsername().equals("MPikula1") &&
                        acc.getPassword().equals("Apple456##") &&
                        acc.getEmail().equals("michaelpikula@aol.com") &&
                        acc.getFirstName().equals("Michael") &&
                        acc.getLastName().equals("Pikula");

        assertTrue(equal);
    }
    @Test
    public void testGetAccountNotExists()
    {
        Account acc = manager.getAccountByUsername("RAHHHHHH");  // Account with this username does not exist, returns null.
        assertEquals(acc, null);
    }

    @Test
    public void testLogin()
    {
        Account loggedIn = manager.login("MPikula1", "Apple456##");
        boolean equal = loggedIn != null &&
                        loggedIn.getUsername().equals("MPikula1") &&
                        loggedIn.getPassword().equals("Apple456##") &&
                        loggedIn.getEmail().equals("michaelpikula@aol.com") &&
                        loggedIn.getFirstName().equals("Michael") &&
                        loggedIn.getLastName().equals("Pikula");
        assertTrue(equal);
    }
    @Test
    public void testLoginBadUsername()
    {
        Account loggedIn = manager.login("MPikula", "Apple456##");  // Account with this username does not exist, return null.
        assertEquals(loggedIn, null);
    }
    @Test
    public void testLoginBadPassword()
    {
        Account loggedIn = manager.login("MPikula1", "Apple456#");  // Account exists but password incorrect, return null.
        assertEquals(loggedIn, null);
    }

    @Test
    public void testCreateAccount()
    {
        manager.createAccount("testman123", "testpass", "testman@gmail.com", "Test", "Man");
        Account loggedIn = manager.login("testman123", "testpass");

        assertNotEquals(loggedIn, null);
    }
    @Test
    public void testCreateAccountUsernameEmpty()
    {
        boolean created = manager.createAccount("", "testpass", "testman@gmail.com", "Test", "Man");
        assertFalse(created);
    }
    @Test
    public void testCreateAccountUsernameTaken()
    {
        boolean created = manager.createAccount("APacicco", "testpass", "testman@gmail.com", "Test", "Man");
        assertFalse(created);
    }
    @Test
    public void testCreateAccountEmailInvalid()
    {
        boolean created = manager.createAccount("testman123", "testpass", "testman.com", "Test", "Man");
        assertFalse(created);
    }

    // NOTE: This test seems to screw with other tests due to account deletion, comment it out if bulk testing and test it separately.
    @Test
    public void deleteAccount()
    {
        Account loggedIn = manager.login("MPikula1", "Apple456##");
        
        Project project1 = loggedIn.getProjects().get(0);  // Cade's Project, MPikula1 contributes
        Project project2 = loggedIn.getProjects().get(1);  // Al's Project, MPikula1 contributes

        // Get deletion confirmation from deleteAccount() and secondary test to see if account is no longer in list.
        boolean deleted = manager.deleteAccount(loggedIn);
        boolean deletedConfirmed = true;
        if (manager.getAccountByUsername("MPikula1") != null)
            deletedConfirmed = false;

        // Test to see if deleted account was removed from projects it contributed to.
        boolean deleteTest1 = true;
        boolean deleteTest2 = true;
        for (int i=0; i<project1.getContributors().size(); i++)
        {
            if (project1.getContributors().get(i).getUsername().equals("MPikula1"))
                deleteTest1 = false;
        }
        for (int i=0; i<project2.getContributors().size(); i++)
        {
            if (project2.getContributors().get(i).getUsername().equals("MPikula1"))
                deleteTest2 = false;
        }

        assertTrue(deleted && deletedConfirmed && deleteTest1 && deleteTest2);  // Passes, fixed bug with removing account as contributor to projects.
    }
}
