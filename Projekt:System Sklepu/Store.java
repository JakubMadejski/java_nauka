package Projekt

import java.util.HashMap;

:System Sklepu;

public class Store {
    private String name;
    private HashMap<Integer, Product> inventory = new HashMap<>();

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public void addProduct(Product product) {
        inventory.put(product.id, product);
    }

    public void sellProduct(int productId) { 
        if (inventory.containsKey(productId)) {
            Product product = inventory.get(productId);
            System.out.println("Selling: " + product.getDetails() + ", Final Price: " + product.calculateFinalPrice());
            double price = product.calculateFinalPrice();
            totalRevenue += price;
            inventory.remove(productId);

        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public void displayProducts() {
        System.out.println("Products in " + name + ":");
        for (Product product : inventory.values()) {
            System.out.println(product.getDetails() + ", Final Price: " + product.calculateFinalPrice());
        }
    }
}
