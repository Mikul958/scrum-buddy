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
    
    public Account getAccount(String username, String password)
    {    
        for (int i=0; i<accounts.size(); i++)
        {
            if (username.equals(accounts.get(i).getUsername()) && password.equals(accounts.get(i).getPassword()))
                return accounts.get(i);
        }
        return null;
    }
    public boolean createAccount(String username, String password, String email, String firstName, String lastName)
    {
        for (int i=0; i<accounts.size(); i++)
        {
            if (username.equals(accounts.get(i).getUsername()))
                return false;
        }
        Account newAccount = new Account(username, password, email, firstName, lastName, false);
        accounts.add(newAccount);
        return true;
    }
    public boolean deleteAccount(Account account)
    {

    }
}
