package Projekt:System Sklepu;

public class Product implements Sellable {
    protected int id;
    protected String name;
    protected double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    @Override
    public double calculateFinalPrice() {
        return price; // Dla zwykłego produktu, cena końcowa to po prostu
    }

    @Override
    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Price: " + price;
    }
}