package project;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Al Pacicco
 */
public class NewFeature extends Task
{
    private ArrayList<String> todo;
    private String reasoning;

    public NewFeature(String name, int priority, String reasoning)
    {

    }
    public NewFeature(UUID id, String name, int priority, String reasoning)
    {

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
