package src;

import java.util.ArrayList;

/**
 * No functionality, used to verify file I/O is working correctly.
 * @author Michael Pikula
 */
public abstract class IOTest
{
    public static void main(String[] args)
    {
        // Test load from file.
        System.out.println("First load:");
        AccountManager manager = AccountManager.getInstance();
        ArrayList<Account> accounts = manager.getAccounts();
        for (int i=0; i<accounts.size(); i++)
        {
            System.out.println(accounts.get(i));
            System.out.println("----------");
        }

        // Test save file (saves to Accounts-temp.json, need to ask about copying information to Accounts.json.
        if (DataWriter.saveAccounts());
            System.out.println("\nSave Successful.\n");

        // Also tested loading from file after saving to it, however testing required extra temporary methods.
    }
}
