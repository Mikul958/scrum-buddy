package src;

import java.util.ArrayList;

public class TestUI
{
    public static void main(String[] args)
    {
        ScrumSystem system = new ScrumSystem();

        system.login("MPikula1", "Apple456##");

        ArrayList<Project> projects = system.getCurrentAccountProjects();
        System.out.println("Projects:");
        for (int i=0; i<projects.size(); i++)
            System.out.println(projects.get(i).getTitle());

        system.createProject("test", Category.OTHER);

        projects = system.getCurrentAccountProjects();
        System.out.println("Projects again:");
        for (int i=0; i<projects.size(); i++)
            System.out.println(projects.get(i).getTitle());
    }
}
