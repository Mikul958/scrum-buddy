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

        for (int i=0; i<accounts.size(); i++)
        {
            // TODO populate JSONArray
        }

        try
        {
            // TODO add code to write to file
            
            return true;
        }
        catch (Exception e)
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
