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
        this.tasks = new ArrayList<Task>();
    }
    public Column(String title, ArrayList<Task> tasks)
    {
        this.title = title;
        this.tasks = tasks;
    }

    public String getTitle()
    {
        return this.title;
    }
    public ArrayList<Task> getTasks()
    {
        return this.tasks;
    }

    /**
     * Adds a task of the NewFeature type to the column.
     * @param name The name of the new feature.
     * @param priority The feature's relative priority.
     * @param reasoning The reasoning for the feature to be added.
     */
    public void addTask(String name, int priority)
    {
        Task newTask = new Task(name, priority);
        tasks.add(newTask);
    }
    public void addTask(Task task)
    {
        tasks.add(task);
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
    public boolean equals(Object column)
    {
        return column != null && this.getClass() == column.getClass()
            && this.getTitle().equals(((Column)column).getTitle());
    }
}
