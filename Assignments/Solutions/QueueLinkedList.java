import java.util.Scanner;

// Queue using a linked list: enqueue at the rear, dequeue at the front
class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class QueueLinkedList {
    static QueueNode front = null;
    static QueueNode rear = null;
    static int size = 0;

    static void enqueue(int value) {
        QueueNode newNode = new QueueNode(value);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    static void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Removed: " + front.data);
            front = front.next;
            if (front == null) {
                rear = null; // queue became empty
            }
            size--;
        }
    }

    static void peek() {
        if (front == null) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Front element: " + front.data);
        }
    }

    static void display() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Front -> ");
        QueueNode temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("<- Rear");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 7) {
            System.out.println("\n--- QUEUE (LINKED LIST) MENU ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. isEmpty");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter value: ");
                enqueue(sc.nextInt());
            } else if (choice == 2) {
                dequeue();
            } else if (choice == 3) {
                peek();
            } else if (choice == 4) {
                display();
            } else if (choice == 5) {
                System.out.println("Size: " + size);
            } else if (choice == 6) {
                System.out.println(front == null ? "Yes, empty." : "No, not empty.");
            } else if (choice != 7) {
                System.out.println("Invalid choice!");
            }
        }
        System.out.println("Goodbye!");
    }
}
