package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.time.LocalDateTime;
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
            String idString = currentProject.getID().toString();
            projectJSON.put(PROJECT_ID, idString);

            // Add title to JSONObject
            projectJSON.put(PROJECT_TITLE, currentProject.getTitle());
            
            // Get the category's description and add to JSONObject
            String categoryName = currentProject.getCategory().description;
            projectJSON.put(PROJECT_CATEGORY, categoryName);

            // Get the username of the owner and add to JSONObject
            String ownerName = currentProject.getOwner().getUsername();
            projectJSON.put(PROJECT_OWNER, ownerName);

            // Put the usernames of all contributors into a JSONArray and add to JSONObject.
            ArrayList<Account> contributors = currentProject.getContributors();
            JSONArray contributorsJSON = saveContributors(contributors);
            projectJSON.put(PROJECT_CONTRIBUTORS, contributorsJSON);

            // TODO columns
            ArrayList<Column> columns = currentProject.getColumns();

            // Put all comments on the project into a JSONArray and add to JSONObject.
            ArrayList<Comment> comments = currentProject.getComments();
            JSONArray commentsJSON = saveComments(comments);
            projectJSON.put(COMMENTS, commentsJSON);

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
    /**
     * Takes in a list of contributors and returns a JSONArray of their usernames.
     * @param contributors A list of contributors for a given project.
     * @return A JSONArray containing the usernames of project contributors.
     */
    private static JSONArray saveContributors(ArrayList<Account> contributors)
    {
        JSONArray contributorsJSON = new JSONArray();
        for (int i=0; i<contributors.size(); i++)
        {
            String contributorName = contributors.get(i).getUsername();
            contributorsJSON.add(contributorName);
        }
        return contributorsJSON;
    }
    /**
     * Builds a JSONArray of columns containing a title and a JSONArray of Java UUID corresponding to tasks.
     * @param columns The list of columns for a given project.
     * @return A JSONArray containing JSONObjects with each column's information for a given project.
     */
    private static JSONArray saveColumns(ArrayList<Column> columns)
    {
        return null;
    }
    /**
     * Takes in the system-wide list of tasks and returns it as a JSONArray.
     * @param tasks The system-wide list of tasks.
     * @return A JSONArray containing JSONObjects with every task's information.
     */
    private static JSONArray saveTasks(ArrayList<Task> tasks)
    {
        return null;
    }
    /**
     * Builds a JSONArray of comments containing a dateTime, user, and content.
     * @param comments The list of comments for a given project or task.
     * @return A JSONArray containing JSONObjects with each comment's information.
     */
    private static JSONArray saveComments(ArrayList<Comment> comments)
    {
        JSONArray commentsJSON = new JSONArray();
        for (int i=0; i<comments.size(); i++)
        {
            Comment currentComment = comments.get(i);
            JSONObject commentJSON = new JSONObject();

            String timeString = dateFormat.format(currentComment.getDateTime());
            commentJSON.put(TIME, timeString);

            String username = currentComment.getUser().getUsername();
            commentJSON.put(COMMENT_USER, username);

            commentJSON.put(COMMENT_CONTENT, currentComment.getContent());

            commentsJSON.add(commentJSON);
        }
        return commentsJSON;
    }
    /**
     * Builds a JSONArray of comments containing a dateTime, editor, and description.
     * @param edits The edit history for a given task.
     * @return A JSONArray contanining JSONObjects with each edit's information.
     */
    private static JSONArray saveEdits(ArrayList<Edit> edits)
    {
        return null;
    }
}
