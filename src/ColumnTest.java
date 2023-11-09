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
    /*
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
    */

    @Test
    void testAddTask() {
        Account acc = new Account("testCade", "pass123!", "tester@gmail.com", "Cade", "Phillips");
        Project proj = new Project("testProj", Category.PERSONAL, acc);
        Column col = new Column("testColumn");
        proj.addColumn("testColumn");
        Task task = new Task("testTask", 1);
        col.addTask("testTask", 1);
        assertTrue(col.getTasks().contains(task));
    }
    //RESULT: FAILED?


    @Test
    void testRemoveTask() {
        Account acc = new Account("testCade", "pass123!", "tester@gmail.com", "Cade", "Phillips");
        Project proj = new Project("testProj", Category.PERSONAL, acc);
        Column col = new Column("testColumn");
        proj.addColumn("testColumn");
        Task task = new Task("testTask", 1);
        col.addTask("testTask", 1);
        col.removeTask(task);
        assertFalse(col.getTasks().contains(task));
    }
    //RESULT: PASSED


    @Test
    void testOrderTasks() {
        Account acc = new Account("testCade", "pass123!", "tester@gmail.com", "Cade", "Phillips");
        Project proj = new Project("testProj", Category.OTHER, acc);
        Column col = new Column("testColumn");
        proj.addColumn("testColumn");
        //Task task = new Task("testTask", 1);
        //Task task2 = new Task("anotherTestTask", 1);

        col.addTask("TestTask", 1);
        col.addTask("anotherTestTask", 1);
        col.orderTasks();
        assertEquals("anotherTestTask", col.getTasks().get(0));
    }
    //RESULT: FAILED


    @Test
    void testContainsTasks() {
        Account acc = new Account("testCade", "pass123!", "tester@gmail.com", "Cade", "Phillips");
        Project proj = new Project("testProj", Category.PERSONAL, acc);
        Column col = new Column("testColumn");
        proj.addColumn("testColumn");
        Task task = new Task("testTask", 1);
        col.addTask("testTask", 1);

        assertTrue(col.getTasks().contains(task));
    }
    //RESULT: FAILED?


    @Test
    void testNotContainsTasks() {
        Account acc = new Account("testCade", "pass123!", "tester@gmail.com", "Cade", "Phillips");
        Project proj = new Project("testProj", Category.PERSONAL, acc);
        Column col = new Column("testColumn");
        proj.addColumn("testColumn");
        Task task = new Task("testTask", 1);
        col.addTask("testTask", 1);

        assertFalse(col.getTasks().contains(task));
    }



    

}
