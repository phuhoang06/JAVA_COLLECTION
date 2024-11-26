package baitap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {
    private ArrayList<Product> productList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addProduct() {
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Product product = new Product(id, name, price);
        productList.add(product);
        System.out.println("Product added successfully!");
    }

    public void updateProduct() {
        System.out.print("Enter product ID to update: ");
        String id = scanner.nextLine();
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                System.out.print("Enter new name: ");
                product.setName(scanner.nextLine());
                System.out.print("Enter new price: ");
                product.setPrice(scanner.nextDouble());
                scanner.nextLine(); // Consume newline
                System.out.println("Product updated successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        String id = scanner.nextLine();
        productList.removeIf(product -> product.getId().equals(id));
        System.out.println("Product deleted successfully!");
    }

    public void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products available!");
        } else {
            productList.forEach(System.out::println);
        }
    }

    public void searchProductByName() {
        System.out.print("Enter product name to search: ");
        String name = scanner.nextLine();
        productList.stream()
                .filter(product -> product.getName().contains(name))
                .forEach(System.out::println);
    }

    public void sortProductsByPrice(boolean ascending) {
        productList.sort(ascending
                ? Comparator.comparingDouble(Product::getPrice)
                : Comparator.comparingDouble(Product::getPrice).reversed());
        System.out.println("Products sorted successfully!");
    }
}

