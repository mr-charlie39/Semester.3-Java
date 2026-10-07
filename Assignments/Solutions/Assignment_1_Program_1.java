import java.util.*;

class Assignment_1_Program_1 {

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
        int[] books = new int[10];
        printBanner();
        loadingAnimation("Initializing Library Shelf Manager");

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = readChoice();

            switch (choice) {
                case 1: {
                    printActionHeader("Add value");
                    AdditionOFBooks additionOFBooks = new AdditionOFBooks();
                    additionOFBooks.addBook(books);
                    break;
                }
                case 2: {
                    printActionHeader("Insert at index");
                    AdditionOFBooks additionOFBooks = new AdditionOFBooks();
                    additionOFBooks.indexInsertion(books);
                    break;
                }
                case 3: {
                    printActionHeader("Fill array");
                    AdditionOFBooks additionOFBooks = new AdditionOFBooks();
                    additionOFBooks.fillArray(books);
                    break;
                }
                case 4: {
                    printActionHeader("Delete last element");
                    DeletionBooks deletionBooks = new DeletionBooks();
                    deletionBooks.deleteLastElement(books);
                    break;
                }
                case 5: {
                    printActionHeader("Delete by index");
                    DeletionBooks deletionBooks = new DeletionBooks();
                    deletionBooks.deleteByIndex(books);
                    break;
                }
                case 6: {
                    printActionHeader("Display");
                    AdditionOFBooks additionOFBooks = new AdditionOFBooks();
                    additionOFBooks.displayBook(books);
                    break;
                }
                case 7: {
                    printActionHeader("Search value");
                    UpdationBooks updationBooks = new UpdationBooks();
                    updationBooks.searchValue(books);
                    break;
                }
                case 8: {
                    printActionHeader("Get value at index");
                    UpdationBooks updationBooksGet = new UpdationBooks();
                    updationBooksGet.displayByIndex(books);
                    break;
                }
                case 9: {
                    printActionHeader("Replace/Update value at index");
                    UpdationBooks updationBooksUpdate = new UpdationBooks();
                    updationBooksUpdate.updateValueAtindex(books);
                    break;
                }
                case 10:
                    printActionHeader("Size");
                    System.out.println("Current size of the array: " + books.length);
                    break;
                case 11:
                    running = false;
                    exitAnimation();
                    break;
                default:
                    System.out.println(RED + BOLD + "\n  ✖ Invalid choice! Please select 1-11.\n" + RESET);
            }

            if (running) pauseForEffect();
        }

        sc.close();
    }

    private static void printBanner() {
        String[] banner = {
                " █████╗  ██████╗ ██████╗   █████╗ ██╗   ██╗",
                "██╔══██╗ ██╔══██╗██╔══██╗ ██╔══██╗ ╚██╗ ██╔╝",
                "███████║ ██████╔╝██████╔╝ ███████║  ╚████╔╝ ",
                "██╔══██║ ██╔══██╗██╔══██╗ ██╔══██║   ╚██╔╝  ",
                "██║  ██║ ██║  ██║██║  ██║ ██║  ██║    ██║   ",
                "╚═╝  ╚═╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═╝  ╚═╝    ╚═╝   "
        };

        String[] colors = { CYAN, BLUE, PURPLE, PURPLE, BLUE, CYAN };

        System.out.println();
        for (int i = 0; i < banner.length; i++) {
            System.out.println(BOLD + colors[i] + banner[i] + RESET);
            sleep(80);
        }
        System.out.println(BOLD + YELLOW + "        L I B R A R Y   S H E L F   M A N A G E R" + RESET);
        System.out.println(GREEN + "        " + "─".repeat(44) + RESET);
        sleep(300);
    }

    private static void displayMenu() {
        clearConsoleEffect();
        String title = "ARRAY MENU";
        String border = "═".repeat(38);

        System.out.println(CYAN + BOLD + "╔" + border + "╗" + RESET);
        System.out.println(CYAN + BOLD + "║" + centerText(title, 38) + "║" + RESET);
        System.out.println(CYAN + BOLD + "╠" + border + "╣" + RESET);

        printMenuItem(1,  "Add value",                    GREEN);
        printMenuItem(2,  "Insert at index",               GREEN);
        printMenuItem(3,  "Fill array",                    GREEN);
        printMenuItem(4,  "Delete last element",           YELLOW);
        printMenuItem(5,  "Delete by index",                YELLOW);
        printMenuItem(6,  "Display",                       BLUE);
        printMenuItem(7,  "Search value",                  BLUE);
        printMenuItem(8,  "Get value at index",             PURPLE);
        printMenuItem(9,  "Replace/Update value at index",  PURPLE);
        printMenuItem(10, "Size",                           WHITE);
        printMenuItem(11, "Exit",                           RED);

        System.out.println(CYAN + BOLD + "╚" + border + "╝" + RESET);
        System.out.print(BOLD + YELLOW + "\n➤ Enter your choice: " + RESET);
    }

    private static void printMenuItem(int number, String label, String color) {
        String numStr = String.format("%2d", number);
        System.out.println(CYAN + "║ " + RESET + color + BOLD + numStr + ". " + RESET
                + String.format("%-33s", label) + CYAN + "║" + RESET);
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
        int choice = -1;
        try {
            choice = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            choice = -1;
        }
        return choice;
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
        System.out.println(YELLOW + BOLD + "\nClosing Library Shelf Manager");
        for (int i = 0; i < 3; i++) {
            System.out.print(YELLOW + "." + RESET);
            sleep(300);
        }
        System.out.println(GREEN + BOLD + "\n✔ Goodbye!\n" + RESET);
    }

    private static void clearConsoleEffect() {
        System.out.print("\n".repeat(1));
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }
}

class AdditionOFBooks {
    Scanner scanner = new Scanner(System.in);

    public void displayBook(int[] books) {
        if(books.length == 0) {
            System.out.println("Array is empty. No book IDs to display.");
        } else {
            System.out.println("Current book IDs in the array:");
            for(int i = 0; i < books.length; i++) {
                System.out.println("Index " + i + ": Book ID " + books[i]);
            }
        }
    }

    public void addBook(int[] books) {
        if(books != null && books.length > 0) {
            System.out.print("Enter the number of books to add (up to " + books.length + "): ");
            int count = scanner.nextInt();
            for(int i = 0; i < count && i < books.length; i++) {
                System.out.print("Enter book ID for book " + (i + 1) + ": ");
                int bookId = scanner.nextInt();
                books[i] = bookId;
            }
        }
    }

    public void indexInsertion(int[] books) {
        System.out.print("How many books do you want to insert? ");
        int count = scanner.nextInt();
        if(count <= books.length) {
            for(int i = 0 ; i < count; i++) {
                System.out.print("Enter the index where you want to insert the book ID: ");
                int index = scanner.nextInt();
                if(index >= 0 && index < books.length) {
                    System.out.print("Enter the book ID to insert: ");
                    int bookId = scanner.nextInt();
                    books[index] = bookId;
                } else {
                    System.out.println("Invalid index. Please enter a value between 0 and " + (books.length - 1));
                }
            }
        } else {
            System.out.println("You cannot insert more books than the array size.");
        }
    }

    public void fillArray(int[] books) {
        if(books != null && books.length > 0) {
            System.out.println("Filling the array with book IDs.");
            for(int i = 0; i < books.length; i++) {
                System.out.print("Enter book ID for book " + (i + 1) + ": ");
                books[i] = scanner.nextInt();
            }
        } else {
            System.out.println("The array is empty or not initialized.");
        }
    }
}

class DeletionBooks {
    Scanner scanner = new Scanner(System.in);

    public void deleteLastElement(int[] books) {
        int size = books.length;
        if(size > 0) {
            books[size - 1] = 0;
            System.out.println("Last book ID deleted.");
        } else {
            System.out.println("Array is empty. No book ID to delete.");
        }
    }

    public void deleteByIndex(int[] books) {
        if(books.length == 0){
            System.out.println("Array is empty. No book ID to delete.");
        } else {
            System.out.println("Array contents:");
            for(int i = 0; i < books.length; i++) {
                System.out.println("Index " + i + ": Book ID " + books[i]);
            }
            System.out.print("Enter the index of the book ID to delete (0 to " + (books.length - 1) + "): ");
            int index = scanner.nextInt();
            if(index >= 0 && index < books.length) {
                books[index] = 0;
                System.out.println("Book ID at index " + index + " deleted.");
            } else {
                System.out.println("Invalid index. Please enter a value between 0 and " + (books.length - 1));
            }
        }
    }
}

class UpdationBooks {
    Scanner scanner = new Scanner(System.in);

    public void searchValue(int[] books) {
        if(books.length == 0) {
            System.out.println("Array is empty. No book ID to search.");
        } else {
            System.out.print("Enter the book ID to search for: ");
            int bookId = scanner.nextInt();
            boolean found = false;
            for(int i = 0; i < books.length; i++) {
                if(books[i] == bookId) {
                    System.out.println("Book ID " + bookId + " found at index " + i);
                    found = true;
                    break;
                }
            }
            if(!found) {
                System.out.println("Book ID " + bookId + " not found.");
            }
        }
    }

    public void displayByIndex(int[] books) {
        if(books.length == 0) {
            System.out.println("Array is empty. No book ID to display.");
        } else {
            System.out.print("Enter the index of the book ID to display (0 to " + (books.length - 1) + "): ");
            int index = scanner.nextInt();
            if(index >= 0 && index < books.length) {
                System.out.println("Book ID at index " + index + ": " + books[index]);
            } else {
                System.out.println("Invalid index. Please enter a value between 0 and " + (books.length - 1));
            }
        }
    }

    public void updateValueAtindex(int[] books) {
        if(books.length == 0) {
            System.out.println("Array is empty. No book ID to update.");
        } else {
            System.out.println("Array Content:");
            for(int i = 0; i < books.length; i++) {
                System.out.println("Index " + i + ": Book ID " + books[i]);
            }
            System.out.print("Enter the index of the book ID to update (0 to " + (books.length - 1) + "): ");
            int index = scanner.nextInt();
            if(index >= 0 && index < books.length) {
                System.out.print("Enter the new book ID to replace the old one: ");
                int newBookId = scanner.nextInt();
                books[index] = newBookId;
                System.out.println("Book ID at index " + index + " updated to " + newBookId);
            } else {
                System.out.println("Invalid index. Please enter a value between 0 and " + (books.length - 1));
            }
        }
    }
}
