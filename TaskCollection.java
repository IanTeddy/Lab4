// Lab 4
// Task collection class
import java.util.*;

public class TaskCollection {
    // instatce variables
    private ArrayList<Task> tasks;
    private HashMap<String, Task> taskById;
    private LinkedList<Task> orderOfAddition;

    // constructor
    public TaskCollection(){
        this.tasks = new ArrayList<>();
        this.taskById = new HashMap<>();
        this.orderOfAddition = new LinkedList<>();
    }

    // Add a task to the collection
    public void addTask(Task task){
        tasks.add(task);    // .add() method
        taskById.put(task.getId(),task);    //.put() method
        orderOfAddition.add(task);  //.add() method
    }


    // Remove a task by using its ID
    public void removeTaskByID(String id){
        
        Task removalTask = taskById.get(id);    // to retrieve the value mapped by id and assign to removalTask
        if(removalTask != null){
            tasks.remove(removalTask);
            orderOfAddition.remove(removalTask);
            taskById.remove(id);    // Hash_Map.remove(Object key)
        }
    }

    // Fetch a task using its ID 
    public Task getTaskById(String id){
        return taskById.get(id);
    }

    //List all tasks
    public List<Task> getAllTasks(){
        return tasks;
    }

    // List tasks in the order they were added
    public List<Task> getTasksInOrderOfAddition(){
        return orderOfAddition;
    }

    // List tasks in the hashmap
    public HashMap<String, Task> getTasksInHashmap(){
        return taskById;
    }

}
