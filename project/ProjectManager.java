package project;

import java.util.ArrayList;
import java.util.Locale.Category;

public class ProjectManager
{
    private static ProjectManager projectManager;
    private ArrayList<Project> projects;

    private ProjectManager()
    {

    }
    public static ProjectManager getInstance()
    {
        return null;
    }

    public void addProject(String title, Category category, Account owner)
    {

    }
    public void removeProject(Project project)
    {

    }
    public double viewProjectProgress(Project project)
    {
        return 0.0;
    }  
}
