package src;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Task
{
    protected UUID id;
    protected String name;
    protected int priority;
    protected ArrayList<Comment> comments;
    protected ArrayList<Edit> editHistory;

    protected Task(String name, int priority)
    {
        this.id = UUID.randomUUID();
        this.name = name;
        this.priority = priority;
        comments = new ArrayList<Comment>();
        editHistory = new ArrayList<Edit>();
    }
    protected Task(UUID id, String name, int priority)
    {
        this.id = id;
        this.name = name;
        this.priority = priority;
        comments = new ArrayList<Comment>();
        editHistory = new ArrayList<Edit>();
    }

    public abstract UUID getID();
    public abstract String toString();
    public abstract boolean equals(Task task);
}
