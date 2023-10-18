package src;

import java.util.ArrayList;

public class AccountManager
{
    private static AccountManager accountManager;
    private ArrayList<Account> accounts;

    private AccountManager()
    {
        //Not sure
    } 
    public static AccountManager getInstance()
    {
        return null;
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
    public void createAccount(String userName, String passWord, String email, String firstName, String lastName, )
    {
        // TODO make sure username is unique
        Account newAccount = new Account(username, password, email, firstName, lastName, false);
        accounts.add(newAccount);
    }
    public void deleteAccount(Account account)
    {

    }
}
