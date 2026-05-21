package Projekt:System Sklepu;

public class Food extends Product {
    private String expirationDate;

    public Food(int id, String name, double price, String expirationDate) {
        super(id, name, price);
        this.expirationDate = expirationDate;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Expiration Date: " + expirationDate;
    }
    
}
