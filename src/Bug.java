package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Miles Wedeking, Michael Pikula
 */
public class Bug extends Task
{
    private Account tester;
    private ArrayList<String> reproSteps;  // Need to learn what the hell this is from portia

    public Bug(String name, int priority, Account tester)
    {
        super(name, priority);
        this.tester = tester;
        this.reproSteps = new ArrayList<String>();
    }
    public Bug(UUID id, String name, int priority, Account tester)
    {
        super(id, name, priority);
        this.tester = tester;
        this.reproSteps = new ArrayList<String>();
    }

    public String toString()
    {
        String out = "Name: " + name + "\nPriority: " + priority + "\nTester: " + tester;
        if (reproSteps.size() > 0)
            out += "\nReproduction Steps: ";
        for (int i=0; i<reproSteps.size(); i++)
            out += "\n- " + reproSteps.get(i);
        return out;
    }
    public void addReproStep(String reproStep)
    {
        reproSteps.add(reproStep);
    }
    public boolean removeReproStep(String reproStep)
    {
        return reproSteps.remove(reproStep);
    }
}
