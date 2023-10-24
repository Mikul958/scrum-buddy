package src;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Locale.Category;
/**
 * @author Miles Wedeking
 *
 */
public class Project
{
    private UUID id;
    private String title;
    private Category category;
    private Account owner;
    private ArrayList<Account> contributors;
    private ArrayList<Column> columns;
    private ArrayList<Comment> comments;

    public Project(String title, Category category, Account owner)
    {
        this.id = UUID.randomUUID();
        this.title = title;
        this.category = category;
        this.owner = owner;
        contributors = new ArrayList<Account>();
        columns = new ArrayList<Column>();
        comments = new ArrayList<Comment>();
    }
    public Project(UUID id, String title, Category category, Account owner)
    {
        this.id = id;
        this.title = title;
        this.category = category;
        this.owner = owner;
        contributors = new ArrayList<Account>();
        columns = new ArrayList<Column>();
        comments = new ArrayList<Comment>();
    }

    public UUID getID()
    {
        return this.id;
    }
    public String getTitle()
    {
        return this.title;
    }

    public boolean equals(Project project)
    {
        return project != null && id.equals(project.getID());
    }
    public void setCategory(Category category)
    {
        this.category = category;       //Good?
    }
    public double viewProgress()
    {
        //TODO See below...
        return 0.0;
    }
    public boolean isProjectDone()
    {
        //TODO How are we going to track progress?
        return false;
    }
    /**
     * Add the specified account as a contributor to a project if account is not already a contributor.
     * @param account Account to be added.
     * @return true if the specified account was added successfully.
     */
    public boolean addContributor(Account account)
    {
        if (isContributor(account))
            return false;
        contributors.add(account);
        return true;
    }
    /**
     * Remove the specified account as a contributor from a project.
     * @param account Account to be removed.
     * @return true if the specified account was in the list of contributors.
     */
    public boolean removeContributor(Account account)
    {
        return contributors.remove(account);
    }
    /**
     * Checks to see if the specified account is in the list of contributors.
     * @param account Account to be added.
     * @return true if the specified account is in the list.
     */
    public boolean isContributor(Account account)
    {       
        for(int i=0; i<contributors.size(); i++)
        {   
            Account temp = contributors.get(i);         
            if (temp.equals(account))
                return true;
        }
        return false;
    }
    /**
     * Adds a column to the project
     * @param name of the project.
     */
    public void addColumn(String name)
    {
        Column temp = new Column(name);
        columns.add(temp);
    }

    public void moveColumnAfter(Column column)
    {
        //TODO
    }
    /**
     * Removes a column from the project
     * @param column column to be removed
     */
    public void removeColumn(Column column)
    {
        if(containsColumn(column.getTitle())){
            columns.remove(column);
        }
        else
            System.out.println("Column could not be removed.");     //Temp 
    }
    public void addTask(Column column, String name, int priority)
    {
        for(int i = 0; i < columns.size(); i++){
            Column temp = columns.get(i);
            if(temp == column){
                //TODO Left off here
                //Not sure if we want to use a parameter to define type???
                //Otherwise,
                //How can I access column[i].tasks[j] etc. (pseudo)
                //Aiming for something like what is below:
                //
                //If(temp == column){
                //  columns.get(i).addTask(name, priority);
                //}
            }                                                           
        }
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
    /**
     * NEEDS TO BE ADDED TO UML *
     * @param columnName of specified column
     * @return T/F if username was discovered  
     * in current list of columns on this project.
     */
    public boolean containsColumn(String columnName){
        for(int i = 0; i < columns.size(); i++){
            Column temp = columns.get(i);
            if(temp.getTitle().equals(columnName)){
                return true;
            }
        }
        return false;
    }
}