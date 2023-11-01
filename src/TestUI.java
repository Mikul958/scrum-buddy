package src;

import java.util.ArrayList;

public class TestUI
{
    public static void main(String[] args)
    {
        // TESTING PROJECT LOADING AND ACCOUNT-TO-PROJECT LINKING
        ScrumSystem system = new ScrumSystem();
        
        // Changed so that it does not directly call loadProjects (caused problems with duplicate account linking when ProjectManager was initialized later)
        ProjectManager manager = ProjectManager.getInstance();
        ArrayList<Project> projects = manager.getProjects();
        String indent = "    ";
        System.out.println("-------------------------------------------");

        // Test project loading, prints all loaded projects.
        for (int i=0; i<projects.size(); i++)
        {
            // Prints basic project information
            Project currentProject = projects.get(i);
            System.out.println("PROJECT " + (i+1));
            System.out.println("pID: " + currentProject.getID());
            System.out.println("Title: " + currentProject.getTitle());
            System.out.println("Category: " + currentProject.getCategory());
            System.out.println("Owner: " + currentProject.getOwner().getUsername());

            // Prints usernames of all contributors
            ArrayList<Account> projContributors = currentProject.getContributors();
            System.out.println("CONTRIBUTORS:");
            for (int j=0; j<projContributors.size(); j++)
                System.out.println("  - " + projContributors.get(j).getUsername());
            
            // Prints columns and the basic information of all their tasks.
            ArrayList<Column> projColumns = currentProject.getColumns();
            System.out.println("PROJECT COLUMNS:");
            for (int j=0; j<projColumns.size(); j++)
            {
                System.out.println("COLUMN " + (j+1));
                System.out.println(indent + "Title: " + projColumns.get(j).getTitle());

                ArrayList<Task> colTasks = projColumns.get(j).getTasks();
                System.out.println(indent + "TASKS: ");
                for (int k=0; k<colTasks.size(); k++)
                {
                    System.out.println(indent + "TASK " + (k+1));
                    System.out.println(indent + indent + "tID: " + colTasks.get(k).getID());
                    System.out.println(indent + indent + "Name: " + colTasks.get(k).getName());
                    System.out.println(indent + indent + "Priority: " + colTasks.get(k).getPriority());
                }
            }

            // Prints out comments in full.
            ArrayList<Comment> projComments = currentProject.getComments();
            System.out.println("COMMENTS:");
            for (int j=0; j<projComments.size(); j++)
                System.out.println("  - " + projComments.get(j));

            System.out.println("-------------------------------------------");
        }


        // TESTING LOGINS AND PROJECT-TO-ACCOUNT LINKING

        // Test an account login, then print the names of all their projects.
        system.login("CadeAP", "Password123!?");
        Account currentAccount = system.getCurrentAccount();
        ArrayList<Project> currentProjects = currentAccount.getProjects();

        System.out.println("Current user:\n" + currentAccount);
        System.out.println("Their projects:");
        for (int i=0; i<currentProjects.size(); i++)
            System.out.println("  - " + currentProjects.get(i).getTitle());
        
        system.logout();

        // Test again with another account.
        system.login("APacicco", "123Password!");
        currentAccount = system.getCurrentAccount();
        currentProjects = currentAccount.getProjects();

        System.out.println("\nCurrent user:\n" + currentAccount);
        System.out.println("Their projects:");
        for (int i=0; i<currentProjects.size(); i++)
            System.out.println("  - " + currentProjects.get(i).getTitle());
        
        system.logout();

        // Test one last time with another account, this one should have Cade and Al's projects as it is a contributor to both.
        system.login("AtticusM", "AMad123!");
        currentAccount = system.getCurrentAccount();
        currentProjects = currentAccount.getProjects();

        System.out.println("\nCurrent user:\n" + currentAccount);
        System.out.println("Their projects:");
        for (int i=0; i<currentProjects.size(); i++)
            System.out.println("  - " + currentProjects.get(i).getTitle());
        
        system.logout();
    }
}
