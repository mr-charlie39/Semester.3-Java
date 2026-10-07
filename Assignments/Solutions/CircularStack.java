import java.util.Scanner;

// Circular stack using an array: when the stack is full, a new push
// wraps around and overwrites the OLDEST element instead of overflowing.
public class CircularStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stack capacity: ");
        int capacity = sc.nextInt();
        int[] stack = new int[capacity];
        int top = -1;  // index of the top element
        int count = 0; // number of elements currently stored

        int choice = 0;
        while (choice != 6) {
            System.out.println("\n--- CIRCULAR STACK MENU ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek (top element)");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter value: ");
                int value = sc.nextInt();
                top = (top + 1) % capacity; // wraps around
                if (count == capacity) {
                    System.out.println("Stack full: oldest value " + stack[top] + " was overwritten.");
                } else {
                    count++;
                }
                stack[top] = value;
            } else if (choice == 2) {
                if (count == 0) {
                    System.out.println("Stack is empty!");
                } else {
                    System.out.println("Popped: " + stack[top]);
                    top = (top - 1 + capacity) % capacity; // wraps backwards
                    count--;
                }
            } else if (choice == 3) {
                if (count == 0) {
                    System.out.println("Stack is empty!");
                } else {
                    System.out.println("Top element: " + stack[top]);
                }
            } else if (choice == 4) {
                if (count == 0) {
                    System.out.println("Stack is empty.");
                } else {
                    System.out.println("Stack (top to bottom):");
                    for (int i = 0; i < count; i++) {
                        System.out.println(stack[(top - i + capacity) % capacity]);
                    }
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
