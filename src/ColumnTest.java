package src;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ColumnTest 
{
 
    //TESTING FOR COLUMN CLASS
    @Test
    void testGetTaskByName() {
        Account acc = new Account("CadeAP", "pasa123", "cadephillips4@gmail.com", "Cade", "Phillips");
        Project proj = new Project("exampleProj", Category.OTHER, acc);
        Column col = new Column("exampleColumn");
        Task task = new Task("exampleTask", 1);
        col.addTask("exampleTask2", 2);

        assertEquals(task, col.getTaskByName("exampleTask"));
    }
    //RESULT: FAILED?


    @Test
    void testAddTask() {
        Account acc = new Account("testCade", "pass123!", "tester@gmail.com", "Cade", "Phillips");
        Project proj = new Project("null", Category.PERSONAL, acc);
        Column col = new Column("testColumn");
        Task task = new Task("testTask", 1);
        col.addTask("testTask", 1);
        assertTrue(col.getTasks().contains(task));
    }
    //RESULT: FAILED?


    @Test
    void testRemoveTask() {
        Account acc = new Account("testCade", "pass123!", "tester@gmail.com", "Cade", "Phillips");
        Project proj = new Project("null", Category.PERSONAL, acc);
        Column col = new Column("testColumn");
        Task task = new Task("testTask", 1);
        col.addTask("testTask", 1);
        col.removeTask(task);
        assertFalse(col.getTasks().contains(task));
    }
    //RESULT: PASSED


    @Test
    void testOrderTasks() {
        Account acc = new Account("testCade", "pass123!", "tester@gmail.com", "Cade", "Phillips");
        Project proj = new Project("null", Category.PERSONAL, acc);
        Column col = new Column("testColumn");
        Task task = new Task("testTask", 1);
        //Task task2 = new Task("testTask2", 1);
        //Task task3 = new Task("testTask3", 1);
        col.addTask("testTask", 1);
        col.addTask("testTask2", 1);
        col.addTask("testTask3", 1);
        assertEquals(task, col.getTasks().get(0));

    }

    

}
