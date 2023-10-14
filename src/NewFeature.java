package src;

import java.util.ArrayList;
import java.util.UUID;

public class NewFeature extends Task
{
    private ArrayList<String> todo;
    private String reasoning;

    // Note to whoever is working on this:
    // Don't overcomplicate, use Bug class as a guideline.
    public NewFeature(String name, int priority, String reasoning)
    {

    }
    public NewFeature(UUID id, String name, int priority, String reasoning)
    {

    }

    public UUID getID()
    {
        return this.id;
    }
    public String toString()
    {
        return null;
    }
    public boolean equals(Task task)
    {
        return false;
    }
}
