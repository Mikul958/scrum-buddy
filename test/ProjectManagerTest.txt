package src;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.ArrayList;

public class ProjectManagerTest
{
    AccountManager aManager;
    ProjectManager manager;
    Account loggedIn;
    
    @BeforeEach
    public void getManager()
    {
        aManager = AccountManager.getInstance();
        manager = ProjectManager.getInstance();
        loggedIn = aManager.login("MPikula1", "Apple456##");
    }

    @Test
    public void testGetProjectByID()
    {
        UUID testID = UUID.fromString("2abdfb60-8ef2-4bbb-82eb-20321a406d3c");  // UUID of "Cade's Project".
        Project test = manager.getProjectByID(testID);

        boolean equal = test != null &&
                        test.getID().equals(testID) &&
                        test.getTitle().equals("Cade's Project") &&
                        test.getCategory() == Category.EDUCATION;

        assertTrue(equal);
    }
    @Test
    public void testGetProjectByIDBadID()
    {
        UUID testID = UUID.fromString("d33c8aee-63ef-4154-b3a5-75372717c393");  // UUID of "Add manager class" task, not a project.
        Project test = manager.getProjectByID(testID);

        assertEquals(test, null);
    }

    @Test
    public void testCreateProject()
    {
        manager.createProject("Test Project", Category.BUSINESS, loggedIn);

        boolean equal = false;
        ArrayList<Project> p = manager.getProjects();

        // Loop through project list, if a project exists will all the information of the project above, flip equal to true.
        for (int i=0; i<p.size(); i++)
        {
            if (p.get(i).getTitle().equals("Test Project") && p.get(i).getCategory() == Category.BUSINESS && p.get(i).getOwner().equals(loggedIn))
                equal = true;
        }

        assertTrue(equal);
    }

    @Test
    public void testDeleteProject()
    {
        Project toDelete = loggedIn.getProjects().get(0);  // Cade's Project, MPikula1 and CadeAP are contributors.

        boolean deleted = manager.deleteProject(toDelete);
        boolean deletedConfirmed = true;
        if (manager.getProjectByID(UUID.fromString("2abdfb60-8ef2-4bbb-82eb-20321a406d3c")) != null)
            deletedConfirmed = false;

        // Check MPikula1's project list for Cade's Project.
        boolean deletedFromMichael = true;
        for (int i=0; i<loggedIn.getProjects().size(); i++)
        {
            if (loggedIn.getProjects().get(i).getTitle().equals("Cade's Project"))
                deletedFromMichael = false;
        }

        // Log in CadeAP and check their project list for Cade's Project (note, CadeAP will have 0 projects).
        loggedIn = aManager.login("CadeAP", "Password123!?");
        boolean deletedFromCade = true;
        for (int i=0; i<loggedIn.getProjects().size(); i++)
        {
            if (loggedIn.getProjects().get(i).getTitle().equals("Cade's Project"))
                deletedFromCade = false;
        }

        assertTrue(deleted && deletedConfirmed && deletedFromMichael && deletedFromCade);
    }
}
