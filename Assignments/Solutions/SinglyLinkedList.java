import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyList {
    private Node head;
    private int size;

    public SinglyList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    // Insert at the beginning
    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Insert at the end
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    // Insert at a given position (0-based)
    public boolean insertAtPosition(int position, int value) {
        if (position < 0 || position > size) {
            return false;
        }
        if (position == 0) {
            insertAtBeginning(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
        return true;
    }

    // Delete the first node
    public boolean deleteFirst() {
        if (head == null) {
            return false;
        }
        head = head.next;
        size--;
        return true;
    }

    // Delete the last node
    public boolean deleteLast() {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        size--;
        return true;
    }

    // Delete the first node holding the given value
    public boolean deleteByValue(int value) {
        if (head == null) {
            return false;
        }
        if (head.data == value) {
            head = head.next;
            size--;
            return true;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }
        if (temp.next == null) {
            return false;
        }
        temp.next = temp.next.next;
        size--;
        return true;
    }

    // Delete the node at a given position (0-based)
    public boolean deleteAtPosition(int position) {
        if (position < 0 || position >= size) {
            return false;
        }
        if (position == 0) {
            return deleteFirst();
        }
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
        return true;
    }

    // Search for a value; returns its position or -1
    public int search(int value) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == value) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    // Update the value at a given position (0-based)
    public boolean update(int position, int newValue) {
        if (position < 0 || position >= size) {
            return false;
        }
        Node temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        temp.data = newValue;
        return true;
    }

    // Reverse the list
    public void reverse() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.print("HEAD -> ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class SinglyLinkedList {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        SinglyList list = new SinglyList();
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");
            System.out.println();

            switch (choice) {
                case 1:
                    list.insertAtBeginning(readInt("Enter value: "));
                    System.out.println("Inserted at beginning.");
                    break;
                case 2:
                    list.insertAtEnd(readInt("Enter value: "));
                    System.out.println("Inserted at end.");
                    break;
                case 3: {
                    int pos = readInt("Enter position (0-" + list.size() + "): ");
                    int val = readInt("Enter value: ");
                    if (list.insertAtPosition(pos, val)) {
                        System.out.println("Inserted at position " + pos + ".");
                    } else {
                        System.out.println("Invalid position.");
                    }
                    break;
                }
                case 4:
                    System.out.println(list.deleteFirst() ? "First node deleted." : "List is empty.");
                    break;
                case 5:
                    System.out.println(list.deleteLast() ? "Last node deleted." : "List is empty.");
                    break;
                case 6: {
                    int val = readInt("Enter value to delete: ");
                    System.out.println(list.deleteByValue(val) ? "Value deleted." : "Value not found.");
                    break;
                }
                case 7: {
                    int pos = readInt("Enter position to delete: ");
                    System.out.println(list.deleteAtPosition(pos) ? "Node deleted." : "Invalid position.");
                    break;
                }
                case 8: {
                    int val = readInt("Enter value to search: ");
                    int idx = list.search(val);
                    if (idx == -1) {
                        System.out.println("Value not found.");
                    } else {
                        System.out.println("Value found at position " + idx + ".");
                    }
                    break;
                }
                case 9: {
                    int pos = readInt("Enter position to update: ");
                    int val = readInt("Enter new value: ");
                    System.out.println(list.update(pos, val) ? "Value updated." : "Invalid position.");
                    break;
                }
                case 10:
                    list.reverse();
                    System.out.println("List reversed.");
                    break;
                case 11:
                    list.display();
                    break;
                case 12:
                    System.out.println("Size of list: " + list.size());
                    break;
                case 13:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1-13.");
            }
            System.out.println();
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("===== SINGLY LINKED LIST MENU =====");
        System.out.println(" 1. Insert at beginning");
        System.out.println(" 2. Insert at end");
        System.out.println(" 3. Insert at position");
        System.out.println(" 4. Delete first");
        System.out.println(" 5. Delete last");
        System.out.println(" 6. Delete by value");
        System.out.println(" 7. Delete at position");
        System.out.println(" 8. Search value");
        System.out.println(" 9. Update value at position");
        System.out.println("10. Reverse list");
        System.out.println("11. Display");
        System.out.println("12. Size");
        System.out.println("13. Exit");
        System.out.println("===================================");
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
}
