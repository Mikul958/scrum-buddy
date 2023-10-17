package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter {

    public boolean saveAccounts()
    {
        try {
            return true;
        } catch (Exception e)
        {
            e.getStackTrace();
            System.out.println("what the hell happened");
            return false;
        }
    }


    public boolean saveProjects()
    {
        try {
            return true;
        } catch (Exception e)
        {
            e.getStackTrace();
            return false;
        }
    }
    
}
