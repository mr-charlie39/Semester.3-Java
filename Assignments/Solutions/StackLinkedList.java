import java.util.Scanner;

// Stack using a linked list: push and pop both happen at the head (top)
class StackNode {
    int data;
    StackNode next;

    StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackLinkedList {
    static StackNode top = null;
    static int size = 0;

    static void push(int value) {
        StackNode newNode = new StackNode(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    static void pop() {
        if (top == null) {
            System.out.println("Stack Underflow! Stack is empty.");
        } else {
            System.out.println("Popped: " + top.data);
            top = top.next;
            size--;
        }
    }

    static void peek() {
        if (top == null) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Top element: " + top.data);
        }
    }

    static void display() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack (top to bottom):");
        StackNode temp = top;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 7) {
            System.out.println("\n--- STACK (LINKED LIST) MENU ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. isEmpty");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter value: ");
                push(sc.nextInt());
            } else if (choice == 2) {
                pop();
            } else if (choice == 3) {
                peek();
            } else if (choice == 4) {
                display();
            } else if (choice == 5) {
                System.out.println("Size: " + size);
            } else if (choice == 6) {
                System.out.println(top == null ? "Yes, empty." : "No, not empty.");
            } else if (choice != 7) {
                System.out.println("Invalid choice!");
            }
        }
        System.out.println("Goodbye!");
    }
}
