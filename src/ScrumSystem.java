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
        projectManager = ProjectManager.getInstance();
    }

    public Account getCurrentUser()
    {
        return this.currentUser;
    }
    public Project getCurrentProject()
    {
        return this.currentProject;
    }

    public boolean saveData()
    {
        if (DataWriter.saveAccounts() && DataWriter.saveProjects())
            return true;
        return false;
    }
    public boolean login(String username, String password)
    {
        Account temp = accountManager.login(username, password);
        if (temp == null)
            return false;
        currentUser = temp;
        return true;
    }
    public void logout()
    {
        currentUser = null;
    }
    public boolean createAccount(String username, String password, String email, String firstName, String lastName)
    {
        return accountManager.createAccount(username, password, email, firstName, lastName);
    }
    public boolean deleteAccount(Account account)
    {
        if (currentUser.equals(account))
            logout();
        return accountManager.deleteAccount(account);
    }
    private Account getAccountByUsername(String username)
    {
        return accountManager.getAccountByUsername(username);
    }
    private ArrayList<Project> getAllProjects()
    {
        return null;
    }
    public Project getProjectByID(String id)
    {
        return null;
    }
}
