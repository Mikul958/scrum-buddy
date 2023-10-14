package project;

import java.util.ArrayList;
import java.util.UUID;

public class Bug
{
    public int BUG_COUNT = 0;
    private String name;
    private int priority;
    private Account tester;
    private ArrayList<String> repoSteps;

    public Bug(String name, int priority, Account tester)
    {
        if(name != null){
            this.name = name;
        }
        else{
            this.name = "Bug"+BUG_COUNT;
            BUG_COUNT++;
        }
        if(priority < 0){
            this.priority = 0;
        }
        else{

        }

    }
    public Bug(UUID id, String name, int priority, Account tester)
    {
        
    }

    public String toString()
    {
        return null;
    }
    public boolean equals(Bug bug)
    {
        return false;
    }
}
