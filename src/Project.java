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
     * Add an account as a contributor to a project.
     * @param account to be added to the list of contributors assigned on this project. 
     * If the account is not already on the list of contributors assigned to this project
     * then the account is added to the list of contributors.
     * 
     * If it is already on the list for any reason, 
     * then an error message is printed to the user.
     */
    public void addAccount(Account account)
    {
        if(containsUser(account.getUsername())){    
            contributors.add(account);              
        }
        else
            System.out.println("Account could not be added.");
    }
    /**
     * Remove an account as a contributor from a project.
     * @param account to be removed from the list of contributors assigned on this project. 
     *
     * Loops through the current list on contributors on this project.
     * If the specified account exists on the list of contributors, then it is removed.
     * Otherwise, if it is not on the list. Then an error message is printed for the user.
     */
    public void removeAccount(Account account)
    {
        if(containsUser(account.getUsername())){
            contributors.remove(account);
        }
        else    
            System.out.println("Account could not be removed.");    //Temp
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
     * @param userName of specified account
     * @return T/F if username was discovered 
     * in current list of contributors on this project.
     */
    public boolean containsUser(String userName){       
        for(int i = 0; i < contributors.size(); i++){   
            Account temp = contributors.get(i);         
            if(temp.getUsername().equals(userName)){
                return true;
            }
        }
        return false;
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
    /**
     * NEEDS TO BE ADDED TO THE UML *
     * @return the title of the project.
     */
    public String getTitle(){
        return this.title;
    }
}