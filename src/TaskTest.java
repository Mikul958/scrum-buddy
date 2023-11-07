package src;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
/**
 * Class to test functionality of Task class
 * @author Miles Wedeking
 */
public class TaskTest {
    @Test
    void getTaskInformation(){

        Task testTask = new Task("Test Example Name", 0);
        Account testAcc = new Account("TestMiles", "password", "email@.com", "Miles", "Wedeking");
        Project testProject = new Project("Task Test Project", Category.BUSINESS, testAcc);
        // testProject.addTask(testProject., null, 0)
        // assertEquals(testAcc, testProject);    
    }
    

}
