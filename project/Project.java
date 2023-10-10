//Cade Phillips

package project;

import java.util.*;
import java.util.Locale.Category;

public class Project {
    private UUID id;
    private String title;
    private Category category;
    private Account owner;
    private ArrayList<Account> contributors;
    private ArrayList<Column> columns;
    private ArrayList<Comment> comment;
    private ArrayList<Edit> editHistory;

    public Project(String title, Category category, Account owner){

    }

    public Project(UUID id, String title, Category category, Account owner){

    }

    public void setCategory(Category category) {

    }

    public double viewProgress(){
        return 0.0;
    }

    public boolean isProjectDone(){
        return false;
    }

    public void addAccount(Account account){

    }

    public void removeAccount(Account account){

    }

    public void addColumn(ColumnType columnType){

    }

    public void moveColumnAfter(Column column){
        
    }

    public void removeColumn(Column column){
        
    }

    public void addTask(Column column, String name, int priority){

    }

    public void removeTask(Column column, Task task){

    }

    public void moveTask(Task task, Column column){

    }

    public void orderTask(Task task, int Priority){

    }




}