package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants
{
    public static boolean saveAccounts()
    {
        AccountManager manager = AccountManager.getInstance();
        ArrayList<Account> accounts = manager.getAccounts();
        JSONArray accountsJSON = new JSONArray();

        // Populate a JSONObject with account details and add object to JSONArray for all accounts.
        for (int i=0; i<accounts.size(); i++)
        {
            Account currentAcc = accounts.get(i);
            JSONObject accountJSON = new JSONObject();
            accountJSON.put(USERNAME, currentAcc.getUsername());
            accountJSON.put(PASSWORD, currentAcc.getPassword());
            accountJSON.put(EMAIL, currentAcc.getEmail());
            accountJSON.put(FIRST_NAME, currentAcc.getFirstName());
            accountJSON.put(LAST_NAME, currentAcc.getFirstName());
            accountJSON.put(IS_VERIFIED, currentAcc.getIsVerified());

            accountsJSON.add(accountJSON);
        }

        try
        {
            FileWriter writer = new FileWriter(ACCOUNTS_TEMP_FILE);

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
    public boolean saveProjects()
    {
        try
        {
            return false; // Will change back to true when method is finished
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
