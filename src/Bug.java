package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Miles Wedeking, Michael Pikula
 */
public class Bug extends Task
{
    private Account tester;
    private ArrayList<String> repoSteps;  // Need to learn what the hell this is from portia

    public Bug(String name, int priority, Account tester)
    {
        super(name, priority);
        this.tester = tester;
        this.repoSteps = new ArrayList<String>();
    }
    public Bug(UUID id, String name, int priority, Account tester)
    {
        super(id, name, priority);
        this.tester = tester;
        this.repoSteps = new ArrayList<String>();
    }

    public String toString()
    {
        return "Name: " + name +
        "\nPriority: " + priority +
        "\nTester: " + tester;
    }
}
