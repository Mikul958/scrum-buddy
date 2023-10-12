package project;

import java.util.ArrayList;

/**
 * @author Al Pacicco & Michael Pikula
 */
public class Column
{
    private String title;
    private ArrayList<Task> tasks;

    public Column(String title)
    {
        this.title = title;
        tasks = new ArrayList<Task>();
    }

    public void addNewFeature(String name, int priority, String reasoning)
    {
        // TODO figure out parameters
    }
    public void addBug(String name, int priority, Account testerAccount)
    {
        // TODO figure out parameters
    }
    public void removeTask(Task task)
    {
        for (int i=0; i<tasks.size(); i++)
        {
            if (tasks.get(i).equals(task))
                tasks.remove(i);
        }
    }
    public String toString()
    {
        String out = "Column: " + title;
        for (int i=0; i< tasks.size(); i++)
            title += "\n" + tasks.get(i);
        return out;
    }
}
