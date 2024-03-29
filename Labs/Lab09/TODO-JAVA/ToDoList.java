import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        while (true) {
            System.out.println("\n===== To-Do List Menu =====");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Remove Task");
            System.out.println("4. View To-Do List");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    markTaskAsCompleted();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    viewTodoList();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();
        tasks.add(new Task(taskName));
        System.out.println("Task '" + taskName + "' added to the to-do list.");
    }

    private static void markTaskAsCompleted() {
        System.out.print("Enter task name to mark as completed: ");
        String taskName = scanner.nextLine();
        boolean found = false;

        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(taskName)) {
                task.markAsCompleted();
                found = true;
                System.out.println("Task '" + taskName + "' marked as completed.");
                break;
            }
        }

        if (!found) {
            System.out.println("Task not found in the to-do list.");
        }
    }

    private static void removeTask() {
        System.out.print("Enter task name to remove: ");
        String taskName = scanner.nextLine();
        boolean removed = tasks.removeIf(task -> task.getName().equalsIgnoreCase(taskName));

        if (removed) {
            System.out.println("Task '" + taskName + "' removed from the to-do list.");
        } else {
            System.out.println("Task not found in the to-do list.");
        }
    }

    private static void viewTodoList() {
        System.out.println("\n===== To-Do List =====");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
