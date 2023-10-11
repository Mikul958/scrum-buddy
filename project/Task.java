package project;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Al Pacicco
 */
public abstract class Task
{
    private UUID id;
    private String name;
    private int priority;
    private ArrayList<Comment> comments;
    private ArrayList<Edit> editHistory;

    public abstract String toString();
    public abstract boolean equals(Task task);
}
