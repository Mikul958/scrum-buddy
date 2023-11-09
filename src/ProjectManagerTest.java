package src;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ProjectManagerTest
{
    AccountManager aManager;
    ProjectManager manager;
    
    @BeforeEach
    public void getManager()
    {
        aManager = AccountManager.getInstance();
        manager = ProjectManager.getInstance();
    }
}
