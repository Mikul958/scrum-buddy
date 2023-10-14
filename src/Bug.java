package src;

import java.util.ArrayList;
import java.util.UUID;

public class Bug
{
    public int BUG_COUNT = 0;   //Global bug count;
    private String name;
    private int priority;
    private Account account;
    private ArrayList<String> repoSteps;

    public Bug(String name, int priority, Account account)
    {
        //Name
        if(name != null){   //TODO name isValid() method.
            this.name = name;
            BUG_COUNT++;
        }
        else{
            this.name = "Bug"+BUG_COUNT;
            BUG_COUNT++;
        }

        //Priority
        if(priority < 0){
            this.priority = 0;
        }
        else{
            this.priority = priority;
        }

        //Account
        if(account != null){    //TODO account isValid() method.
            this.account = account;
        }
        else{
            this.account = null;
        }

    }
    public Bug(UUID id, String name, int priority, Account tester)
    {
        //TODO Need Mike's help here <-
    }

    public String toString()
    {
        return "Name: "+name+
        "\nPriority: "+priority+
        "\nAccount: "+account;
    }
    
    public boolean equals(Bug bug)
    {
        if(name == bug.getName(bug)){
            return true;
        }
        else{
            return false;
        }
    }

    public String getName(Bug bug){
        return this.name;
    }
}
