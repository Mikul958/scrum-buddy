package src;

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
        Task newFeature = new NewFeature(name, priority, reasoning);
        tasks.add(newFeature);
    }
    public void addBug(String name, int priority, Account tester)
    {
        Task newBug = new Bug(name, priority, tester);
        tasks.add(newBug);
    }
    public void removeTask(Task task)
    {
        tasks.remove(task);
    }
    public String toString()
    {
        String out = "Column: " + title;
        for (int i=0; i< tasks.size(); i++)
            title += "\n" + tasks.get(i);
        return out;
    }
}
