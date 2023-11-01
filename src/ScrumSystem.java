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

    /**
     * Creates a project with the specified title and category and assigns currentUser as owner.
     * @param title The title of the new project.
     * @param category The category of the new project.
     */
    public void createProject(String title, Category category)
    {
        if (currentAccount == null)
            return;
        projectManager.createProject(title, category, currentAccount);  // Create a project with currentUser as the owner.
    }
    /**
     * Deletes the current project and unlinks all accounts.
     * @return true if the project was successfully deleted.
     */
    public boolean deleteProject()
    {
        boolean removed = projectManager.deleteProject(currentProject);
        if (removed)
            currentProject = null;
        return removed;
    }
    /**
     * Sets the title of the current project to the specified title.
     * @param title New title of the project.
     */
    public void setProjectTitle(String title)
    {
        currentProject.setTitle(title);
    }
    /**
     * Sets the category of the current project to the specified category.
     * @param category New category of the project, must be obtained from string or int before calling.
     */
    public void setProjectCategory(Category category)
    {
        currentProject.setCategory(category);
    }
    /**
     * Adds the account with the entered username as a contributor to the current project, if the account exists and is not already a contributor.
     * @param username The username of the account to be added.
     * @return true if the account with the entered username exists and was added successfully.
     */
    public boolean addProjectContributor(String username)
    {
        Account toAdd = accountManager.getAccountByUsername(username);
        if (toAdd == null)
            return false;
        return currentProject.addContributor(toAdd);
    }
    /**
     * Removes the account with the entered username as a contributor from the current project, if the account exists and is currently a contributor.
     * @param username The username of the account to be removed.
     * @return true if the account with the entered username exists and is in the list of contributors.
     */
    public boolean removeProjectContributor(String username)
    {
        Account toRemove = accountManager.getAccountByUsername(username);
        if (toRemove == null)
            return false;
        return currentProject.removeContributor(toRemove);
    }
    /**
     * Adds a column with the specified title to the current project, if a column with that title doesn't already exist.
     * @param columnTitle The title of the new column.
     * @return true if the column was successfully added.
     */
    public boolean addProjectColumn(String columnTitle)
    {
        return currentProject.addColumn(columnTitle);
    }
    /**
     * Removes the column with the specified title from the current project, if it exists.
     * @param columnTitle The title of the column to be removed.
     * @return true if a column with the specified title existed in the project.
     */
    public boolean removeProjectColumn(String columnTitle)
    {
        return currentProject.removeColumn(columnTitle);
    }
    /**
     * Moves the column at index from to index to, shifting all other columns as necessary.
     * @param from The index of the column to be moved.
     * @param to The index that the column will be moved to.
     * @return true if the column was successfully moved.
     */
    public boolean moveColumn(int from, int to)
    {
        return currentProject.moveColumn(from, to);
    }


    // TODO more project operations.
}
