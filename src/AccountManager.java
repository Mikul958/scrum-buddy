package src;

import java.util.ArrayList;

public class AccountManager
{
    private static AccountManager accountManager;
    private ArrayList<Account> accounts;

    private AccountManager()
    {
        accounts = DataReader.loadAccounts();
    } 
    public static AccountManager getInstance()
    {
        if (accountManager == null)
            accountManager = new AccountManager();
        return accountManager;
    }

    public ArrayList<Account> getAccounts()
    {
        return accounts;
    }
    
    public Account getAccount(String userName)
    {    
        return null;
    }
    public void createAccount(String firstName, String lastName, String email, String userName, String passWord)
    {

    }
    public void deleteAccount(Account account)
    {

    }
}
