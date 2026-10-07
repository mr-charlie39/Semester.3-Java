import java.util.Scanner;

// Circular queue using an array: when rear reaches the end it wraps to index 0
public class CircularQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter queue capacity: ");
        int capacity = sc.nextInt();
        int[] queue = new int[capacity];
        int front = 0; // index of the first element
        int count = 0; // number of elements

        int choice = 0;
        while (choice != 7) {
            System.out.println("\n--- CIRCULAR QUEUE MENU ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek (front element)");
            System.out.println("4. Display");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                if (count == capacity) {
                    System.out.println("Queue is full!");
                } else {
                    System.out.print("Enter value: ");
                    int rear = (front + count) % capacity; // wraps around
                    queue[rear] = sc.nextInt();
                    count++;
                }
            } else if (choice == 2) {
                if (count == 0) {
                    System.out.println("Queue is empty!");
                } else {
                    System.out.println("Removed: " + queue[front]);
                    front = (front + 1) % capacity; // wraps around
                    count--;
                }
            } else if (choice == 3) {
                if (count == 0) {
                    System.out.println("Queue is empty!");
                } else {
                    System.out.println("Front element: " + queue[front]);
                }
            } else if (choice == 4) {
                if (count == 0) {
                    System.out.println("Queue is empty.");
                } else {
                    System.out.print("Front -> ");
                    for (int i = 0; i < count; i++) {
                        System.out.print(queue[(front + i) % capacity] + " ");
                    }
                    System.out.println("<- Rear");
                }
            } else if (choice == 5) {
                System.out.println(count == 0 ? "Yes, empty." : "No, not empty.");
            } else if (choice == 6) {
                System.out.println(count == capacity ? "Yes, full." : "No, not full.");
            } else if (choice != 7) {
                System.out.println("Invalid choice!");
            }
        }
        System.out.println("Goodbye!");
    }
}
