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

    // Okay to use while loading projects because Accounts are loaded in its constructor and have no dependencies.
    private static AccountManager manager = AccountManager.getInstance();

    public static ArrayList<Project> loadProjects()
    {
        // Load in tasks to link later.
        ArrayList<Task> tasks = loadTasks();

        // Load in projects
        ArrayList<Project> projects = new ArrayList<Project>();

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

                Project newProject = new Project(id, title, category, owner);

                // TODO run through list of accounts and link all users.
                JSONArray contributorsJSON = (JSONArray)projectJSON.get(PROJECT_CONTRIBUTORS);
                linkAccountsToProject(contributorsJSON, newProject);
                
                // TODO populate each column with information and add to project.
                JSONArray columnsJSON = (JSONArray)projectJSON.get(PROJECT_COLUMNS);
            }
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
    public static ArrayList<Task> loadTasks()
    {
        ArrayList<Task> tasks = new ArrayList<Task>();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd 'at' HH:mm:ss");
        
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
                String type = (String)taskJSON.get(TASK_TYPE);
                String name = (String)taskJSON.get(TASK_NAME);
                int priority = (int)(long)taskJSON.get(TASK_PRIORITY);

                // Determine data type and load unique information.
                Task newTask = new Task(id, name, priority);

                // Load and add newTask's comments.
                JSONArray commentsJSON = (JSONArray)taskJSON.get(COMMENTS);
                for (int j=0; j<commentsJSON.size(); j++)
                {
                    JSONObject newCommentJSON = (JSONObject)commentsJSON.get(j);

                    String timeString = (String)newCommentJSON.get(TIME);
                    LocalDateTime dateTime = LocalDateTime.parse(timeString, dateFormat);

                    String username = (String)newCommentJSON.get(COMMENT_USER);
                    Account user = manager.getAccountByUsername(username);

                    String content = (String)newCommentJSON.get(COMMENT_CONTENT);

                    Comment newComment = new Comment(dateTime, user, content);
                    newTask.addComment(newComment);
                }

                // Load and add newTask's edit history.
                JSONArray editsJSON = (JSONArray)taskJSON.get(TASK_EDITS);
                for (int j=0; j<editsJSON.size(); j++)
                {
                    JSONObject newEditJSON = (JSONObject)editsJSON.get(j);

                    String timeString = (String)newEditJSON.get(TIME);
                    LocalDateTime dateTime = LocalDateTime.parse(timeString, dateFormat);

                    String editorName = (String)newEditJSON.get(EDIT_EDITOR);
                    Account editor = manager.getAccountByUsername(editorName);

                    String description = (String)newEditJSON.get(EDIT_DESCRIPTION);

                    Edit newEdit = new Edit(dateTime, editor, description);
                    newTask.addEdit(newEdit);
                }

                // Add new task to the list of tasks.
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
    public static Category stringToCategory(String category)
    {
        for (Category i : Category.values())
        {
            if (i.description.equalsIgnoreCase(category))
                return i;
        }
        return Category.OTHER;
    }
    /**
     * Add accounts to a project's list of contributors based on username, and adds the project to that user's list of projects.
     * @param array A JSONArray countaining account usernames.
     * @param project The project to add contributors to.
     */
    public static void linkAccountsToProject(JSONArray array, Project project)
    {
        for (int i=0; i<array.size(); i++)
        {
            String contributorName = (String)array.get(i);
            Account contributor = manager.getAccountByUsername(contributorName);
            project.addContributor(contributor);
            contributor.addProject(project);
        }
    }

    // FOR TESTING PURPOSES: DELETE WHEN FINISHED
    public static void main(String[] args)
    {
        ArrayList<Task> tasks = loadTasks();

        for (int i=0; i<tasks.size(); i++)
        {
            System.out.println("--------------------------------------------------------\n" + tasks.get(i));

            System.out.println("-----\nCOMMENTS:");
            ArrayList<Comment> comments = tasks.get(i).getComments();
            for (int j=0; j<comments.size(); j++)
                System.out.println("- " + comments.get(j));
            
            System.out.println("-----\nEDIT HISTORY:");
            ArrayList<Edit> edits = tasks.get(i).getEditHistory();
            for (int j=0; j<edits.size(); j++)
                System.out.println("- " + edits.get(j));
        }
    }
}