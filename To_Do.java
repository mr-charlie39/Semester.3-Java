import java.util.Scanner;
import java.util.ArrayList;

public class To_Do {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArrayList<String> tasks = new ArrayList<>();
        boolean running = true;
        while (running) {

        System.out.println("-------------------------");
        System.out.println("| CHOOSE THE OPERATION: |");
        System.out.println("-------------------------");

        System.out.println("________________________\n");
        System.out.println("1. Add a task");
        System.out.println("2. View all tasks");
        System.out.println("3. Remove a task");
        System.out.println("4. Exit");
        System.out.println("________________________");

        int choice = s.nextInt();

      
        
            switch (choice) {
                case 1:
                    System.out.print("Enter the task to add:");
                    s.nextLine();
                    String task = s.nextLine();
                    tasks.add(task);

                    String msg = "Task added successfully!";
                    for (int i = 0; i < msg.length(); i++) {
                        System.out.print(msg.charAt(i));
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Your tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println("Task " + (i + 1) + " is : " + tasks.get(i));
                    }
                    break;
                case 3:
                    System.out.println("Enter the task number to remove:");
                    int taskNum = s.nextInt();
                    if (taskNum > 0 && taskNum <= tasks.size()) {
                        tasks.remove(taskNum - 1);
                        System.out.println("Task removed successfully!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 4:
                    String msgg = "Exiting the program. Goodbye!";
                    for (int i = 0; i < msgg.length(); i++) {
                        System.out.print(msgg.charAt(i));
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
        s.close();
    }

}