public class CredditOverride extends BankAccountOverride {
    private double creditLimit;

    // Konstruktor dziecka musi wywołać konstruktor rodzica (super)
    public CredditOverride(String owner, double initialBalance, double creditLimit) {
        super(owner, initialBalance);
        this.creditLimit = creditLimit;
    }

    // @Override to sygnał dla Javy: "Zastępuję metodę rodzica swoją własną wersją"
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Kwota wypłaty musi być dodatnia!");
        } else if (balance - amount >= -creditLimit) { 
            // Tu używamy 'balance' z klasy rodzica (możemy, bo jest protected)
            balance -= amount; 
            System.out.println(owner + ": Wypłacono " + amount + " zł (Kredyt). Aktualny stan: " + balance + " zł.");
        } else {
            System.out.println(owner + ": Odmowa! Przekroczono limit kredytowy.");
        }
    }
}