package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * 
 * @author Miles Wedeking, Al Pacicco, Michael Pikula
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

    // Accessors

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
    /**
     * Counts the total number of tasks in this project.
     * @return The total number of tasks.
     */
    public int getTotalTasks()
    {
        int total = 0;

        // Loop through project columns, get task list for each column, add its size to total.
        for (int i=0; i<columns.size(); i++)
            total += columns.get(i).getTasks().size();
        return total;
    }
    /**
     * Gets the column from this project with the specified title.
     * @param columnTitle The title of the column to be returned.
     * @return The column with the specified title (null if none found).
     */
    public Column getColumnByTitle(String columnTitle)
    {
        for(int i=0; i<columns.size(); i++)
        {
            Column currentColumn = columns.get(i);
            if(currentColumn.getTitle().equals(columnTitle))
                return currentColumn;
        }
        return null;
    }
    

    /**
     * Checks if this project and the specified project are equivalent via their UUIDs.
     * @return true if the project IDs are equal.
     */
    @Override
    public boolean equals(Object project)
    {
        return project != null && this.getClass() == project.getClass()
            && id.equals(((Project)project).getID());
    }

    // Project progress
    // TODO this whole section lol

    /**
     * Prints and displays progression.
     */
    public void viewProgress()
    {
        System.out.println("There are currently "+totalProjectTasks+
        " associated with this project.");
    }
    /**
     * Returns T/F depending if the project is labeled as complete.
     * @return T/F depending if project is completed.
     */
    public boolean isProjectDone()
    {
        if(isComplete == true)
            return true;
        else
            return false;
    }
    /**
     * In order to label a projct as "complete"
     */
    public void completeProject(){
        this.isComplete = true;
    }

    // Contributors

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
     * @param account Account to be checked.
     * @return true if the specified account is in the list.
     */
    public boolean isContributor(Account account)
    {       
        for(int i=0; i<contributors.size(); i++)
        {   
            Account currentAccount = contributors.get(i);         
            if (currentAccount.equals(account))
                return true;
        }
        return false;
    }

    // Columns and tasks

    /**
     * Adds a column to the project with the specified title if a column with this title is not already in the project.
     * @param title Title of the new column.
     * @return true if the column was successfully added.
     */
    public boolean addColumn(String title)
    {
        for (int i=0; i<columns.size(); i++)
        {
            String currentColumnTitle = columns.get(i).getTitle();
            if (currentColumnTitle.equals(title))
                return false;
        }
        Column newColumn = new Column(title);
        columns.add(newColumn);
        return true;
    }
    /**
     * Add a column to a project after checking to make sure a column with that title is not already in the project.
     * @param column Column to be added to the project.
     * @return true if the column was successfully added.
     */
    public boolean addColumn(Column column)
    {
        for (int i=0; i<columns.size(); i++)
        {
            String currentColumnTitle = columns.get(i).getTitle();
            if (currentColumnTitle.equals(column.getTitle()))
                return false;
        }
        columns.add(column);
        return true;
    }
    /**
     * Removes the column with the specified title from the project.
     * @param title Title of the column to be removed.
     * @return true if a column with the specified title existed in the project.
     */
    public boolean removeColumn(String title)
    {
        for (int i=0; i<columns.size(); i++)
        {
            Column currentColumn = columns.get(i);
            if (title.equals(currentColumn.getTitle()))
                return columns.remove(currentColumn);
        }
        return false;
    }
    /**
     * Removes the specified column from the project.
     * @param column Column to be removed.
     * @return true if the specified column existed in the project.
     */
    public boolean removeColumn(Column column)
    {
        return columns.remove(column);
    }
    /**
     * Move a column's location
     * @param from index
     * @param to index
     * @return T/F
     */
    public boolean moveColumn(int from, int to)
    {  
        // TODO needs work.
        if (from < 0 || from >= columns.size() || to < 0 || to >= columns.size())
            return false;

        Column temp = columns.get(from);
        temp = columns.get(to);
        columns.remove(from);
        columns.set(to, temp);
        return true;
    }

    // TODO anything below here to comments.

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

    // Project comments

    /**
     * Add a comment to a project.
     * @param comment desired to be added.
     */
    public void addComment(Account user, String content)
    {
        Comment newComment = new Comment(user, content);
        comments.add(newComment);
    }
    /**
     * Remove a comment from a project.
     * @param comment desired to be removed.
     */
    public void removeComment(Comment comment)
    {
        comments.remove(comment);
    }
}