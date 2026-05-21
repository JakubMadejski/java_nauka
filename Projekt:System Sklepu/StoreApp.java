package Projekt:System Sklepu;

public class StoreApp {
    public static void main(String[] args) {
        Store store = new Store();

        store.addProduct(new Electronics(1, "Laptop", 1500.00, 24));
        store.addProduct(new Food(2, "Bread", 2.50, "2024-12-31"));

        try {
            store.sellProduct(1); // Selling the laptop
            store.sellProduct(2); // Selling the bread
            store.sellProduct(3); // Attempting to sell a non-existent product
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        store.displayProducts();

        System.out.println("Total Revenue: " + Store.getTotalRevenue());
    }  
}
