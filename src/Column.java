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
    public void addTask(String name, int priority)
    {
        Task newFeature = new Task(name, priority);
        tasks.add(newFeature);
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
    /**
     * @return the title of the category.
     */
    public String getTitle(){
        return this.title;
    }
}
