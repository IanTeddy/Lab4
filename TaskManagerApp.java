// Lab 4
// TaskManagerApp class including main method

import java.util.Map;
import java.util.Scanner;

public class TaskManagerApp {

    public static void main(String[] args) {
        
        // create TaskCollection object
        TaskCollection taskCollection = new TaskCollection();

        //1. Prompt user for actions (add, remove, list, etc.)
        Scanner in = new Scanner(System.in);


        // Ask user to enter tasks
        boolean stopEntering = false;
        int selectedNum = 0;

        do{
            System.out.print("Enter your task ID: ");
            String inputID = in.nextLine();
            System.out.print("Name your task: ");
            String inputName = in.nextLine();
            System.out.print("Enter the description: ");
            String inputDescription = in.nextLine();

            // 2. Gather input and create Task objects
            Task inputTask = new Task(null, null, null);
            inputTask.setId(inputID);
            inputTask.setName(inputName);
            inputTask.setDescription(inputDescription);

            // 3. Add tasks to TaskCollection
            taskCollection.addTask(inputTask);
            
            System.out.println(" ");

            // Ask if the user want to add more tasks
            System.out.print("Select a number: 1)Add, 2)Delete, 3) Show Your Task => ");
            selectedNum = in.nextInt();
            in.nextLine();
            if(selectedNum == 1){
                stopEntering = false;
            } else if(selectedNum == 2){    
                // 3-2. Delete action from TaskCollection
                System.out.print("Which task would you like to delete?");
                String deleteTaskId = in.nextLine();
                Task deleteTask = taskCollection.getTaskById(deleteTaskId);
                System.out.printf("Task[%s] has been deleted.%n",deleteTask.getName());
                taskCollection.removeTaskByID(deleteTaskId);
                stopEntering = true;
            } 
            } while(!stopEntering);

        // 4. Display tasks to the user
        // Dislay the Array list
        System.out.println("----Arraylist-----");
        for (Task yourTask : taskCollection.getAllTasks()) {
            System.out.printf("No.%s %s: %s%n",yourTask.getId(),yourTask.getName(),yourTask.getDescription());
        }
        // Display LinkedList
        System.out.println("----LinkedList----");
        for (Task yourTask: taskCollection.getTasksInOrderOfAddition()){
            System.out.printf("No.%s %s: %s%n",yourTask.getId(),yourTask.getName(),yourTask.getDescription());
        }
        // Display Hashmap 
        System.out.println("----Hashmap----");
        for(Map.Entry<String,Task> yourTaskList : taskCollection.getTasksInHashmap().entrySet()){
            // String indexNum = yourTaskList.getKey(); 
            Task yourTask = yourTaskList.getValue();
            System.out.printf("No.%s %s: %s%n",yourTask.getId(),yourTask.getName(),yourTask.getDescription());
        }

        in.close();
    }
}
