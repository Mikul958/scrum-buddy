package src;

import java.util.ArrayList;

public class ScrumSystem {
    private AccountManager accountManager;
    private ProjectManager projectManager;
    private Account currentUser;
    private Project currentProject;

    public ScrumSystem()
    {
        accountManager = AccountManager.getInstance();
    }

    public void login(String username, String password)
    {
        currentUser = accountManager.login(username, password);
    }
    public boolean createAccount(String username, String password, String email, String firstName, String lastName)
    {
        return accountManager.createAccount(username, password, email, firstName, lastName);
    }
    private Account getAccount(String username)
    {
        return accountManager.getAccountByUsername(username);
    }
    private ArrayList<Project> getAllProjects()
    {
        return null;
    }
    public Project getProject(String id)
    {
        return null;
    }
}
