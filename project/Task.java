package project;


//al pacicco

import java.util.ArrayList;
import java.util.UUID;

public abstract class Task {
    private UUID id;
    private String name;
    private int priority;
    private ArrayList<Comment> comments;
    private ArrayList<Edit> editHistory;


    public String toString()
    {
        return "";
    }

    public boolean equals(Task task)
    {
        return false;
    }
}
