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
public class TaskTest
{
    @Test
    public void testAddComment()
    {
        Task task = new Task("Test Task", 1);  // Create task to test on.
        Account testAcc = new Account("test", "test", "test@gmail.com", "Test", "Test");  // Create temp account as comment author.
        Comment testComm = new Comment(testAcc, "this sucks");  // Create test comment.

        task.addComment(testComm);  // Add comment to task.

        assertTrue(task.getComments().contains(testComm));  // Test if task comments list contains the added comment.
    }
}
