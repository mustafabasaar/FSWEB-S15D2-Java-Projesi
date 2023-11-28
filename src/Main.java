import com.workintech.model.*;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        TaskData taskData = new TaskData();

        Task task1 = new Task("ProjectA", "Task1", "ann", Priority.HIGH, Status.IN_QUEUE);
        Task task2 = new Task("ProjectB", "Task2", "bob", Priority.MED, Status.ASSIGNED);
        Task task3 = new Task("ProjectC", "Task3", "carol", Priority.LOW, Status.IN_PROGRESS);
        Task task4 = new Task("ProjectA", "Task4", "ann", Priority.HIGH, Status.IN_QUEUE); // Duplicate task
        Task task5 = new Task("ProjectX","Task5","",Priority.LOW,Status.IN_QUEUE);


        taskData.addTask("ann", task1);
        taskData.addTask("bob", task2);
        taskData.addTask("carol", task3);
        taskData.addTask("ann", task4);
        taskData.addTask("",task5);
        taskData.addTask("bob", task4);


        Manager manager = new Manager();

        System.out.println("Tüm çalışanların üzerindeki tasklar: ");
        Set<Task> allTasks = taskData.getAllTasks();
        System.out.println(allTasks);

        System.out.println("\nHer bir çalışanın üzerindeki tasklar: ");
        Set<Task> unassignedTasks = taskData.getTasks("");
        Set<Task> annsTasks = taskData.getTasks("ann");
        Set<Task> bobsTasks = taskData.getTasks("bob");
        Set<Task> carolsTasks = taskData.getTasks("carol");
        System.out.println("Ann's Tasks: " + annsTasks);
        System.out.println("Bob's Tasks: " + bobsTasks);
        System.out.println("Carol's Tasks: " + carolsTasks);
        System.out.println("UnassignedTasks Tasks: " + unassignedTasks);

        System.out.println("\nHerhangi bir çalışana atanmamış olan tasklar: ");
        Set<Task> tasksWithoutAssignee = manager.getTasksWithoutAssignee(allTasks);
        System.out.println(tasksWithoutAssignee);

        System.out.println("\nBirden fazla çalışana atanmış tasklar: ");
        Set<Task> tasksAssignedToMultiple = manager.getTasksAssignedToMultiple(allTasks);
        System.out.println(tasksAssignedToMultiple);
    }


}