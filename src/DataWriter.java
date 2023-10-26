package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * A class responsible for saving system information to respective JSON files.
 */
public class DataWriter extends DataConstants
{
    /**
     * Saves the system-wide list of accounts to Accounts.json
     * @return true if accounts were successfully written.
     */
    public static boolean saveAccounts()
    {
        AccountManager manager = AccountManager.getInstance();
        ArrayList<Account> accounts = manager.getAccounts();
        JSONArray accountsJSON = new JSONArray();

        // Populate a JSONObject with account details and add object to JSONArray for all accounts.
        for (int i=0; i<accounts.size(); i++)
        {
            Account currentAccount = accounts.get(i);
            JSONObject accountJSON = new JSONObject();
            accountJSON.put(USERNAME, currentAccount.getUsername());
            accountJSON.put(PASSWORD, currentAccount.getPassword());
            accountJSON.put(EMAIL, currentAccount.getEmail());
            accountJSON.put(FIRST_NAME, currentAccount.getFirstName());
            accountJSON.put(LAST_NAME, currentAccount.getLastName());

            accountsJSON.add(accountJSON);
        }

        try
        {
            FileWriter writer = new FileWriter(ACCOUNTS_FILE);

            writer.write(accountsJSON.toJSONString());
            writer.flush();
            writer.close();
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean saveProjects()
    {
        ProjectManager manager = ProjectManager.getInstance();
        ArrayList<Project> projects = manager.getProjects();
        JSONArray projectsJSON = new JSONArray();

        for (int i=0; i<projects.size(); i++)
        {
            // Create a JSONObject for the current project.
            Project currentProject = projects.get(i);
            JSONObject projectJSON = new JSONObject();

            // Get the ID, convert to String, and add to JSONObject
            String pID = currentProject.getID().toString();
            projectJSON.put(PROJECT_ID, pID);

            projectJSON.put(PROJECT_TITLE, currentProject.getTitle());
            
            // Get the category's description and add to JSONObject
            String category = currentProject.getCategory().description;
            projectJSON.put(PROJECT_CATEGORY, category);

            // Get the username of the owner and add to JSONObject
            String ownerName = currentProject.getOwner().getUsername();
            projectJSON.put(PROJECT_OWNER, ownerName);

            // TODO contributors
            // TODO columns
            // TODO comments

            // Add finished JSONObject to the outer JSONArray.
            projectsJSON.add(projectJSON);
        }

        try
        {
            FileWriter writer = new FileWriter(PROJECTS_FILE_TEMP);

            writer.write(projectsJSON.toJSONString());
            writer.flush();
            writer.close();
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
