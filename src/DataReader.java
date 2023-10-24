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
                JSONObject projectJSON = (JSONObject)projectsJSON.get(i);
                UUID id = UUID.fromString((String)projectJSON.get(PROJECT_ID));
                String title = (String)projectJSON.get(PROJECT_TITLE);

                String categoryName = (String)projectJSON.get(PROJECT_CATEGORY);
                Category category = stringToCategory(categoryName);

                String ownerName = (String)projectJSON.get(PROJECT_OWNER);
                Account owner = manager.getAccountByUsername(ownerName);

                Project newProject = new Project(id, title, category, owner);

                JSONArray contributors = (JSONArray)projectJSON.get(PROJECT_CONTRIBUTORS);
                // TODO make method to link all contributors both ways
                
                JSONArray columns = (JSONArray)projectJSON.get(PROJECT_COLUMNS);
                // TODO make method to link tasks to columns and add columns
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
                Task newTask;
                if(type.equalsIgnoreCase("Bug"))
                {
                    // Find tester's account based on username.
                    String testerName = (String)taskJSON.get(BUG_TESTER);
                    Account tester = manager.getAccountByUsername(testerName);

                    Bug newBug = new Bug(id, name, priority, tester);

                    // Add all reproduction steps, convert newBug into a Task.
                    JSONArray reproStepsJSON = (JSONArray)taskJSON.get(BUG_REPRO_STEPS);
                    for (int j=0; j<reproStepsJSON.size(); j++)
                    {
                        String newStep = (String)reproStepsJSON.get(j);
                        newBug.addReproStep(newStep);
                    }
                    newTask = (Task)newBug;
                }
                else if (type.equalsIgnoreCase("NewFeature"))
                {
                    String reasoning = (String)taskJSON.get(NEW_FEATURE_REASONING);

                    NewFeature newFeature = new NewFeature(id, name, priority, reasoning);

                    // Add all to-dos, convert newFeature into a Task
                    JSONArray todoListJSON = (JSONArray)taskJSON.get(NEW_FEATURE_TODO);
                    for (int j=0; j<todoListJSON.size(); j++)
                    {
                        String newTodo = (String)todoListJSON.get(j);
                        newFeature.addTodo(newTodo);
                    }
                    newTask = (Task)newFeature;
                }
                else
                {
                    continue;   // Something is very wrong with this entry, skip it.
                }

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