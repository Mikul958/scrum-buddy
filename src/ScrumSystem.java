package src;

import java.util.ArrayList;

/**
 * A class responsible for overall management of the software, including accounts, projects, which are open at any time, and more.
 * @author Michael Pikula
 */
public class ScrumSystem {
    private AccountManager accountManager;
    private ProjectManager projectManager;
    private Account currentAccount;
    private Project currentProject;

    public ScrumSystem()
    {
        accountManager = AccountManager.getInstance();
        projectManager = ProjectManager.getInstance();
    }

    // Accessors
    public Account getCurrentAccount()
    {
        return this.currentAccount;
    }
    public Project getCurrentProject()
    {
        return this.currentProject;
    }
    /**
     * Get the list of all the currently logged-in user's projects.
     * @return The list of all projects that the current user is a contributor to.
     */
    public ArrayList<Project> getCurrentAccountProjects()
    {
        return currentAccount.getProjects();
    }

    /**
     * Saves all accounts and projects to their respective JSON files.
     * @return true if all data was saved successfully.
     */
    public boolean saveData()
    {
        if (DataWriter.saveAccounts() && DataWriter.saveProjects())
            return true;
        return false;
    }

    // Account operations
    public boolean login(String username, String password)
    {
        Account temp = accountManager.login(username, password);
        if (temp == null)
            return false;
        currentAccount = temp;
        return true;
    }
    public void logout()
    {
        currentAccount = null;
        currentProject = null;
    }
    public boolean createAccount(String username, String password, String email, String firstName, String lastName)
    {
        return accountManager.createAccount(username, password, email, firstName, lastName);
    }
    public boolean deleteCurrentAccount()
    {
        if (currentAccount == null)
            return false;
        boolean removed = accountManager.deleteAccount(currentAccount);
        if (removed)
            currentAccount = null;
        return removed;
    }
    public boolean deleteAccount(Account account)
    {
        if (currentAccount.equals(account))
            logout();
        return accountManager.deleteAccount(account);
    }

    // Project Operations
    public void createProject(String title, Category category)
    {
        if (currentAccount == null)
            return;
        projectManager.createProject(title, category, currentAccount);  // Create a project with currentUser as the owner.
    }
    public boolean deleteCurrentProject()
    {
        if (currentProject == null)
            return false;
        boolean removed = projectManager.deleteProject(currentProject);
        if (removed)
            currentProject = null;
        return removed;
    }
    public void setCurrentProjectTitle(String title)
    {
        currentProject.setTitle(title);
    }

    // TODO more project operations.

    public boolean deleteProject(Project project)
    {
        return projectManager.deleteProject(project);
    }
}
