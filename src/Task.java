package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Al Pacicco, Michael Pikula
 */
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

    public UUID getID()
    {
        return id;
    }

    public abstract String toString();

    public boolean equals(Task task)
    {
        return id.equals(task.getID());
    }
    public void addComment(Account user, String content)
    {
        Comment newComment = new Comment(user, content);
        comments.add(newComment);
    }
    public boolean deleteComment(Comment comment)
    {
        return comments.remove(comment);
    }
    public void addEdit(Account editor, String description)
    {
        Edit newEdit = new Edit(editor, description);
        editHistory.add(newEdit);
    }
}