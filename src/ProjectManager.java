package src;

import java.util.ArrayList;
import java.util.Locale.Category;
/**
 * ProjectManager class
 * @author Miles Wedeking
 * 
 */
public class ProjectManager
{
    private static ProjectManager projectManager;
    private ArrayList<Project> projects;

    /**
     * Creates a new instance of AccountManager, and can only be called once.
     */
    private ProjectManager()
    {
        projects = DataReader.loadProjects();
    }
    /**
     * Returns the current instance of ProjectManager or creates one if it does not yet exist.
     * @return An instance of ProjectManager.
     */
    public static ProjectManager getInstance()
    {
        if(projectManager == null)
            projectManager = new ProjectManager();
        return null;
    }
   
    public void addProject(String title, Category category, Account owner)
    {
        if(!containsProject(title)){        //If project does not contain a project with the same title then,
            projects.add(new Project(title, category, owner));  //add a new project using the parameters.
        }
    }
    public void removeProject(Project project)
    {
        //TODO Should we change:    addProject(title, category, owner)
        //                       
        //instead to:               addProject(Project project)
        //
        //That way, removeProject and addProject can function similarly??
    }
    public double viewProjectProgress(Project project)
    {
        //TODO How are we going to track progress?
        return 0.0;
    }
    
    public boolean containsProject(String title){
        for(int i = 0; i < projects.size(); i++){
            Project temp = projects.get(i);
            if(temp.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }
}
