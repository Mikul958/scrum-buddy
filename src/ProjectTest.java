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
     * 
     * 
     void testRemoveContributor2(){//TESTING TO SEE IF IT'LL REMOVE AN ACCOUNT NOT ON PROJECT
        Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
        Project proj = new Project("List", Category.BUSINESS, acc);
        
        assertFalse(proj.getContributors().contains(acc));
   }
   //RESULT: FAILED, THINKS ACC IS ON PROJ
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
 * void testRemoveColumnSTRING(){//CAN IT REMOVE ANYTHING
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
        Project proj = new Project("List", Category.BUSINESS, acc);
        String excolString = "excol";
        Column col = new Column(excolString);

        proj.addColumn("excol");
        proj.removeColumn("excol");
        assertFalse(proj.getColumns().contains("excol"));


}//RESULT: PASSED
 */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

void testRemoveColumnSTRING2(){//DOES IT REMOVE ANYTHING ACCIDENTALLY?
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
        Project proj = new Project("List", Category.BUSINESS, acc);
        String excolString = "excol";
        String excolString2 = "otherExcol";
        Column col = new Column(excolString);
        Column col2 = new Column(excolString2);

        proj.addColumn(excolString);
       // proj.addColumn("otherExcol");
        //proj.removeColumn("excol");
        assertTrue(proj.getColumns().contains(excolString));

}



}

