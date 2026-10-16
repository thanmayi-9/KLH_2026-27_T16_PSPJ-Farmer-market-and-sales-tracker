import java.util.Scanner;
import java.util.ArrayList;

// Class 1
class Product {
    String name;
    double price;
    int quantity;
    String category;

    // Constructor
    Product(String name, double price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    // Calculate total sales
    double calculateSales() {
        return price * quantity;
    }

    // Method overloading
    void display() {
        System.out.println("Product Name: " + name);
        System.out.println("Price per kg: Rs. " + price);
        System.out.println("Quantity Sold: " + quantity);
        System.out.println("Total Sales: Rs. " + calculateSales());
    }

    void display(boolean showCategory) {
        display();

        if (showCategory) {
            System.out.println("Category: " + category);
        }
    }
}

// Class 2
public class FarmersMarket {
    Scanner sc = new Scanner(System.in);

    ArrayList<Product> products = new ArrayList<Product>();

    String[] categories = {"Vegetables", "Fruits", "Grains"};

    // Add product
    void addProduct() {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        System.out.print("Enter price per kg: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity sold: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        if (name.isEmpty() || price <= 0 || quantity < 0) {
            System.out.println("Invalid product details!");
            return;
        }

        boolean valid = false;

        for (int i = 0; i < categories.length; i++) {
            if (category.equalsIgnoreCase(categories[i])) {
                category = categories[i];
                valid = true;
            }
        }

        if (valid) {
            Product p = new Product(name, price, quantity, category);
            products.add(p);
            System.out.println("Product added successfully!");
        } else {
            System.out.println("Invalid category!");
        }
    }

    // Display products
    void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available!");
            return;
        }

        for (int i = 0; i < products.size(); i++) {
            System.out.println("\nProduct " + (i + 1));
            products.get(i).display(true);
        }
    }

    // Search product
    void searchProduct() {
        sc.nextLine();

        System.out.print("Enter product name to search: ");
        String search = sc.nextLine();

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);

            if (p.name.equalsIgnoreCase(search)) {
                System.out.println("Product found!");
                p.display(true);
                return;
            }
        }

        System.out.println("Product not found!");
    }

    // Calculate total sales
    void totalSales() {
        double total = 0;

        for (int i = 0; i < products.size(); i++) {
            total = total + products.get(i).calculateSales();
        }

        System.out.println("Total Market Sales: Rs. " + total);
    }

    // Main menu
    void menu() {
        int choice;

        do {
            System.out.println("\n===== FARMERS MARKET TRACKER =====");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Search Product");
            System.out.println("4. Calculate Total Sales");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    addProduct();
                    break;

                case 2:
                    displayProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    totalSales();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }

    public static void main(String[] args) {
        FarmersMarket fm = new FarmersMarket();
        fm.menu();
    }
}
