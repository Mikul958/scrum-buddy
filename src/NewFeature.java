package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Cade Phillips, Michael Pikula
 */
public class NewFeature extends Task
{
    private ArrayList<String> todo;
    private String reasoning;

    // Note to whoever is working on this:
    // Don't overcomplicate, use Bug class as a guideline.
    public NewFeature(String name, int priority, String reasoning)
    {
        super(name, priority);
        this.reasoning = reasoning;
        this.todo = new ArrayList<String>();
    }
    public NewFeature(UUID id, String name, int priority, String reasoning)
    {
        super(id, name, priority);
        this.reasoning = reasoning;
    }

    public String toString()
    {
        return "Name: " + name +
        "\nPriority: " + priority +
        "\nReasoning: " + reasoning;
    }
}
