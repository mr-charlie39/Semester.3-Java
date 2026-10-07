import java.util.*;

public class Assignment_1_Program_2 {
    public static final String RESET   = "\u001B[0m";
    public static final String BOLD    = "\u001B[1m";
    public static final String CYAN    = "\u001B[36m";
    public static final String GREEN   = "\u001B[32m";
    public static final String YELLOW  = "\u001B[33m";
    public static final String PURPLE  = "\u001B[35m";
    public static final String RED     = "\u001B[31m";
    public static final String BLUE    = "\u001B[34m";
    public static final String WHITE   = "\u001B[37m";

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        printBanner();
        loadingAnimation("Initializing Stack Manager");

        System.out.print(BOLD + YELLOW + "\nEnter the maximum capacity of the stack: " + RESET);
        int capacity = readIntInput();
        Plate stack = new Plate(capacity);
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = readChoice();

            switch (choice) {
                case 1: {
                    printActionHeader("Push");
                    System.out.print(BOLD + YELLOW + "Enter the plate number to push: " + RESET);
                    int plateNumber = readIntInput();
                    stack.push(plateNumber);
                    break;
                }
                case 2: {
                    printActionHeader("Pop");
                    stack.pop();
                    break;
                }
                case 3: {
                    printActionHeader("Display");
                    stack.display();
                    break;
                }
                case 4: {
                    printActionHeader("Size");
                    int size = stack.size();
                    System.out.println(BOLD + YELLOW + "Current size of the stack: " + size + RESET);
                    break;
                }
                case 5: {
                    printActionHeader("isEmpty");
                    boolean empty = stack.isEmpty();
                    if(empty){
                        System.out.println(GREEN + BOLD + "✔ The stack is empty.\n" + RESET);
                    } else {
                        System.out.println(RED + BOLD + "✖ The stack is not empty.\n" + RESET);
                    }
                    break;
                }
                case 6: {
                    printActionHeader("isFull");
                    boolean full = stack.isFull();
                    if(full){
                        System.out.println(GREEN + BOLD + "✔ The stack is full.\n" + RESET);
                    } else {
                        System.out.println(RED + BOLD + "✖ The stack is not full.\n" + RESET);
                    }
                    break;
                }
                case 7: {
                    running = false;
                    exitAnimation();
                    break;
                }
                default:
                    System.out.println(RED + BOLD + "\n  ✖ Invalid choice! Please select 1-7.\n" + RESET);
            }

            if (running) pauseForEffect();
        }

        sc.close();
    }

    private static void printBanner() {
        String[] banner = {
                "███████╗████████╗ █████╗  ██████╗██╗  ██╗",
                "██╔════╝╚══██╔══╝██╔══██╗██╔════╝██║ ██╔╝",
                "███████╗   ██║   ███████║██║     █████╔╝ ",
                "╚════██║   ██║   ██╔══██║██║     ██╔═██╗ ",
                "███████║   ██║   ██║  ██║╚██████╗██║  ██╗",
                "╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝"
        };

        String[] colors = { PURPLE, BLUE, CYAN, CYAN, BLUE, PURPLE };

        System.out.println();
        for (int i = 0; i < banner.length; i++) {
            System.out.println(BOLD + colors[i] + banner[i] + RESET);
            sleep(80);
        }
        System.out.println(BOLD + YELLOW + "          L I F O   S T A C K   M A N A G E R" + RESET);
        System.out.println(GREEN + "          " + "─".repeat(40) + RESET);
        sleep(300);
    }

    private static void displayMenu() {
        clearConsoleEffect();
        String title = "STACK MENU";
        String border = "═".repeat(34);

        System.out.println(CYAN + BOLD + "╔" + border + "╗" + RESET);
        System.out.println(CYAN + BOLD + "║" + centerText(title, 34) + "║" + RESET);
        System.out.println(CYAN + BOLD + "╠" + border + "╣" + RESET);

        printMenuItem(1, "Push",     GREEN);
        printMenuItem(2, "Pop",      GREEN);
        printMenuItem(3, "Display",  BLUE);
        printMenuItem(4, "Size",     BLUE);
        printMenuItem(5, "isEmpty",  PURPLE);
        printMenuItem(6, "isFull",   PURPLE);
        printMenuItem(7, "Exit",     RED);

        System.out.println(CYAN + BOLD + "╚" + border + "╝" + RESET);
        System.out.print(BOLD + YELLOW + "\n➤ Enter your choice: " + RESET);
    }

    private static void printMenuItem(int number, String label, String color) {
        String numStr = String.format("%2d", number);
        System.out.println(CYAN + "║ " + RESET + color + BOLD + numStr + ". " + RESET
                + String.format("%-29s", label) + CYAN + "║" + RESET);
    }

    private static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padding; i++) sb.append(" ");
        sb.append(BOLD).append(text).append(RESET).append(CYAN).append(BOLD);
        while (sb.length() < width + (BOLD + RESET + CYAN + BOLD).length()) sb.append(" ");
        return sb.toString();
    }

    private static int readChoice() {
        return readIntInput();
    }

    private static int readIntInput() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print(RED + BOLD + "Invalid input. Please enter a valid number: " + RESET);
            }
        }
    }

    private static void loadingAnimation(String message) {
        System.out.print(PURPLE + BOLD + message + RESET);
        for (int i = 0; i < 5; i++) {
            System.out.print(GREEN + "." + RESET);
            sleep(200);
        }
        System.out.println(GREEN + BOLD + " Done!\n" + RESET);
    }

    private static void printActionHeader(String action) {
        System.out.println(BOLD + GREEN + "\n▶ " + action + " selected...\n" + RESET);
    }

    private static void pauseForEffect() {
        System.out.print(WHITE + "\nPress ENTER to continue..." + RESET);
        sc.nextLine();
    }

    private static void exitAnimation() {
        System.out.println(YELLOW + BOLD + "\nClosing Stack Manager");
        for (int i = 0; i < 3; i++) {
            System.out.print(YELLOW + "." + RESET);
            sleep(300);
        }
        System.out.println(GREEN + BOLD + "\n✔ Goodbye!\n" + RESET);
    }

    private static void clearConsoleEffect() {
        System.out.println("\n".repeat(1));
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }
}

class Plate {

    private int[] plates;
    private int top;
    private int capacity;

    public Plate(int capacity) {
        this.capacity = capacity;
        plates = new int[capacity];
        top = -1;
    }

    public void push(int plate) {
        if(isFull()) {
            System.out.println("Stack is full. Cannot push plate " + plate);
        } else {
            plates[++top] = plate;
            System.out.println("Plate " + plate + " pushed to stack.");
        }
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        } else {
            int popped = plates[top--];
            System.out.println("Plate " + popped + " popped from stack.");
            return popped;
        }
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Current stack (top to bottom):");
            for(int i = top; i >= 0; i--) {
                System.out.println(plates[i]);
            }
        }
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
    public boolean isEmpty() {
        return top < 0;
    }
    public int size() {
        return top + 1;
    }
}
