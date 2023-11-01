package src;

import java.util.ArrayList;

public class TestUI
{
    public static void main(String[] args)
    {
        System.out.println();
        
        ScrumSystem system = new ScrumSystem();


        if (system.login("AtticusM", "AMad123!"))
            System.out.println("Login successful:\n" + system.getCurrentAccount());
        else
        {
            System.out.println("Nah");
            System.exit(0);
        }
        Account currentAccount = system.getCurrentAccount();

        ArrayList<Project> currentProjects = system.getCurrentAccountProjects();
        System.out.println("\n" + currentAccount.getUsername() + "'s Projects:");
        for (int i=0; i<currentProjects.size(); i++)
            System.out.println((i+1) + ". " + currentProjects.get(i).getTitle());

        system.openProject(currentProjects.get(0));
        Project currentProject = system.getCurrentProject();
        System.out.println("Opened project: " + currentProject.getTitle());

        System.out.println();

        Column currentCol = currentProject.getColumns().get(0);
        System.out.println(currentCol.getTitle());

        for (int i=0; i<currentCol.getTasks().size(); i++)
            System.out.println("  - " + currentCol.getTasks().get(i).getName());

        System.out.println();

        Task currentTask = currentCol.getTasks().get(0);
        System.out.println("Current task: " + currentTask.getName());
        
        System.out.println("Comments:");
        for (int i=0; i<currentTask.getComments().size(); i++)
            System.out.println("  - " + currentTask.getComments().get(i));

        system.saveData();
        
    }
}
