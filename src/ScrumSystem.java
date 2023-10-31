package src;

import java.util.ArrayList;

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

    public Account getCurrentAccount()
    {
        return this.currentAccount;
    }
    public Project getCurrentProject()
    {
        return this.currentProject;
    }
    public ArrayList<Account> getAllAccounts()
    {
        return accountManager.getAccounts();
    }
    public ArrayList<Project> getAllProjects()
    {
        return projectManager.getProjects();
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
    private Account getAccountByUsername(String username)
    {
        return accountManager.getAccountByUsername(username);
    }

    // Project Operations TODO creation, deletion, etc.
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
    public boolean deleteProject(Project project)
    {
        return projectManager.deleteProject(project);
    }
    public void changeProjectTitle(String title, Project project)
    {
        project.setTitle(title);
    }
    public boolean addColumnToProject(Project project, String columnTitle)
    {
        return project.addColumn(columnTitle);
    }
    public boolean removeColumnFromProject(Project project, String columnTitle)
    {
        return project.removeColumn(columnTitle);
    }
    public boolean addTaskToColumn(Project project, String columnTitle, String name, int priority)
    {
        return project.addTask(columnTitle, name, priority);
    }



    // TODO moved this from ProjectManager as project names are not meant to be unique, would likely work on a particular USER'S list of projects.
    /**
     * Retrieves a project from the list based on the entered name.
     * @param title Title of the account to be retrieved.
     * @return The project retrieved (null if no projects with the name exist).
     */
    /*
    public Project findProject(String projectName){
        for(int i = 0; i < projects.size(); i++){
            Project temp = projects.get(i);
            if(temp.getTitle().equals(projectName)){
                return temp;
            }
        }
        return null;
    }
    */
}
