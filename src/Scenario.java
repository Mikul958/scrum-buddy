package src;

import java.util.ArrayList;
/**
 * @author Miles Wedeking
 */
public class Scenario {

    private ScrumSystem scrumsystem;

    void ScrumSystemUI(){
        scrumsystem = new ScrumSystem();
    }

    public void run(){
        //TODO scenario;
    }
    
    public void printProject(){

    }

    public void Scenario(){

        //Log in
        if(!scrumsystem.login("AtticusM", "AMad123!")){
            System.out.println("Error logging in user.");
            return;
        }
        System.out.println("Atticus Madden is now logged in");

        //Get projects
        ArrayList<Project> currentProjects = scrumsystem.getCurrentAccountProjects();

        //TODO
        //Open "Electric Missiles"
        // Prints basic project information
        /*
        Project currentProject = currentProjects.get(i);
        System.out.println("PROJECT " + currentProject.getTitle());
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
        */
        //Add a new task "Initialize super algorithm to detonate at warp speed". Assign the task to Jeff Goldblum.
        
        //Add a comment to the task "Avoid civilians Jeff!"

        //Move the existing task of "Curve the metal to make a cylindrical shape" to the 'Doing' column.
        //This task has the existing comments of "Not cylindrical enough" - by Jeff,
        //and "What's a cylinder" by Atticus Finch.  Reply to Jeff's comment and say "How about you do it jeff",
        //and re-assign the task from yourself to Jeff.

        //Add a new column called "Abandoned"

        //Move an existing task "Make impossible burger possible" which doesn't really relate to the project purpose to "Abandoned"

        //Now print the scrum board to a txt file.... make it pretty.


    }

    public static void main(String[] args){

    }

}
