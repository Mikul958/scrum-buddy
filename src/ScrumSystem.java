package src;

import java.util.ArrayList;

public class ScrumSystem {
    private AccountManager manager;
    private Account currentUser;
    private Project currentProject;

    public ScrumSystem()
    {
        manager = AccountManager.getInstance();
    }

    public void login(String username, String password)
    {
        currentUser = manager.login(username, password);
    }
    private Account enterUser()
    {
        return null;
    }
    private void enterPassword()
    {
        
    }
    private Account searchForAccount(String username)
    {
        return null;
    }
    private boolean checkPassword(Account account, String password)
    {
        return false;
    }
    private ArrayList<Project> getAllProjects()
    {
        return null;
    }
    public Project getProject(String id)
    {
        return null;
    }
    public boolean createAccount(String username, String password, String email, String firstName, String lastName)
    {
        return manager.createAccount(username, password, email, firstName, lastName);
    }
}
