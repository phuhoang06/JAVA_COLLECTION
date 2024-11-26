package baitap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add product");
            System.out.println("2. Update product");
            System.out.println("3. Delete product");
            System.out.println("4. Display products");
            System.out.println("5. Search product by name");
            System.out.println("6. Sort products by price");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> manager.addProduct();
                case 2 -> manager.updateProduct();
                case 3 -> manager.deleteProduct();
                case 4 -> manager.displayProducts();
                case 5 -> manager.searchProductByName();
                case 6 -> {
                    System.out.print("Sort ascending (true/false): ");
                    boolean ascending = scanner.nextBoolean();
                    manager.sortProductsByPrice(ascending);
                }
                case 0 -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}

