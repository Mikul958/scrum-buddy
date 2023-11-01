package src;

import java.util.ArrayList;
/**
 * @author Miles Wedeking
 */
public class ScenarioUI
{
    public static void scenario(){

        ScrumSystem system = new ScrumSystem();

        //Log in
        //**********************************************************************
        if(!system.login("AtticusM", "AMad123!")){
            System.out.println("Error logging in user.");
            return;
        }
        System.out.println("Atticus Madden is now logged in.\n");
        //**********************************************************************
        //Get projects
        ArrayList<Project> currentProjects = system.getCurrentAccountProjects();
        //**********************************************************************
        //Open "Electric Missiles"





        // @author Miles W.
        // THIS IS WHERE I LEFT OFF 11/1 @ 9:19 AM
        // Currently the UI runs.
        // However, @ line 61,the list of current projects is empty. 
        // see the method:
        // ScrumSystem.getCurrentAccountProjects()

        /**
         * In other words, what I understand to be the case.
         * Is that, currently when the program runs, 
         * it goes to pull the list of current projects
         * from the current user's account. 
         * 
         * However, when it does that,
         * Atticus's project list is empty,
         * causing a IndexOutOfBounds exception on the next line
         * when the program tries to access that index.
         * 
         * In summary, 
         * The list of projects of the current user needs to already be loaded
         * before the next line executes.... 
         */
        system.openProject(currentProjects.get(0)); //Electric Missiles index
        System.out.println(getProjectInformation(system.getCurrentProject()));
        //**********************************************************************
        //Add a new task "Initialize super algorithm to detonate at warp speed".
        system.addProjectTask("Backlog", "Initialize super algorithm to detonate at warp speed", 0);
        System.out.println("Task added.\n");
        //**********************************************************************
        //Assign the task to Jeff Goldblum.
        // TODO nope
        //**********************************************************************
        //Add a comment to the task "Avoid civilians Jeff!"
        Task currentTask = system.getCurrentProject().getColumns().get(0).getTasks().get(2);
        system.addTaskComment(currentTask, "Avoid civilians Jeff!");
        System.out.println("Comment added.\n");
        //**********************************************************************


        //Move the existing task of "Curve the metal to make a cylindrical shape" to the 'Doing' column.
        //TODO
        //**********************************************************************
        //This task has the existing comments of "Not cylindrical enough" - by Jeff, and
        //"What's a cylinder" by Atticus Finch.  
        //Reply to Jeff's comment and say "How about you do it jeff", and
        //re-assign the task from yourself to Jeff.
        //**********************************************************************


        //Add a new column called "Abandoned"
        system.addProjectColumn("Abandoned");
        System.out.println("Category  \"Abandoned\" ");
        //**********************************************************************


        //Move an existing task "Make impossible burger possible" which doesn't really relate to the project purpose to "Abandoned"
        // TODO
        //Now print the scrum board to a txt file.... make it pretty.
        // TODO

        System.out.println(getProjectInformation(system.getCurrentProject()));

    }

    public static void main(String[] args)
    {
        scenario();
    }
    /**
     * Utilizes code from DataReader
     * @param project to gather information from.
     */
    private static String getProjectInformation(Project project)
    {
        String out = "";
        final String INDENT = "    ";
        
        out += ("-------------------------------------------\n");
        out += ("CURRENT PROJECT:\n");
        out += ("pID: " + project.getID() + "\n");
        out += ("Title: " + project.getTitle() + "\n");
        out += ("Category: " + project.getCategory() + "\n");
        out += ("Owner: " + project.getOwner().getUsername() + "\n");
        // Prints usernames of all contributors
        ArrayList<Account> projContributors = project.getContributors();
        out += ("CONTRIBUTORS:\n");
        for (int j = 0; j < projContributors.size(); j++)
            out += ("  - " + projContributors.get(j).getUsername() + "\n");
        // Prints columns and the basic information of all their tasks.
        ArrayList<Column> projColumns = project.getColumns();
        out += ("PROJECT COLUMNS:\n");
        for (int j=0; j<projColumns.size(); j++)
        {
            out += ("COLUMN " + (j+1) + "\n");
            out += (INDENT + "Title: " + projColumns.get(j).getTitle() + "\n");
            ArrayList<Task> colTasks = projColumns.get(j).getTasks();
            out += (INDENT + "TASKS:\n");
            for (int k=0; k<colTasks.size(); k++)
            {
                out += (INDENT + "TASK " + (k+1) + "\n");
                out += (INDENT + INDENT + "tID: " + colTasks.get(k).getID() + "\n");
                out += (INDENT + INDENT + "Name: " + colTasks.get(k).getName() + "\n");
                out += (INDENT + INDENT + "Priority: " + colTasks.get(k).getPriority() + "\n");
                out += (INDENT + INDENT + "COMMENTS:\n");
                for (int l=0; l<colTasks.get(k).getComments().size(); l++)
                    out += (INDENT + INDENT + "  - " + colTasks.get(k).getComments().get(l) + "\n");
            }
        }
        // Prints out comments in full.
        ArrayList<Comment> projComments = project.getComments();
        out += ("COMMENTS:\n");
        for (int j=0; j<projComments.size(); j++)
            out += ("  - " + projComments.get(j) + "\n");
        out += ("-------------------------------------------\n");

        return out;
    }
}
