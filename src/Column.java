package src;

import java.util.ArrayList;

/**
 * A column of the Scrum Board within a specified project.
 * @author Michael Pikula, Miles Wedeking
 */
public class Column
{
    private String title;
    private ArrayList<Task> tasks;
    private ArrayList<Task> sortedTasks;
    private int totalColumnTasks;

    /**
     * Creates a column with the specified title and initializes its list of tasks.
     * @param title The specified title of the column.
     */
    public Column(String title)
    {
        this.title = title;
        this.tasks = new ArrayList<Task>();
    }
    /**
     * Creates a column with the specified parameters.
     * @param title name of the column.
     * @param tasks provided list of tasks to be added to the column
     */
    public Column(String title, ArrayList<Task> tasks)
    {
        this.title = title;
        this.tasks = tasks;
    }
    
    // Accessors
    public String getTitle()
    {
        return this.title;
    }
    public ArrayList<Task> getTasks()
    {
        return this.tasks;
    }

    /**
     * Returns a string representation of the column.
     * @return A string containing the column's title and all of its tasks.
     */
    public String toString()
    {
        String out = "Column: " + title;
        for (int i=0; i< tasks.size(); i++)
            title += "\n" + tasks.get(i);
        return out;
    }
    /**
     * Checks if this column and the specified column are equivalent via their titles.
     * @return true if the column titles are equal.
     */
    public boolean equals(Object column)
    {
        return column != null && this.getClass() == column.getClass()
            && this.getTitle().equals(((Column)column).getTitle());
    }
    /**
     * Adds a new Task to this column.
     * @param name The name of the new Task.
     * @param priority The task's relative priority.
     */
    public void addTask(String name, int priority)
    {
        Task newTask = new Task(name, priority);
        tasks.add(newTask);
    }
    /**
     * Adds an already-created Task to this column.
     * @param task Task to be added.
     */
    public void addTask(Task task)
    {
        tasks.add(task);
    }
    /**
     * Removes the specified task from the column.
     * @param task The task to be removed from the column.
     * @return true if the specified task exists in the column.
     */
    public boolean removeTask(Task task)
    {
        return tasks.remove(task);
    }
    /**
     * Order's the tasks in alphabetical order,
     * in a particular column of tasks.
     * 
     * Tasks the current list of tasks, and passes them all to an array.
     * The array is sorted using bubble sort.
     * Then, the sortedArray is then passed back into a list called sortedTasks
     */
     public void orderTasks(){
        Task[] taskArray = new Task[tasks.size()];  // Add each task to an Array
        Task tempTask;
        for(int i = 0; i < tasks.size(); i++){
            tempTask = tasks.get(i);
            taskArray[i] = tempTask;
        }
        //Bubble sort
        boolean swapped = false;
        for(int i = 0; i < taskArray.length; i++){      // Sort the array.
            if(taskArray[i].getName().charAt(0) >
            taskArray[i+1].getName().charAt(0)){
                //swapping
                tempTask = taskArray[i];
                taskArray[i] = taskArray[i+1];
                taskArray[i+1] = tempTask;
                swapped = true;
            }
            else{
                if(swapped == false){
                    break;
                }
            }
        }
        //Transfer sorted tasks from taskArray, and pass back to a list.
        for(int i = 0; i < taskArray.length; i++){
            Task temp = taskArray[i];
            sortedTasks.add(temp);
        }
    }
}