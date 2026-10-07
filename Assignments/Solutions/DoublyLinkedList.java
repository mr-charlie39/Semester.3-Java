import java.util.*;

class DNode {
    int data;
    DNode prev;
    DNode next;

    DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyList {
    private DNode head;
    private DNode tail;
    private int size;

    public DoublyList() {
        head = null;
        tail = null;
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
        DNode newNode = new DNode(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Insert at the end
    public void insertAtEnd(int value) {
        DNode newNode = new DNode(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
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
        if (position == size) {
            insertAtEnd(value);
            return true;
        }
        DNode temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        // temp is the node currently at 'position'; insert before it
        DNode newNode = new DNode(value);
        newNode.prev = temp.prev;
        newNode.next = temp;
        temp.prev.next = newNode;
        temp.prev = newNode;
        size++;
        return true;
    }

    // Delete the first node
    public boolean deleteFirst() {
        if (head == null) {
            return false;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return true;
    }

    // Delete the last node
    public boolean deleteLast() {
        if (tail == null) {
            return false;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return true;
    }

    // Delete the first node holding the given value
    public boolean deleteByValue(int value) {
        DNode temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }
        if (temp == null) {
            return false;
        }
        removeNode(temp);
        return true;
    }

    // Delete the node at a given position (0-based)
    public boolean deleteAtPosition(int position) {
        if (position < 0 || position >= size) {
            return false;
        }
        DNode temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        removeNode(temp);
        return true;
    }

    // Unlink a given node from the list
    private void removeNode(DNode node) {
        if (node == head) {
            deleteFirst();
        } else if (node == tail) {
            deleteLast();
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    // Search for a value; returns its position or -1
    public int search(int value) {
        DNode temp = head;
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
        DNode temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        temp.data = newValue;
        return true;
    }

    // Reverse the list by swapping prev/next of every node
    public void reverse() {
        DNode current = head;
        DNode temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        temp = head;
        head = tail;
        tail = temp;
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        DNode temp = head;
        System.out.print("NULL <-> ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        DNode temp = tail;
        System.out.print("NULL <-> ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }
}

public class DoublyLinkedList {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        DoublyList list = new DoublyList();
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
                    list.displayForward();
                    break;
                case 12:
                    list.displayBackward();
                    break;
                case 13:
                    System.out.println("Size of list: " + list.size());
                    break;
                case 14:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1-14.");
            }
            System.out.println();
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("===== DOUBLY LINKED LIST MENU =====");
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
        System.out.println("11. Display forward");
        System.out.println("12. Display backward");
        System.out.println("13. Size");
        System.out.println("14. Exit");
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
