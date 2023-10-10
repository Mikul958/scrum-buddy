package project;
import java.util.UUID;
/**
 * @author Miles Wedeking
 */
public class Account{
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String passWord;
    private boolean isVerified;
    private ArrayList<Project> projects;
    //Constructor
    public Account(String firstName, String lastName, String userName, String passWord){

    }
    //This is a duplicate constructor, this one is including a UUID id
    //There are two constructors on the UML Diagram... 
     public Account(UUID id, String firstName, String lastName, String userName, String passWord){
        
    }

    public void verifyAccount(){

    }

    public String toString(){

    }

    public boolean equals(Account account){

        return false;
    }
}