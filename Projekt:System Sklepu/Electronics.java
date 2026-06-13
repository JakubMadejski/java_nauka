package Projekt:System Sklepu;

public class Electronics extends Product {
    private int warrantyMonths;

    public Electronics(int id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateFinalPrice() {
        return price * 1.2; // Dla elektroniki dodajemy 20% do ceny
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Warranty: " + warrantyMonths + " months";
    }
    
}
