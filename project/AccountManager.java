package project;
/**
 * @author Miles Wedeking
 */
public class AccountManager {
    private static AccountManager accountManager;
    private ArrayList<Account> accounts;

    private static AccountManager(){
        //Not sure
    } 

    public AccountManager getInstance(){

        return this.accountManager;
    }

    public Account getAccount(String userName){
        
        return;
    }

    public void createAccount(String firstName, String lastName, String email, String userName, String passWord){

    }
    
    public void deleteAccount(Account account){

    }
}
