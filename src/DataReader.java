package src;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * A class responsible for loading information from the application's JSON files.
 * @author Michael Pikula
 */
public class DataReader extends DataConstants
{
    /**
     * Reads all accounts from Accounts.json and adds them to a system-wide ArrayList.
     * @return The list of all accounts system-wide.
     */
    public static ArrayList<Account> loadAccounts()
    {
        ArrayList<Account> accounts = new ArrayList<Account>();

        try
        {
            FileReader reader =  new FileReader(ACCOUNTS_FILE);
            JSONParser parser = new JSONParser();
            JSONArray accountsJSON = (JSONArray)(parser.parse(reader));

            for (int i=0; i<accountsJSON.size(); i++)
            {
                JSONObject accountJSON =  (JSONObject)accountsJSON.get(i);
                String username = (String)accountJSON.get(USERNAME);
                String password = (String)accountJSON.get(PASSWORD);
                String email = (String)accountJSON.get(EMAIL);
                String firstName = (String)accountJSON.get(FIRST_NAME);
                String lastName = (String)accountJSON.get(LAST_NAME);

                Account newAccount = new Account(username, password, email, firstName, lastName);
                accounts.add(newAccount);
            }
            return accounts;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    // Okay to use AccountManager while loading projects because Accounts are loaded in its constructor and have no dependencies.
    private static AccountManager manager = AccountManager.getInstance();
    private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd 'at' HH:mm:ss");
    
    /**
     * Reads all projects from Projects.json, builds them, and adds them to a system-wide ArrayList.
     * @return The list of all projects system-wide.
     */
    public static ArrayList<Project> loadProjects()
    {
        ArrayList<Project> projects = new ArrayList<Project>();

        // Load in tasks to build columns later.
        ArrayList<Task> tasks = loadTasks();

        try
        {
            FileReader reader = new FileReader(PROJECTS_FILE);
            JSONParser parser = new JSONParser();
            JSONArray projectsJSON = (JSONArray)(parser.parse(reader));

            for (int i=0; i<projectsJSON.size(); i++)
            {
                // Load basic information and create new project.
                JSONObject projectJSON = (JSONObject)projectsJSON.get(i);

                UUID id = UUID.fromString((String)projectJSON.get(PROJECT_ID));
                String title = (String)projectJSON.get(PROJECT_TITLE);

                String categoryName = (String)projectJSON.get(PROJECT_CATEGORY);
                Category category = stringToCategory(categoryName);

                String ownerName = (String)projectJSON.get(PROJECT_OWNER);
                Account owner = manager.getAccountByUsername(ownerName);
                if (owner == null)
                    continue;

                // Load project contributors and store them in an ArrayList.
                JSONArray contributorsJSON = (JSONArray)projectJSON.get(PROJECT_CONTRIBUTORS);
                ArrayList<Account> contributors = loadContributors(contributorsJSON);

                // Get list of columns from JSON, send to method to populate columns with information, and store them in an ArrayList.
                JSONArray columnsJSON = (JSONArray)projectJSON.get(PROJECT_COLUMNS);
                ArrayList<Column> columns = buildColumns(columnsJSON, tasks);

                // Load project comments and store them in an ArrayList.
                JSONArray commentsJSON = (JSONArray)projectJSON.get(COMMENTS);
                ArrayList<Comment> comments = loadComments(commentsJSON);

                // Create new project with above information and add it to the list of projects (account linking is handled already).
                Project newProject = new Project(id, title, category, owner, contributors, columns, comments);
                projects.add(newProject);
            }
            return projects;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Reads all tasks from Tasks.json and adds them to a system-wide ArrayList.
     * @return The list of all Tasks system-wide.
     */
    private static ArrayList<Task> loadTasks()
    {
        ArrayList<Task> tasks = new ArrayList<Task>();
        
        try
        {
            FileReader reader = new FileReader(TASKS_FILE);
            JSONParser parser = new JSONParser();
            JSONArray tasksJSON = (JSONArray)(parser.parse(reader));

            for (int i=0; i<tasksJSON.size(); i++)
            {
                // Load basic task information.
                JSONObject taskJSON = (JSONObject)tasksJSON.get(i);
                UUID id = UUID.fromString((String)taskJSON.get(TASK_ID));
                String name = (String)taskJSON.get(TASK_NAME);
                int priority = (int)(long)taskJSON.get(TASK_PRIORITY);

                // Load comments.
                JSONArray commentsJSON = (JSONArray)taskJSON.get(COMMENTS);
                ArrayList<Comment> comments = loadComments(commentsJSON);

                // Load edit history.
                JSONArray editsJSON = (JSONArray)taskJSON.get(TASK_EDITS);
                ArrayList<Edit> edits = loadEdits(editsJSON);

                // Add new task to the list of tasks.
                Task newTask = new Task(id, name, priority, comments, edits);
                tasks.add(newTask);
            }
            return tasks;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Takes in a string and returns its corresponding category.
     * @param category A string representing a project category.
     * @return A category corresponding to the input string. Returns Category.OTHER if no matches.
     */
    private static Category stringToCategory(String category)
    {
        for (Category i : Category.values())
        {
            if (i.description.equalsIgnoreCase(category))
                return i;
        }
        return Category.OTHER;
    }
    /**
     * Takes in a JSONArray of contributor usernames and returns the list of corresponding accounts.
     * @param contributorsJSON A JSONArray containing the usernames of accounts contributing to a project.
     * @return An ArrayList of Accounts that are contributors to a project.
     */
    private static ArrayList<Account> loadContributors(JSONArray contributorsJSON)
    {
        ArrayList<Account> contributors = new ArrayList<Account>();
        for (int i=0; i<contributorsJSON.size(); i++)
        {
            String contributorName = (String)contributorsJSON.get(i);
            Account contributor = manager.getAccountByUsername(contributorName);
            if (contributor == null)
                continue;
            contributors.add(contributor);
        }
        return contributors;
    }
    /**
     * Builds all the columns of a project based on a JSONArray of columns.
     * @param columnsJSON A JSONArray of columns, containing objects with a title and a JSONArray of task UUIDs.
     * @param tasks The system-wide list of tasks, obtained via DataReader.loadTasks().
     * @return An ArrayList containing all of a project's columns.
     */
    private static ArrayList<Column> buildColumns(JSONArray columnsJSON, ArrayList<Task> tasks)
    {
        ArrayList<Column> columns = new ArrayList<Column>();
        for (int i=0; i<columnsJSON.size(); i++)
        {
            // Get column title and create a new column.
            JSONObject columnJSON = (JSONObject)columnsJSON.get(i);
            String columnTitle = (String)columnJSON.get(COLUMN_TITLE);
            ArrayList<Task> columnTasks = new ArrayList<Task>();

            // Get the current column's task UUIDs and populate column with tasks that have matching UUIDs.
            JSONArray columnTasksJSON = (JSONArray)columnJSON.get(COLUMN_TASKS);
            for (int j=0; j<columnTasksJSON.size(); j++)
            {
                // Loop through tasks, find task with UUID equal to current UUID, add task.
                UUID taskID = UUID.fromString((String)columnTasksJSON.get(j));
                for (int k=0; k<tasks.size(); k++)
                {
                    Task currentTask = tasks.get(k);
                    if (taskID.equals(currentTask.getID()))
                    {
                        columnTasks.add(currentTask);
                        break;
                    }
                }
            }
            Column newColumn = new Column(columnTitle, columnTasks);
            columns.add(newColumn);
        }
        return columns;
    }
    /**
     * Builds comments based on a JSONArray of comments and returns them in an ArrayList.
     * @param commentsJSON A JSONArray of comments, containing objects with a dateTime, user, and content.
     * @return An ArrayList of comments on a given task or project.
     */
    private static ArrayList<Comment> loadComments(JSONArray commentsJSON)
    {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        for (int i=0; i<commentsJSON.size(); i++)
        {
            JSONObject newCommentJSON = (JSONObject)commentsJSON.get(i);
            
            // Load time string and parse it using custom DateTimeFormatter.
            String timeString = (String)newCommentJSON.get(TIME);
            LocalDateTime dateTime = LocalDateTime.parse(timeString, dateFormat);

            String username = (String)newCommentJSON.get(COMMENT_USER);
            Account user = manager.getAccountByUsername(username);

            String content = (String)newCommentJSON.get(COMMENT_CONTENT);

            Comment newComment = new Comment(dateTime, user, content);
            comments.add(newComment);
        }
        return comments;
    }
    /**
     * Builds task edit history based on a JSONArray of edits and returns them in an ArrayList.
     * @param editsJSON A JSONArray of edits, containing objects with a dateTime, editor, and description.
     * @return An ArrayList of edits on a given task.
     */
    private static ArrayList<Edit> loadEdits(JSONArray editsJSON)
    {
        ArrayList<Edit> edits = new ArrayList<Edit>();
        for (int i=0; i<editsJSON.size(); i++)
        {
            JSONObject newEditJSON = (JSONObject)editsJSON.get(i);

            String timeString = (String)newEditJSON.get(TIME);
            LocalDateTime dateTime = LocalDateTime.parse(timeString, dateFormat);

            String username = (String)newEditJSON.get(EDIT_EDITOR);
            Account user = manager.getAccountByUsername(username);

            String description = (String)newEditJSON.get(EDIT_DESCRIPTION);

            Edit newEdit = new Edit(dateTime, user, description);
            edits.add(newEdit);
        }
        return edits;
    }

    // FOR TESTING PURPOSES: DELETE WHEN FINISHED
    public static void main(String[] args)
    {
        // TESTING PROJECT LOADING AND ACCOUNT-TO-PROJECT LINKING
        
        ArrayList<Project> projects = loadProjects();
        String indent = "    ";
        System.out.println("-------------------------------------------");

        // Test project loading, prints all loaded projects.
        for (int i=0; i<projects.size(); i++)
        {
            // Prints basic project information
            Project currentProject = projects.get(i);
            System.out.println("PROJECT " + (i+1));
            System.out.println("pID: " + currentProject.getID());
            System.out.println("Title: " + currentProject.getTitle());
            System.out.println("Category: " + currentProject.getCategory());
            System.out.println("Owner: " + currentProject.getOwner().getUsername());

            // Prints usernames of all contributors
            ArrayList<Account> projContributors = currentProject.getContributors();
            System.out.println("CONTRIBUTORS:");
            for (int j=0; j<projContributors.size(); j++)
                System.out.println("  - " + projContributors.get(j).getUsername());
            
            // Prints columns and the basic information of all their tasks.
            ArrayList<Column> projColumns = currentProject.getColumns();
            System.out.println("PROJECT COLUMNS:");
            for (int j=0; j<projColumns.size(); j++)
            {
                System.out.println("COLUMN " + (j+1));
                System.out.println(indent + "Title: " + projColumns.get(j).getTitle());

                ArrayList<Task> colTasks = projColumns.get(j).getTasks();
                System.out.println(indent + "TASKS: ");
                for (int k=0; k<colTasks.size(); k++)
                {
                    System.out.println(indent + "TASK " + (k+1));
                    System.out.println(indent + indent + "tID: " + colTasks.get(k).getID());
                    System.out.println(indent + indent + "Name: " + colTasks.get(k).getName());
                    System.out.println(indent + indent + "Priority: " + colTasks.get(k).getPriority());
                }
            }

            // Prints out comments in full.
            ArrayList<Comment> projComments = currentProject.getComments();
            System.out.println("COMMENTS:");
            for (int j=0; j<projComments.size(); j++)
                System.out.println("  - " + projComments.get(j));

            System.out.println("-------------------------------------------");
        }


        // TESTING LOGINS AND PROJECT-TO-ACCOUNT LINKING

        // Test an account login, then print the names of all their projects.
        ScrumSystem system = new ScrumSystem();
        system.login("CadeAP", "Password123!?");
        Account currentUser = system.getCurrentUser();
        ArrayList<Project> currentProjects = currentUser.getProjects();

        System.out.println("Current user:\n" + currentUser);
        System.out.println("Their projects:");
        for (int i=0; i<currentProjects.size(); i++)
            System.out.println("  - " + currentProjects.get(i).getTitle());
        
        system.logout();

        // Test again with another account.
        system.login("APacicco", "123Password!");
        currentUser = system.getCurrentUser();
        currentProjects = currentUser.getProjects();

        System.out.println("\nCurrent user:\n" + currentUser);
        System.out.println("Their projects:");
        for (int i=0; i<currentProjects.size(); i++)
            System.out.println("  - " + currentProjects.get(i).getTitle());
        
        system.logout();

        // Test one last time with another account, this one should have Cade and Al's projects as it is a contributor to both.
        system.login("MPikula1", "Apple456##");
        currentUser = system.getCurrentUser();
        currentProjects = currentUser.getProjects();

        System.out.println("\nCurrent user:\n" + currentUser);
        System.out.println("Their projects:");
        for (int i=0; i<currentProjects.size(); i++)
            System.out.println("  - " + currentProjects.get(i).getTitle());
        
        system.logout();


        // TESTING PROJECT SAVING
        DataWriter.saveProjects();
    }
}