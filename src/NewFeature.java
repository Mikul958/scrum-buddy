package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Cade Phillips, Michael Pikula
 */
public class NewFeature extends Task
{
    private ArrayList<String> todoList;
    private String reasoning;

    public NewFeature(String name, int priority, String reasoning)
    {
        super(name, priority);
        this.todoList = new ArrayList<String>();
        this.reasoning = reasoning;
    }
    public NewFeature(UUID id, String name, int priority, String reasoning)
    {
        super(id, name, priority);
        this.todoList = new ArrayList<String>();
        this.reasoning = reasoning;
    }

    public String toString()
    {
        String out =  "Name: " + name + "\nPriority: " + priority + "\nReasoning: " + reasoning;
        if (todoList.size() > 0)
            out += "To-Do: ";
        for (int i=0; i<todoList.size(); i++)
            out += "\n- " + todoList.get(i);
        return out;
    }
    public void addTodo(String item)
    {
        todoList.add(item);
    }
    public boolean removeTodo(String item)
    {
        return todoList.remove(item);
    }
}
