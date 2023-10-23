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
                boolean isVerified = (boolean)accountJSON.get(IS_VERIFIED);

                Account newAccount = new Account(username, password, email, firstName, lastName, isVerified);
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
                UUID id = (UUID)taskJSON.get(TASK_ID);
                String type = (String)taskJSON.get(TASK_TYPE);
                String name = (String)taskJSON.get(TASK_NAME);
                int priority = (int)taskJSON.get(TASK_PRIORITY);

                // Determine data type and load unique information.
                Task newTask;
                if(type.equalsIgnoreCase("Bug"))
                {
                    // TODO load and link testers and fix null, load reprosteps.
                    newTask = new Bug(id, name, priority, null);
                }
                else if (type.equalsIgnoreCase("NewFeature"))
                {
                    // TODO load reasoning and fix null, load todolist
                    newTask = new NewFeature(id, name, priority, null);
                }
                else
                {
                    continue;   // Something is very wrong with this entry, skip it.
                }

                // Load comments TODO
                JSONArray commentsJSON = (JSONArray)taskJSON.get(TASK_COMMENTS);

                // Add new task to the list of tasks.
                tasks.add(newTask);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}