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
    /**
     * Get current list of projects.
     * @return the list of current projects.
     */
    public ArrayList<Project> getProjects()
    {
        return this.projects;
    }
    /**
     * Return a project based on it's UUID.
     * @param id of the project you are looking for.
     * @return object which has the same UUID as provided.
     */
    public Project getProjectByID(UUID id)
    {
        for (int i=0; i<projects.size(); i++)
        {
            if (id.equals(projects.get(i).getID()))
                return projects.get(i);
        }
        return null;
    }
    /**
     * If project does not contain a project with the same title then,
     * add a new project using the parameters.
     * @param title you want to name the project
     * @param category the project will be
     * @param owner tied to the creation of the project
     */
    public void addProject(String title, Category category, Account owner)
    {
        if(!containsProject(title)){        
            projects.add(new Project(title, category, owner)); 
        }
    }
    /**
     * Revove a particular project from the current list of projects.
     * @param projectName of the project to be removed
     */
    public void removeProject(String projectName)
    {
       if(containsProject(projectName)){
        projects.remove(findProject(projectName));
       }
    }
    public void viewProjectProgress()
    {
        //TODO
    }
    /**
     * Does a project 
     * @param title is the string name of the project
     * @return T/F if a project with the same name is contained within the list.
     */
    public boolean containsProject(String projectName){
        for(int i = 0; i < projects.size(); i++){
            Project temp = projects.get(i);
            if(temp.getTitle().equals(projectName)){
                return true;
            }
        }
        return false;
    }
    /**
     * Find a project based on name.
     * @param title name of the project your are looking for.
     * @return the apropriate project object.
     */
    public Project findProject(String projectName){
        for(int i = 0; i < projects.size(); i++){
            Project temp = projects.get(i);
            if(temp.getTitle().equals(projectName)){
                return temp;
            }
        }
        return null;
    }
}
