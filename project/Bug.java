package project;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Al Pacicco
 */
public class Bug
{
    private Account tester;
    private ArrayList<String> repoSteps;

    public Bug(String name, int priority, Account tester)
    {

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
