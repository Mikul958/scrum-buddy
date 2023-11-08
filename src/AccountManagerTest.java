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
}
