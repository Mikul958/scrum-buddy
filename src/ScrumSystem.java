package src;

import java.util.ArrayList;

public class ScrumSystem {
    private Account currentUser;
    private Project currentProject;

    public ScrumSystem()
    {
        
    }

    public void Login(String user, String pass)
    {
        currentUser = AccountManager.getInstance().getAccount(user, pass);
    }
    private Account enterUser()
    {
        return null;
    }
    private void enterPassword()
    {
        
    }
    private Account searchForAccount(String userName)
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
    public boolean createAccount(String firstName, String lastName, String email, String userName, String passWord){
        return AccountManager.getInstance().createAccount(firstName, lastName, email, userName, passWord);
    }
}
