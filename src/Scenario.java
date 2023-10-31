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
    
    public void Scenario(){

        //Log in
        if(!scrumsystem.login("AtticusM", "AMad123!")){
            System.out.println("Error logging in user.");
            return;
        }
        System.out.println("Atticus Madden is now logged in");

        //Get projects
        scrumsystem.getCurrentAccountProjects();

        //TODO
        //Open "Electric Missiles"

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
