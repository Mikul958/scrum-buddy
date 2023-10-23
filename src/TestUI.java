package src;

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

        system.createAccount("googoogaga", "woohoo", "googoogaga@aol.com", "Googoo", "Gaga");
        testLogin("googoogaga", "woohoo");    // Should now succeed as account has been created with this info.
        system.logout();
        // New account isn't saved so testing can be repeated, but first testLogin does pass if data is saved at the end.
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
            System.out.println("Login Successful:\n" + system.getCurrentUser());
        else
            System.out.println("Login Failed!");
    }
}
