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
        if(!scrumsystem.login("Atticus", "Madden")){
            System.out.println("Error logging in user.");
            return;
        }
        
        System.out.println("Atticus Madden is now logged in");

    }

    public static void main(String[] args){

    }

}
