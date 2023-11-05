package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ProjectTest
{
    



    @Test

    void testGetTotalTasks(){
        var proj = new Project(null, null, null);
        assertEquals(4, proj.getTotalTasks());
    }



   
    
}

