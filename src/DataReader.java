package src;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
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

    public static ArrayList<Project> loadProjects()
    {
        // Load in tasks first, then load in projects.

        // Link projects to tasks based on UUID, then projects to accounts based on username
        // Then, link accounts BACK to projects based on project UUID. (This part may be handled by external method).

        return null;
    }
    public static ArrayList<Task> loadTasks()
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
                String type = (String)taskJSON.get(TASK_TYPE);
                String name = (String)taskJSON.get(TASK_NAME);
                int priority = (int)(long)taskJSON.get(TASK_PRIORITY);

                // Determine data type and load unique information.
                Task newTask;
                if(type.equalsIgnoreCase("Bug"))
                {
                    // Find tester's account based on username.
                    AccountManager manager = AccountManager.getInstance();
                    String testerName = (String)taskJSON.get(BUG_TESTER);
                    Account tester = manager.getAccountByUsername(testerName);

                    newTask = new Bug(id, name, priority, tester);

                    JSONArray reproStepsJSON = (JSONArray)taskJSON.get(BUG_REPRO_STEPS);
                    // TODO load reproSteps
                }
                else if (type.equalsIgnoreCase("NewFeature"))
                {
                    String reasoning = (String)taskJSON.get(NEW_FEATURE_REASONING);
                    newTask = new NewFeature(id, name, priority, reasoning);

                    JSONArray todoListJSON = (JSONArray)taskJSON.get(NEW_FEATURE_TODO);
                    // TODO load todoList
                }
                else
                {
                    continue;   // Something is very wrong with this entry, skip it.
                }

                JSONArray commentsJSON = (JSONArray)taskJSON.get(TASK_COMMENTS);
                // TODO load comments

                JSONArray editsJSON = (JSONArray)taskJSON.get(TASK_EDITS);
                // TODO load editHistory

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

    public static void main(String[] args)
    {
        ArrayList<Task> tasks = loadTasks();

        for (int i=0; i<tasks.size(); i++)
            System.out.println("------------------------\n" + tasks.get(i));
    }
}