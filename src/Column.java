package src;

import java.util.ArrayList;

/**
 * A column of the Scrum Board within a specified project.
 * @author Al Pacicco & Michael Pikula
 */
public class Column
{
    private String title;
    private ArrayList<Task> tasks;

    /**
     * Creates a column with the specified title and initializes its list of tasks.
     * @param title The specified title of the column.
     */
    public Column(String title)
    {
        this.title = title;
        tasks = new ArrayList<Task>();
    }

    /**
     * Adds a task of the NewFeature type to the column.
     * @param name The name of the new feature.
     * @param priority The feature's relative priority.
     * @param reasoning The reasoning for the feature to be added.
     */
    public void addNewFeature(String name, int priority, String reasoning)
    {
        Task newFeature = new NewFeature(name, priority, reasoning);
        tasks.add(newFeature);
    }
    /**
     * Adds a task of the Bug type to the column.
     * @param name The name of the bug.
     * @param priority The bug's relative priority.
     * @param tester The user that found the bug and is responsible for testing it.
     */
    public void addBug(String name, int priority, Account tester)
    {
        Task newBug = new Bug(name, priority, tester);
        tasks.add(newBug);
    }
    /**
     * Removes the specified task from the column.
     * @param task The task to be removed from the column.
     * @return true if the specified task exists in the column.
     */
    public boolean removeTask(Task task)
    {
        return tasks.remove(task);
    }
    /**
     * Returns a string representation of the column.
     * @return A string containing the column's title and all of its tasks.
     */
    public String toString()
    {
        String out = "Column: " + title;
        for (int i=0; i< tasks.size(); i++)
            title += "\n" + tasks.get(i);
        return out;
    }
}
