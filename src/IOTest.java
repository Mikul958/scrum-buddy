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
        AccountManager manager = AccountManager.getInstance();
        ArrayList<Account> accounts = manager.getAccounts();
        for (int i=0; i<accounts.size(); i++)
        {
            System.out.println(accounts.get(i));
            System.out.println("----------");
        }
    }
}
