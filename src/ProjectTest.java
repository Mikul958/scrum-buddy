package src;

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

     //RESULT: failed? 
       
      
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/* 
void testRemoveTask2(){//DOES IT ERROR WHEN A TASK CAN'T BE REMOVED OR WHEN THE TASK DOESN'T EXIST
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Project proj = new Project("List", Category.BUSINESS, acc);
    String colName = "hi";
    String taskName = "tasky";
    String taskName2 = "taskyyy";
    proj.addColumn(colName);
    proj.addTask(colName, taskName, 1);
    proj.addTask(colName, taskName2, 1);
    boolean removed = proj.removeTask(colName, taskName2);

    assertTrue(removed);

}
//RESULT: FAILED

*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* 
void removeTaskOBJECT(){//CAN IT REMOVE A TASK OBJ
        Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
        Project proj = new Project("List", Category.BUSINESS, acc);
        String colTitle = "column title";
        Column col = new Column(colTitle);
        proj.addColumn(col);
        String taskTitle = "task title";
        Task tsk = new Task(taskTitle, 0);
        proj.addTask(colTitle, taskTitle, 0);
        boolean removed = proj.removeTask(colTitle, tsk);


        assertTrue(removed);
}
//RESULT: FAILED
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
*/

/* 
void testMoveTask(){//CAN IT MOVE A TASK TO ANOTHER COLUMN
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Project proj = new Project("List", Category.BUSINESS, acc);

    Column fromCol = new Column("from column");
    Column toCol = new Column("to column");

    Task tsk = new Task("task name", 0);

    proj.addColumn(toCol);
    proj.addColumn(fromCol);

    proj.addTask("from column", "task name", 0);

    proj.moveTask(tsk, "from column", "to column");

    assertTrue(toCol.getTasks().contains(tsk));



//RESULT: FAIL
}


*/ 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* 
void testContainsTask()//DOES IT CONTAIN A TASK
{
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Project proj = new Project("List", Category.BUSINESS, acc);

    Column fromCol = new Column("from column");

    Task tsk = new Task("task name", 0);

    proj.addColumn(fromCol);

    proj.addTask("from column", "task name", 0);

    assertTrue(proj.containsTask(tsk));

    //RESULT: FAIL

}
*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
 * void testContainsTask2()//DOES IT CONTAIN A TASK THAT DOESN'T EXIST
{
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Project proj = new Project("List", Category.BUSINESS, acc);

    Column fromCol = new Column("from column");

    Task tsk = new Task("task name", 0);
    Task tsk2 = new Task("task2 name", 0);

    proj.addColumn(fromCol);

    proj.addTask("from column", "task name", 0);

    assertTrue(!proj.containsTask(tsk2));

    //RESULT: FAIL

}
 */

 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/* 
void testAddComment(){//CAN IT ADD A COMMENT    
     Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Project proj = new Project("List", Category.BUSINESS, acc);

    Column fromCol = new Column("from column");
    String opinion = "this is my opinion";
    Comment com = new Comment(acc, opinion);

    Task tsk = new Task("task name", 0);

    proj.addColumn(fromCol);

    proj.addTask("from column", "task name", 0);

    proj.addTaskComment(tsk, acc, opinion);

    assertTrue(tsk.getComments().contains(com));

    //RESULT: FAILED
}
*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* 
void testRemoveComment(){//CAN IT REMOVE A COMMENT
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Project proj = new Project("List", Category.BUSINESS, acc);

    Column fromCol = new Column("from column");
    Task tsk = new Task("task name", 0);

    proj.addColumn(fromCol);
    proj.addTask("from column", "task name", 0);
    String opinion = "this is my opinion";
    Comment com = new Comment(acc, opinion);

    proj.addComment(acc, opinion);
    proj.removeComment(com);

    assertTrue(tsk.getComments().contains(com));

    //RESULT: FAILED
}
*/
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/* 
void testRemoveComment2(){//DOES IT REMOVE A SPECIFIC COMMENT AS OPPOSED TO ALL OF THEM
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Project proj = new Project("List", Category.BUSINESS, acc);

    Column fromCol = new Column("from column");
    Task tsk = new Task("task name", 0);

    proj.addColumn(fromCol);
    proj.addTask("from column", "task name", 0);
    String opinion = "this is my opinion";
    Comment com = new Comment(acc, opinion);

    proj.addComment(acc, opinion);
    proj.removeComment(com);

    assertTrue(tsk.getComments().contains(com));

}
//RESULT: FAILED

*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* 
void testTaskAddComment(){//DOES IT ADD A COMMENT TO A TASK
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Account acc2Account = new Account("ex", "password", "email@example.com", "Alfred", "Pacicco");
    Project proj = new Project("List", Category.BUSINESS, acc);

    Column fromCol = new Column("from column");
    Task tsk = new Task("task name", 0);

    String opinion = "this is my opinion";
    Comment com = new Comment(acc, opinion);
    proj.addColumn(fromCol);
    proj.addTask("from column", "task name", 0);

    boolean commenty = proj.addTaskComment(tsk, acc2Account, opinion);
    assertTrue(commenty);

//RESULT: FAILED
}
*/
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/* 
void tetsTaskRemoveComment(){//CAN IT REMOVE A COMMENT
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Account acc2Account = new Account("ex", "password", "email@example.com", "Alfred", "Pacicco");
    Project proj = new Project("List", Category.BUSINESS, acc);

    Column fromCol = new Column("from column");
    Task tsk = new Task("task name", 0);

    String opinion = "this is my opinion";
    Comment com = new Comment(acc, opinion);

    proj.addTaskComment(tsk, acc2Account, opinion);
    proj.removeComment(com);

    assertFalse(proj.getComments().contains(com));


    //RESULT: FAILED


}
*/

//////////////////////////////////////////////////////////////////////////////////////////////////////


void tetsTaskRemoveComment2(){//CAN IT REMOVE A COMMENT THAT DOESNT EXIST
    Account acc = new Account("Example", "password", "email@ex.com", "Al", "Pacino");//practice account
    Account acc2Account = new Account("ex", "password", "email@example.com", "Alfred", "Pacicco");
    Project proj = new Project("List", Category.BUSINESS, acc);

    Column fromCol = new Column("from column");
    Task tsk = new Task("task name", 0);

    String opinion = "this is my opinion";
    String opinion2 = "this is my other opinion";
    Comment com = new Comment(acc, opinion);
    Comment com2 = new Comment(acc2Account, opinion2);



    proj.addTaskComment(tsk, acc2Account, opinion);
    proj.addTaskComment(tsk, acc2Account, opinion2);
    proj.removeComment(com);
    proj.removeTaskComment(tsk, com);

    assertFalse(proj.getComments().contains(com2));


    //RESULT: FAILED

}

}

