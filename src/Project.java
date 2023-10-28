package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Miles Wedeking and Al Pacicco
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
    private boolean isComplete = false;     //Labels the project as "incomplete"
    private int totalProjectTasks;

    /**
     * Creates a fresh project with the specified basic information and handles Account-Project linking.
     * @param title The title of the new project.
     * @param category The category of the new project.
     * @param owner The account creating the new project.
     */
    public Project(String title, Category category, Account owner)
    {
        this.id = UUID.randomUUID();
        this.title = title;
        this.category = category;
        this.owner = owner;
        contributors = new ArrayList<Account>();
        
        // Add owner to list of contributors and this project to owner's project list.
        contributors.add(owner);
        owner.addProject(this);

        columns = new ArrayList<Column>();
        comments = new ArrayList<Comment>();
    }
    /**
     * Creates a project with existing contributors, columns, and comments and handles Account-Project linking. Used when loading project from file.
     * @param id The Java UUID of the project.
     * @param title The title of the project.
     * @param category The category of the project.
     * @param owner The account that created the project.
     * @param contributors The list of all contributors to the project, including the owner.
     * @param columns The list of all of the project's columns.
     * @param comments The list of all comments on the project.
     */
    public Project(UUID id, String title, Category category, Account owner, ArrayList<Account> contributors, ArrayList<Column> columns, ArrayList<Comment> comments)
    {
        this.id = id;
        this.title = title;
        this.category = category;
        this.owner = owner;

        // Link contributors with project.
        this.contributors = contributors;
        for (int i=0; i<contributors.size(); i++)
            contributors.get(i).addProject(this);

        this.columns = columns;
        this.comments = comments;
    }

    public UUID getID()
    {
        return this.id;
    }
    public String getTitle()
    {
        return this.title;
    }
    public Category getCategory()
    {
        return this.category;
    }
    public Account getOwner()
    {
        return this.owner;
    }
    public ArrayList<Account> getContributors()
    {
        return this.contributors;
    }
    public ArrayList<Column> getColumns()
    {
        return this.columns;
    }
    public ArrayList<Comment> getComments()
    {
        return this.comments;
    }

    @Override
    public boolean equals(Object project)
    {
        return project != null && this.getClass() == project.getClass()
            && id.equals(((Project)project).getID());
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
    public void addColumn(Column column)
    {
        columns.add(column);
    }
    public boolean moveColumn(int from, int to)
    {
        if(from < 0 || from > columns.size() -1 || to > columns.size()-1 || to < 0)
        {
            return false;
        }else {
            
            Column temp = columns.get(from);
            temp = columns.get(to);
            columns.remove(from);
            columns.set(to, temp);
            return true;
        }
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
    public void addComment(Comment comment)
    {
        comments.add(comment);
    }
    public void removeComment(Comment comment)
    {
        comments.remove(comment);
    }
    /**
     * Add a task too a project.
     * See findColumn method below.
     * @param columnName the user wants add the task too.
     * @param taskName the name of the new task.
     * @param taskPriority of the new task.
     */
    public void addTask(String columnName, String taskName, int taskPriority)
    {
        findColumn(columnName).addTask(taskName, taskPriority);
    }
    /**
     * Remove a task from a project.
     * See findColumn method below.
     * @param columnName the user wants to add the task too.
     * @param taskName the name of the new task.
     * @param taskPriority the priority of the new task.
     */
    public void removeTask(String columnName, String taskName, int taskPriority)
    {
        findColumn(columnName).removeTask(taskName, taskPriority);
    }
    /**
     * This class uses the column object add/remove functions.
     * @param task the object task that is to be moved.
     * @param columnNameTo name of the destination column.
     * @param columnNameFrom name of the origination column.
     */
    public void moveTask(Task task, String columnNameTo, String columnNameFrom)
    {
        findColumn(columnNameFrom).removeTask(task);    
        findColumn(columnNameTo).addTask(task);
    }
    public void orderTask(String taskName, int taskPriority)
    {
        //TODO
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
     * @author Miles Wedeking
     * Made this to help with uniformity of adding and removing tasks.
     * @param columnName of column that task will be added too.
     * @return the column object that the task will be added to.
     */
    public Column findColumn(String columnName){
        for(int i = 0; i < columns.size(); i++){ //Loop the list of columns.
            Column temp = columns.get(i);        //Temp column for ea. index.
            if(temp.getTitle().equals(columnName)){ //If temp == our desired column name.
                return temp;                        //Then return it.
            }
        }
        return null;                            //Otherwise return nothing.
    }
    /**
     * In order to label a projct as "complete"
     */
    public void completeProject(){
        this.isComplete = true;
    }
    /**
     * Counts the total number of tasks that exist within the project.
     * Does so, by looping throuh each column,
     * then, it loops that column and counts each task.
     */
    public void countTotalTasks(){
        for(int i = 0; i < columns.size(); i++){    //for each column
            Column temp = columns.get(i);           //current temp column
           for(int j = 0; j < temp.countTotalTasks(); j++){ //each task of that column
                totalProjectTasks++;
           }
        }
    }
}