package src;

import java.util.UUID;
import java.util.ArrayList;

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
        if (projectManager == null)
            projectManager = new ProjectManager();
        return projectManager;
    }

    public ArrayList<Project> getProjects()
    {
        return this.projects;
    }
    public Project getProjectByID(UUID id)
    {
        for (int i=0; i<projects.size(); i++)
        {
            if (id.equals(projects.get(i).getID()))
                return projects.get(i);
        }
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
       
    }
   
   
   //Al Pacicco is working on this 
    public double viewProjectProgress(Project project)
    {
        //I'm thinking we track progress by 
        int totalTasks;
        int taskNum;

        return 0;
    }
    /**
     * 
     * @param title is the string name of the project
     * @return T/F if a project with the same name is contained within the list.
     */
    public boolean containsProject(String title){
        for(int i = 0; i < projects.size(); i++){
            Project temp = projects.get(i);
            if(temp.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }
    /**
     * Find a project based on name.
     * @param title name of the project your are looking for.
     * @return the apropriate project.
     */
    public Project findProject(String title){
        for(int i = 0; i < projects.size(); i++){
            Project temp = projects.get(i);
            if(temp.getTitle().equals(title)){
                return temp;
            }
        }
        return null;
    }
}
