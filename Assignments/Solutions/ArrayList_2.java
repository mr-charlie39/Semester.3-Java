import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

interface Shope_imp {
    void addProduct(Object product);
    void viewCart();
    void updateProduct();
    void removeProduct();
    void searchProduct();
    void displayTotalItems();
    void emptyCart();
}

abstract class ShoppingCart implements Shope_imp {
    protected ArrayList<Object> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addProduct(Object product) {
        items.add(product);
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Fixed class spelling to match standard conventions
class ShoppingCartImpl extends ShoppingCart {

    private Scanner s = new Scanner(System.in);

    // Helper method to print text beautifully on one line
    private void printSlowly(String text) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i)); // Fixed: print instead of println
            try {
                Thread.sleep(30); // Speed up slightly for better UX
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void viewCart() {
        printSlowly("--> Cart Contents:\n");
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        for (Object item : items) {
            if (item instanceof Product) {
                Product product = (Product) item;
                System.out.println("Product Name: " + product.getName() + ", Price: " + product.getPrice());
            }
        }
    }

    @Override
    public void updateProduct() {
        printSlowly("--> Updating Product:\n");
        System.out.println("Enter the name of the product you want to update: ");
        String productName = s.next();
        System.out.println("Enter the price of the product you want to update: ");
        while (!s.hasNextDouble()) {
            System.out.println("Invalid input. Enter a valid price:");
            s.next();
        }
        double productPrice = s.nextDouble();

        boolean found = false;
        for (int i = 0; i < items.size(); i++) {
            Object item = items.get(i);
            if (item instanceof Product) {
                Product product = (Product) item;
                if (product.getName().equalsIgnoreCase(productName) && product.getPrice() == productPrice) {
                    System.out.println("Enter the new name of the product: ");
                    String newName = s.next();
                    System.out.println("Enter the new price of the product: ");
                    double newPrice = s.nextDouble();

                    items.set(i, new Product(newName, newPrice)); // Cleaner update replacement
                    System.out.println("Product updated successfully.");
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Product not found matching those details.");
        }
    }

    @Override
    public void removeProduct() {
        printSlowly("--> Removing Product:\n");
        System.out.println("Enter the name of the product you want to remove: ");
        String productName = s.next();
        
        boolean found = false;
        Iterator<Object> iterator = items.iterator(); 
        while (iterator.hasNext()) {
            Object item = iterator.next();
            if (item instanceof Product) {
                if (((Product) item).getName().equalsIgnoreCase(productName)) {
                    iterator.remove();
                    System.out.println("Product removed successfully.");
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Product not found.");
        }
    }

    @Override
    public void searchProduct() {
        System.out.println("Enter the name of the product you want to search: ");
        String productName = s.next();

        printSlowly("--> Searching Product:\n");
        boolean found = false;
        for (Object item : items) {
            if (item instanceof Product) {
                if (((Product) item).getName().equalsIgnoreCase(productName)) {
                    System.out.println("Product found: " + ((Product) item).getName() + ", Price: " + ((Product) item).getPrice());
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Product not found.");
        }
    }

    @Override
    public void displayTotalItems() {
        printSlowly("--> Displaying Total Items:\n");
        // Dynamically referencing items.size() eliminates the need for a separate totalItems variable counter
        System.out.println("Total items in the cart: " + items.size());
    }

    @Override
    public void emptyCart() {
        printSlowly("--> Emptying Cart:\n");
        items.clear();
        System.out.println("Cart emptied successfully.");
    }
}

 class Arraylist_2 {

    class Menu {
        void DisplayMenu() {
            System.out.println("\n========================== Welcome to the Shopping Cart ==========================");
            System.out.println("1. Add Product");
            System.out.println("2. View Cart");
            System.out.println("3. Update Product");
            System.out.println("4. Remove Product");
            System.out.println("5. Search Product");
            System.out.println("6. Display Total Items");
            System.out.println("7. Empty Cart");
            System.out.println("8. Exit");
            System.out.println("==================================================================================");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Arraylist_2 obj = new Arraylist_2();
        Arraylist_2.Menu menu = obj.new Menu();
        ShoppingCart cart = new ShoppingCartImpl(); // Will compile perfectly now

        boolean condition = true;

        while (condition) {
            menu.DisplayMenu();
            System.out.print("Enter your choice: ");
            if (!s.hasNextInt()) {
                System.out.println("Please enter a valid menu number option.");
                s.next();
                continue;
            }
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the quantity of products you want to add: ");
                    int quantity = s.nextInt();
                    for (int i = 0; i < quantity; i++) {
                        System.out.print("Enter the name of product #" + (i + 1) + ": ");
                        String name = s.next();
                        System.out.print("Enter the price of product #" + (i + 1) + ": ");
                        double price = s.nextDouble();
                        Product product = new Product(name, price);
                        cart.addProduct(product);
                    }
                    break;
                case 2:
                    cart.viewCart();
                    break;
                case 3:
                    cart.updateProduct();
                    break;
                case 4:
                    cart.removeProduct();
                    break;
                case 5:
                    cart.searchProduct();
                    break;
                case 6:
                    cart.displayTotalItems();
                    break;
                case 7:
                    cart.emptyCart();
                    break;
                case 8:
                    condition = false;
                    System.out.println("Exiting... Thank you for shopping!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        s.close();
    }
}