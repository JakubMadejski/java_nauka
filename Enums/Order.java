package Enums;

public class Order {
    private int id;
    private OrderStatus status; // Zmienna naszego nowego typu!

    public Order(int id) {
        this.id = id;
        this.status = OrderStatus.NOWE; // Każde zamówienie na starcie jest NOWE
    }

    public void pay() {
        this.status = OrderStatus.OPLACONE;
        System.out.println("Zamówienie #" + id + " zostało opłacone.");
    }

    // Metoda sprawdzająca, co się dzieje z zamówieniem
    public void printShippingInfo() {
        // Switch w Javie idealnie dogaduje się z Enumami
        switch (status) {
            case NOWE:
                System.out.println("Czekamy na wpłatę.");
                break;
            case OPLACONE:
            case W_PRZYGOTOWANIU:
                System.out.println("Pakujemy Twoją paczkę!");
                break;
            case WYSLANE:
                System.out.println("Kurier jest w drodze.");
                break;
            case DOSTARCZONE:
                System.out.println("Smacznego / Miłego używania!");
                break;
        }
    }

    // --- TESTOWANIE ---
    public static void main(String[] args) {
        Order myOrder = new Order(101);
        
        myOrder.printShippingInfo(); // Wypisze: Czekamy na wpłatę.
        
        myOrder.pay();
        myOrder.printShippingInfo(); // Wypisze: Pakujemy Twoją paczkę!
    }
}