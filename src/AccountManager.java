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
        for (int i=0; i<accounts.size(); i++)
        {
            if (username.equals(accounts.get(i).getUsername()) && password.equals(accounts.get(i).getPassword()))
                return accounts.get(i);
        }
        return null;
    }
    public boolean createAccount(String userName, String passWord, String email, String firstName, String lastName, )
    {
        // TODO make sure username is unique, return false if not
        Account newAccount = new Account(username, password, email, firstName, lastName, false);
        accounts.add(newAccount);
        return true
    }
    public void deleteAccount(Account account)
    {

    }
}
