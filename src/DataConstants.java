package src;

/**
 * A class containing constants for DataReader and DataWriter.
 * @author Michael Pikula
 */
public abstract class DataConstants
{
    // Accounts.json
    protected static final String ACCOUNTS_FILE = "json/Accounts.json";
    protected static final String USERNAME = "username";
    protected static final String PASSWORD = "password";
    protected static final String EMAIL = "email";
    protected static final String FIRST_NAME = "firstName";
    protected static final String LAST_NAME = "lastName";
    protected static final String IS_VERIFIED = "isVerified";

    // Projects.json

    // Tasks.json
    protected static final String TASKS_FILE = "json/Tasks.json";
    protected static final String TASK_ID = "tUUID";
    protected static final String TASK_TYPE = "type";
    protected static final String TASK_NAME = "name";
    protected static final String TASK_PRIORITY = "priority";
    protected static final String TASK_COMMENTS = "comments";
    protected static final String TASK_EDITS = "editHistory";
    protected static final String BUG_TESTER = "tester";
    protected static final String BUG_REPRO_STEPS = "reproSteps";
    protected static final String NEW_FEATURE_REASONING = "reasoning";
    protected static final String NEW_FEATURE_TODO = "todoList";
}
