import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface Shope_imp {
    void addProduct(Product product);
    void viewCart();
    void updateProduct();
    void removeProduct();
    void searchProduct();
    void displayTotalItems();
    void emptyCart();
}

abstract class ShoppingCart implements Shope_imp {
    protected HashMap<String, Product> items;

    public ShoppingCart() {
        items = new HashMap<>(); // This will now correctly reference java.util.HashMap
    }

    public void addProduct(Product product) {
        items.put(product.getName().toLowerCase(), product);
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

class ShoppingCartImpl extends ShoppingCart {

    private Scanner s = new Scanner(System.in);

    private void printSlowly(String text) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
                Thread.sleep(20); 
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
        for (Product product : items.values()) {
            System.out.println("Product Name: " + product.getName() + ", Price: " + product.getPrice());
        }
    }

    @Override
    public void updateProduct() {
        printSlowly("--> Updating Product:\n");
        System.out.println("Enter the name of the product you want to update: ");
        String productName = s.next();

        if (items.containsKey(productName.toLowerCase())) {
            System.out.println("Enter the new name of the product: ");
            String newName = s.next();
            System.out.println("Enter the new price of the product: ");
            while (!s.hasNextDouble()) {
                System.out.println("Invalid input. Enter a valid price:");
                s.next();
            }
            double newPrice = s.nextDouble();

            items.remove(productName.toLowerCase());
            
            Product updatedProduct = new Product(newName, newPrice);
            items.put(newName.toLowerCase(), updatedProduct);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found matching that name.");
        }
    }

    @Override
    public void removeProduct() {
        printSlowly("--> Removing Product:\n");
        System.out.println("Enter the name of the product you want to remove: ");
        String productName = s.next();
        
        if (items.remove(productName.toLowerCase()) != null) {
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    @Override
    public void searchProduct() {
        System.out.println("Enter the name of the product you want to search: ");
        String productName = s.next();

        printSlowly("--> Searching Product:\n");
        Product product = items.get(productName.toLowerCase());
        
        if (product != null) {
            System.out.println("Product found: " + product.getName() + ", Price: " + product.getPrice());
        } else {
            System.out.println("Product not found.");
        }
    }

    @Override
    public void displayTotalItems() {
        printSlowly("--> Displaying Total Items:\n");
        System.out.println("Total unique items in the cart: " + items.size());
    }

    @Override
    public void emptyCart() {
        printSlowly("--> Emptying Cart:\n");
        items.clear();
        System.out.println("Cart emptied successfully.");
    }
}

// FIXED: Renamed class from 'HashMap' to 'ShoppingCartApp' to avoid conflicts
class ShoppingCartApp {

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
        ShoppingCartApp obj = new ShoppingCartApp(); // Updated variable type instantiation
        ShoppingCartApp.Menu menu = obj.new Menu();
        ShoppingCart cart = new ShoppingCartImpl(); 

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