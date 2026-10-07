import java.util.*;

public class Assignment_1_Program_3 {
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
        loadingAnimation("Initializing Queue Manager");
        System.out.print(BOLD + YELLOW + "\nEnter the maximum capacity of the queue: " + RESET);
        int capacity = readIntInput();
        Queue queue = new Queue(capacity);

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = readChoice();

            switch (choice) {
                case 1:
                    printActionHeader("Enqueue");
                    System.out.print(BOLD + YELLOW + "Enter token to enqueue: " + RESET);
                    int token = readIntInput();
                    queue.enqueue(token);
                    break;
                case 2:
                    printActionHeader("Dequeue");
                    queue.dequeue();
                    break;
                case 3:
                    printActionHeader("Display");
                    queue.display();
                    break;
                case 4:
                    printActionHeader("Size");
                    int size = queue.size();
                    System.out.println(BOLD + YELLOW + "Queue size: " + size + RESET);
                    break;
                case 5:
                    printActionHeader("isEmpty");
                    boolean empty = queue.isEmpty();
                    if(empty){
                        System.out.println(GREEN + BOLD + "✔ The queue is empty.\n" + RESET);
                    } else {
                        System.out.println(RED + BOLD + "✖ The queue is not empty.\n" + RESET);
                    }
                    break;
                case 6:
                    printActionHeader("isFull");
                    boolean full = queue.isFull();
                    if(full){
                        System.out.println(GREEN + BOLD + "✔ The queue is full.\n" + RESET);
                    } else {
                        System.out.println(RED + BOLD + "✖ The queue is not full.\n" + RESET);
                    }
                    break;
                case 7:
                    running = false;
                    exitAnimation();
                    break;
                default:
                    System.out.println(RED + BOLD + "\n  ✖ Invalid choice! Please select 1-7.\n" + RESET);
            }

            if (running) pauseForEffect();
        }

        sc.close();
    }

    private static void printBanner() {
        String[] banner = {
                " ██████╗ ██╗   ██╗███████╗██╗   ██╗███████╗",
                "██╔═══██╗██║   ██║██╔════╝██║   ██║██╔════╝",
                "██║   ██║██║   ██║█████╗  ██║   ██║█████╗  ",
                "██║▄▄ ██║██║   ██║██╔══╝  ██║   ██║██╔══╝  ",
                "╚██████╔╝╚██████╔╝███████╗╚██████╔╝███████╗",
                " ╚══▀▀═╝  ╚═════╝ ╚══════╝ ╚═════╝ ╚══════╝"
        };

        String[] colors = { BLUE, CYAN, GREEN, GREEN, CYAN, BLUE };

        System.out.println();
        for (int i = 0; i < banner.length; i++) {
            System.out.println(BOLD + colors[i] + banner[i] + RESET);
            sleep(80);
        }
        System.out.println(BOLD + YELLOW + "          F I F O   Q U E U E   M A N A G E R" + RESET);
        System.out.println(GREEN + "          " + "─".repeat(40) + RESET);
        sleep(300);
    }

    private static void displayMenu() {
        clearConsoleEffect();
        String title = "QUEUE MENU";
        String border = "═".repeat(34);

        System.out.println(CYAN + BOLD + "╔" + border + "╗" + RESET);
        System.out.println(CYAN + BOLD + "║" + centerText(title, 34) + "║" + RESET);
        System.out.println(CYAN + BOLD + "╠" + border + "╣" + RESET);

        printMenuItem(1, "Enqueue",  GREEN);
        printMenuItem(2, "Dequeue",  GREEN);
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
        System.out.println(YELLOW + BOLD + "\nClosing Queue Manager");
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

class Queue {
    private int[] tokens;
    private int front, rear, capacity, currentSize;

    public Queue(int size) {
        tokens = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    public void enqueue(int token) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
        } else {
            rear = (rear + 1) % capacity;
            tokens[rear] = token;
            currentSize++;
            System.out.println("Enqueued: " + token);
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        } else {
            int token = tokens[front];
            front = (front + 1) % capacity;
            currentSize--;
            System.out.println("Dequeued: " + token);
            return token;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements (front to rear): ");
            for (int i = 0; i < currentSize; i++) {
                int index = (front + i) % capacity;
                System.out.print(tokens[index] + " ");
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        return currentSize == capacity;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }
}
