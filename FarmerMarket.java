import java.util.Scanner;

public class FarmerMarket {

    static String[] product = new String[5];
    static double[] price = new double[5];
    static int[] quantity = new int[5];
    static double[] sales = new double[5];

    static Scanner sc = new Scanner(System.in);

    // Method 1: Add Product Details
    static void addProduct() {

        for (int i = 0; i < 5; i++) {

            System.out.println("\nEnter details for Product " + (i + 1));

            System.out.print("Enter product name: ");
            product[i] = sc.nextLine();

            System.out.print("Enter price per kg: ");
            price[i] = sc.nextDouble();

            System.out.print("Enter quantity sold: ");
            quantity[i] = sc.nextInt();

            sales[i] = price[i] * quantity[i];

            sc.nextLine();
        }

        System.out.println("\nAll products added successfully!");
    }

    // Method 2: Display Products
    static void displayProducts() {

        System.out.println("\n--- FARMERS MARKET SALES ---");

        for (int i = 0; i < 5; i++) {

            System.out.println("\nProduct: " + product[i]);
            System.out.println("Price: Rs. " + price[i]);
            System.out.println("Quantity: " + quantity[i] + " kg");
            System.out.println("Sales: Rs. " + sales[i]);
        }
    }

    // Method 3: Find Highest Sales
    static void highestSales() {

        int highest = 0;

        for (int i = 1; i < 5; i++) {

            if (sales[i] > sales[highest]) {
                highest = i;
            }
        }

        System.out.println("\nHighest Sales Product: " + product[highest]);
        System.out.println("Sales: Rs. " + sales[highest]);
    }

    // Method 4: Find Lowest Price
    static void lowestPrice() {

        int lowest = 0;

        for (int i = 1; i < 5; i++) {

            if (price[i] < price[lowest]) {
                lowest = i;
            }
        }

        System.out.println("\nLowest Price Product: " + product[lowest]);
        System.out.println("Price: Rs. " + price[lowest]);
    }

    // Method 5: Calculate Total Sales
    static void totalSales() {

        double total = 0;

        for (int i = 0; i < 5; i++) {
            total = total + sales[i];
        }

        System.out.println("\nTotal Market Sales: Rs. " + total);
    }

    // Method 6: Calculate Average Sales
    static void averageSales() {

        double total = 0;

        for (int i = 0; i < 5; i++) {
            total = total + sales[i];
        }

        double average = total / 5;

        System.out.println("\nAverage Sales: Rs. " + average);
    }

    // Method 7: Search Product
    static void searchProduct() {

        System.out.print("\nEnter product name to search: ");
        String search = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < 5; i++) {

            if (product[i].equalsIgnoreCase(search)) {

                System.out.println("\nProduct Found!");
                System.out.println("Product: " + product[i]);
                System.out.println("Price: Rs. " + price[i]);
                System.out.println("Quantity: " + quantity[i] + " kg");
                System.out.println("Sales: Rs. " + sales[i]);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nProduct Not Found!");
        }
    }

    // Main Method
    public static void main(String[] args) {

        int choice;

        addProduct();

        do {

            System.out.println("\n========== FARMERS MARKET ==========");
            System.out.println("1. Display Products");
            System.out.println("2. Highest Sales");
            System.out.println("3. Lowest Price");
            System.out.println("4. Total Sales");
            System.out.println("5. Average Sales");
            System.out.println("6. Search Product");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {

                case 1:
                    displayProducts();
                    break;

                case 2:
                    highestSales();
                    break;

                case 3:
                    lowestPrice();
                    break;

                case 4:
                    totalSales();
                    break;

                case 5:
                    averageSales();
                    break;

                case 6:
                    searchProduct();
                    break;

                case 7:
                    System.out.println("\nThank you for using Farmers Market Tracker!");
                    break;

                default:
                    System.out.println("\nInvalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}