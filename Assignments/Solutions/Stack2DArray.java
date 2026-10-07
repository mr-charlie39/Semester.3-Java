import java.util.Scanner;

// Stack stored in a 2D array (rows x cols).
// Element number k lives at row = k / cols and column = k % cols.
public class Stack2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        int[][] stack = new int[rows][cols];
        int capacity = rows * cols;
        int top = -1; // -1 means empty

        int choice = 0;
        while (choice != 6) {
            System.out.println("\n--- STACK (2D ARRAY) MENU ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display (grid)");
            System.out.println("5. Size");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                if (top == capacity - 1) {
                    System.out.println("Stack Overflow! Stack is full.");
                } else {
                    System.out.print("Enter value: ");
                    top++;
                    stack[top / cols][top % cols] = sc.nextInt();
                }
            } else if (choice == 2) {
                if (top == -1) {
                    System.out.println("Stack Underflow! Stack is empty.");
                } else {
                    System.out.println("Popped: " + stack[top / cols][top % cols]);
                    top--;
                }
            } else if (choice == 3) {
                if (top == -1) {
                    System.out.println("Stack is empty!");
                } else {
                    System.out.println("Top element: " + stack[top / cols][top % cols]);
                }
            } else if (choice == 4) {
                System.out.println("Grid ('.' = empty slot):");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        int position = i * cols + j;
                        if (position <= top) {
                            System.out.print(stack[i][j] + "\t");
                        } else {
                            System.out.print(".\t");
                        }
                    }
                    System.out.println();
                }
            } else if (choice == 5) {
                System.out.println("Size: " + (top + 1));
            } else if (choice != 6) {
                System.out.println("Invalid choice!");
            }
        }
        System.out.println("Goodbye!");
    }
}
