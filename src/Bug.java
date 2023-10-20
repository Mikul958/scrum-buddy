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
    
    /**
     * Creates a new bug and assigns it a new UUID.
     * @param name The name of the bug.
     * @param priority The relative priority of the bug.
     * @param tester The user that found the bug.
     */
    public Bug(String name, int priority, Account tester)
    {
        super(name, priority);
        this.tester = tester;
        this.reproSteps = new ArrayList<String>();
    }
    /**
     * Creates a bug using an existing UUID stored in a file.
     * @param id A java Universally Unique Identifier (UUID) loaded from a save file.
     * @param name The name of the bug.
     * @param priority The relative priority of the bug.
     * @param tester The user that found the bug.
     */
    public Bug(UUID id, String name, int priority, Account tester)
    {
        super(id, name, priority);
        this.tester = tester;
        this.reproSteps = new ArrayList<String>();
    }

    /**
     * Creates a string representation of a bug.
     * @return A string containing the bug;s name, priority, tester, and any reproduction steps.
     */
    public String toString()
    {
        String out = "Name: " + name + "\nPriority: " + priority + "\nTester: " + tester;
        if (reproSteps.size() > 0)
            out += "\nReproduction Steps: ";
        for (int i=0; i<reproSteps.size(); i++)
            out += "\n- " + reproSteps.get(i);
        return out;
    }

    /**
     * Adds a reproduction step to the list.
     * @param reproStep The reproduction step to be added.
     */
    public void addReproStep(String reproStep)
    {
        reproSteps.add(reproStep);
    }
    /**
     * Removes the specified reproduction step from the list.
     * @param reproStep The reproduction step to be removed.
     * @return true if the specified reproduction step existed in the list.
     */
    public boolean removeReproStep(String reproStep)
    {
        return reproSteps.remove(reproStep);
    }
}
