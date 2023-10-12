package src;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Locale.Category;

/**
 * @author Cade Phillips
 */
public class Project
{
    private UUID id;
    private String title;
    private Category category;
    private Account owner;
    private ArrayList<Account> contributors;
    private ArrayList<Column> columns;
    private ArrayList<Comment> comment;
    private ArrayList<Edit> editHistory;

    public Project(String title, Category category, Account owner)
    {

    }
    public Project(UUID id, String title, Category category, Account owner)
    {

    }

    public void setCategory(Category category)
    {

    }
    public double viewProgress()
    {
        return 0.0;
    }
    public boolean isProjectDone()
    {
        return false;
    }
    public void addAccount(Account account)
    {

    }
    public void removeAccount(Account account)
    {

    }
    public void addColumn(String name)
    {

    }
    public void moveColumnAfter(Column column)
    {
        
    }
    public void removeColumn(Column column)
    {
        
    }
    public void addTask(Column column, String name, int priority)
    {

    }
    public void removeTask(Column column, Task task)
    {

    }
    public void moveTask(Task task, Column column)
    {

    }
    public void orderTask(Task task, int Priority)
    {

    }
}