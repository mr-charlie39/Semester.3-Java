import java.util.Scanner;

// Queue stored in a 2D array (rows x cols).
// Slot number k lives at row = k / cols and column = k % cols.
public class Queue2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        int[][] queue = new int[rows][cols];
        int capacity = rows * cols;
        int front = 0; // slot number of the first element
        int count = 0; // number of elements

        int choice = 0;
        while (choice != 6) {
            System.out.println("\n--- QUEUE (2D ARRAY) MENU ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display (grid)");
            System.out.println("5. Size");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                if (count == capacity) {
                    System.out.println("Queue is full!");
                } else {
                    System.out.print("Enter value: ");
                    int rear = (front + count) % capacity;
                    queue[rear / cols][rear % cols] = sc.nextInt();
                    count++;
                }
            } else if (choice == 2) {
                if (count == 0) {
                    System.out.println("Queue is empty!");
                } else {
                    System.out.println("Removed: " + queue[front / cols][front % cols]);
                    front = (front + 1) % capacity;
                    count--;
                }
            } else if (choice == 3) {
                if (count == 0) {
                    System.out.println("Queue is empty!");
                } else {
                    System.out.println("Front element: " + queue[front / cols][front % cols]);
                }
            } else if (choice == 4) {
                System.out.println("Grid ('.' = empty slot):");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        int position = i * cols + j;
                        // a slot is used if it is within 'count' steps after 'front'
                        int distance = (position - front + capacity) % capacity;
                        if (distance < count) {
                            System.out.print(queue[i][j] + "\t");
                        } else {
                            System.out.print(".\t");
                        }
                    }
                    System.out.println();
                }
            } else if (choice == 5) {
                System.out.println("Size: " + count);
            } else if (choice != 6) {
                System.out.println("Invalid choice!");
            }
        }
        System.out.println("Goodbye!");
    }
}
