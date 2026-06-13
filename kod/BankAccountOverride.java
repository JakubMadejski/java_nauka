package kod;
public class BankAccountOverride {
    // protected pozwala na dostęp w tej klasie oraz w klasach dziedziczących (dzieciach)
    protected String owner;
    protected double balance; 

    public BankAccountOverride(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(owner + ": Wpłacono " + amount + " zł. Aktualny stan: " + balance + " zł.");
        }
    }

    // Tę metodę będziemy "nadpisywać" (Override) w klasie dziecka
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Błąd: Kwota wypłaty musi być dodatnia!");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println(owner + ": Wypłacono " + amount + " zł. Pozostało: " + balance + " zł.");
        } else {
            System.out.println(owner + ": Odmowa! Brak środków. Próbowano wypłacić: " + amount + " zł.");
        }
    }

    public double getBalance() {
        return balance;
    }
}