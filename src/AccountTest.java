package src;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class AccountTest
{
    @Test
    void testAddProject()
    {
        Account acc = new Account("MPikula", "pass", "mpikula@gmail.com", "Michael", "Pikula");
        Project proj = new Project("Ex", Category.OTHER, acc);

        Account acc2 = new Account("account2", "pass", "email2@poop.com", "Test", "McTesterson");
        Project proj2 = new Project("Ex2", Category.OTHER, acc2);

        acc.addProject(proj2);  // Add project 2 to account 1.

        // NOTE: add project/contributor are called for owners in project constructor, acc is already linked to proj and acc2 to proj2.

        boolean contains = acc.getProjects().contains(proj2);
        assertTrue(contains);
    }
    @Test
    void testNotAddProject()
    {
        Account acc = new Account("MPikula", "pass", "mpikula@gmail.com", "Michael", "Pikula");
        Project proj = new Project("Ex", Category.OTHER, acc);

        Account acc2 = new Account("account2", "pass", "email2@poop.com", "Test", "McTesterson");
        Project proj2 = new Project("Ex2", Category.OTHER, acc2);

        acc.addProject(proj2);  // Add project 2 to account 1.

        // NOTE: add project/contributor are called for owners in project constructor, acc is already linked to proj and acc2 to proj2.

        boolean contains = acc2.getProjects().contains(proj);  // Account 2 should not have project 1
        assertFalse(contains);
    }

    @Test
    void testRemoveProjectHad()
    {
        Account acc = new Account("MPikula", "pass", "mpikula@gmail.com", "Michael", "Pikula");
        Project proj = new Project("Ex", Category.OTHER, acc);
        Project proj2 = new Project("Ex2", Category.OTHER, acc);

        assertTrue(acc.removeProject(proj2));
    }
    @Test
    void testRemoveProjectDidntHave()
    {
        Account acc = new Account("MPikula", "pass", "mpikula@gmail.com", "Michael", "Pikula");
        Project proj = new Project("Ex", Category.OTHER, acc);

        Account acc2 = new Account("account2", "pass", "email2@poop.com", "Test", "McTesterson");
        Project proj2 = new Project("Ex2", Category.OTHER, acc2);

        assertFalse(acc.removeProject(proj2));
    }
    @Test
    void testRemoveProjectHadProject()
    {
        Account acc = new Account("MPikula", "pass", "mpikula@gmail.com", "Michael", "Pikula");
        Project proj = new Project("Ex", Category.OTHER, acc);

        boolean contains = acc.getProjects().contains(proj);
        assertTrue(contains);
    }

    @Test
    void testClearProjects()
    {
        Account acc = new Account("MPikula", "pass", "mpikula@gmail.com", "Michael", "Pikula");
        Project proj = new Project("Ex", Category.OTHER, acc);
        Project proj2 = new Project("Ex2", Category.OTHER, acc);
        Project proj3 = new Project("Ex3", Category.OTHER, acc);

        acc.clearProjects();
        assertEquals(acc.getProjects().size(), 0);
    }
    
    @Test
    void testEqualsIsEqual()
    {
        Account acc1 = new Account("MPikula", "pass", "mpikula@gmail.com", "Michael", "Pikula");
        Account acc2 = new Account("MPikula", "pass2", "michael@gmail.com", "Michael", "Pepula");

        assertEquals(acc1, acc2);
    }
    @Test
    void testEqualsNotEqual()
    {
        Account acc1 = new Account("MPikula", "pass", "mpikula@gmail.com", "Michael", "Pikula");
        Account acc2 = new Account("Mpikula", "pass2", "michaelIMPOSTOR@gmail.com", "Michael", "IMPOSTORPIKULA");

        assertNotEquals(acc1, acc2);
    }
}
