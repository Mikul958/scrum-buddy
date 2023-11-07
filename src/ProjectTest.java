package src;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ProjectTest
{

//FOR PROJECT CLASS
    @Test
    /*
     * void testGetTotalTasks(){
        Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
        Project proj = new Project("List", Category.BUSINESS, acc);
        assertEquals(0, proj.getTotalTasks(), "Shound have 0 tasks and there are"+proj.getTotalTasks());
    }
    //RESULT: PASSED
     */
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 /*
  * void testGetColumnByTitle(){//TESTING TO SEE IF COLUMN GETS ADDED AND CAN BE BROUGHT BACK
        Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
        Project proj = new Project("List", Category.BUSINESS, acc);
        String excolString = "excol";
        Column col = new Column(excolString);
        proj.addColumn(col);
        
        assertEquals(col, proj.getColumnByTitle(excolString));
    }


    //RESULT: PASSED
  */

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 /*
  * void testGetColumnByTitle2(){//TESTING TO SEE IF COLUMN THAT DOESN'T EXISTS GET BROUGHT BACK
        Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
        Project proj = new Project("List", Category.BUSINESS, acc);
        String excolString = "excol";

        Column col = new Column("not-excolString");
        proj.addColumn(col);
        
        assertNotEquals(col, proj.getColumnByTitle(excolString));
    }


    //RESULT: PASSED
  */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 /*
  * 
  void testAddContributor(){
        Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
        Project proj = new Project("List", Category.BUSINESS, acc);
         proj.addContributor(acc);
        assertTrue(proj.getContributors().contains(acc));
        
        
    }
    //RESULT: PASSED
  */
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
   /*
    *   
    void testRemoveContributor(){//CAN IT REMOVE AN ACCOUNT AT ALL
        Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
        Project proj = new Project("List", Category.BUSINESS, acc);
        proj.addContributor(acc);
        proj.removeContributor(acc);
        assertFalse(proj.getContributors().contains(acc));

   }
    //RESULT: PASSED
   
    */
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     void testRemoveContributor2(){//TESTING TO SEE IF IT'LL REMOVE AN ACCOUNT NOT ON PROJECT
        Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
        Project proj = new Project("List", Category.BUSINESS, acc);

        Account acc2 = new Account("Example2", "password2", "email@ex.com", "Michael", "Pikula");
        proj.removeContributor(acc2);
        
        assertFalse(proj.getContributors().contains(acc2));
   }
   // RESULT: PASSED
   */
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
    /*
     * void testAddColumnSTRING (){//can it add
        Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
        Project proj = new Project("List", Category.BUSINESS, acc);
        String title="excol";
        Column col = new Column(title);
        proj.addColumn(title);
        assertTrue(proj.getColumns().contains(title));
     }
     */

     //RESULT: FAILED? 
       
      
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
 * void testIsContributor(){//TESTING TO SEE IF IT CAN FIND AN ACCOUNT THIS IS DEFINITELY A CONTRIBUTOR
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Project proj = new Project("List", Category.BUSINESS, acc);
    proj.addContributor(acc);

    assertTrue(proj.isContributor(acc));
}
     //RESULT: PASSED
 */

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * void testIsContributor2(){//TESTING TO SEE IF IT CAN RESPOND PROPERLY WHEN AN ACCOUNT THIS IS DEFINITELY NOT A CONTRIBUTOR

    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Account notCorrect = new Account("OtherExample", "passcode", "email2@example.com", "Alfredo", "Pacicco");
    Project proj = new Project("List", Category.BUSINESS, acc);
    proj.addContributor(acc);

    assertFalse(proj.isContributor(notCorrect));
    }

    //RESULT: PASSED
     */

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
 * void testClearContributor()//CAN IT CLEAR ANYTHING
{
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Project proj = new Project("List", Category.BUSINESS, acc);
    proj.addContributor(acc);
    proj.clearContributors();
    assertFalse(proj.isContributor(acc));

}//RESULT: PASSED
 */

 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
 *  void testClearContributor2()//CAN IT CLEAR NOTHING
 {
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Project proj = new Project("List", Category.BUSINESS, acc);
    proj.clearContributors();
    assertFalse(proj.isContributor(acc));

 }

 //RESULT: PASSED
 */

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
 *  void testAddColumnOFTYPECOLUMN(){
Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
        Project proj = new Project("List", Category.BUSINESS, acc);
        String excolString = "excol";
        Column col = new Column(excolString);
        assertTrue(excolString, proj.addColumn(col)); 
    }

    //RESULT: PASSED
 */


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
 * void testRemoveColumnOBJECT(){//CAN IT REMOVE ANYTHING
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
        Project proj = new Project("List", Category.BUSINESS, acc);
        String excolString = "excol";
        Column col = new Column(excolString);

        proj.addColumn(col;
        proj.removeColumn(col);
        assertFalse(proj.getColumns().contains("excol"));


}//RESULT: PASSED
 */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
void testRemoveColumnOBJECT(){//DOES IT REMOVE ANYTHING ACCIDENTALLY?
        Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
        Project proj = new Project("List", Category.BUSINESS, acc);
        String excolString = "excol";
        String excolString2 = "excol2";
        Column col = new Column(excolString);
        Column col2 = new Column (excolString2);

        proj.addColumn(col);
        proj.addColumn(col2);
        proj.removeColumn(col);
        assertTrue(proj.getColumns().contains(col2));

}
//RESULT: FAILED. REMOVED ALL COLUMNS 
 */


 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* 
 void testMoveColumn(){//DO THE INDEXES MATCH?
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Project proj = new Project("List", Category.BUSINESS, acc);
    String excolString = "column1";
    String excolString2 = "column2";
    String excolString3 = "column3";    
    Column col = new Column(excolString);
    Column col2 = new Column(excolString2);
    Column col3 = new Column(excolString3);
    proj.addColumn(col);
    proj.addColumn(col2);
    proj.addColumn(col3);
   assertEquals(col, proj.getColumns().get(0));

//RESULT: PASSED

}
*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
 * 
 
void testMoveColumn2(){//CAN THEY MOVE?
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Project proj = new Project("List", Category.BUSINESS, acc);
    String excolString = "column1";
    String excolString2 = "column2";
    String excolString3 = "column3";    
    Column col = new Column(excolString);
    Column col2 = new Column(excolString2);
    Column col3 = new Column(excolString3);
    proj.addColumn(col);
    proj.addColumn(col2);
    proj.addColumn(col3);
    proj.moveColumn(0, 1);
    assertEquals(col, proj.getColumns().get(1));

//RESULT: PASSED

}
*/

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* 
void testAddTask(){//CAN A TASK BE ADDED
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Project proj = new Project("List", Category.BUSINESS, acc);
    String colName = "hi";
    proj.addColumn(colName);
    String taskName = "tasky";
    boolean added = proj.addTask(colName, taskName, 1);
    assertTrue(added);
}
//RESULT: PASSED
*/
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* 
void testAddTask2(){//CAN A TASK BE ADDED TO A COLUMN THAT DOESN'T EXIST
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Project proj = new Project("List", Category.BUSINESS, acc);
    String colName = "hi";
    String colName2 = "bye";
    proj.addColumn(colName);
    String taskName = "tasky";
    boolean added = proj.addTask(colName2, taskName, 1);
    assertFalse(added);
}
//RESULT: PASSED
*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/* 
void testRemoveTask(){//CAN IT REMOVE A TASK
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Project proj = new Project("List", Category.BUSINESS, acc);
    String colName = "hi";
    String taskName = "tasky";
    proj.addColumn(colName);
    proj.addTask(colName, taskName, 1);
    boolean removed = proj.removeTask(colName, taskName);

    assertTrue(removed);
}
*/

//RESULT: PASSED


}

