public class BankAccount {
    // 1. Pole prywatne - nikt poza tą klasą nie może tu "zajrzeć" ani nic zmienić
    private double balance;
    private String owner;

    // 2. Konstruktor - ustawiamy startowe dane
    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    // 3. Metoda wpłaty
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(owner + ": Wpłacono " + amount + " zł. Aktualny stan: " + balance + " zł.");
        } else {
            System.out.println("Błąd: Kwota wpłaty musi być dodatnia!");
        }
    }

    // 4. Metoda wypłaty z logiką sprawdzającą (serce hermetyzacji)
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Błąd: Kwota wypłaty musi być dodatnia!");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println(owner + ": Wypłacono " + amount + " zł. Pozostało: " + balance + " zł.");
        } else {
            System.out.println(owner + ": Odmowa! Brak środków na koncie. Próbowano wypłacić: " + amount + " zł.");
        }
    }

    // 5. Getter - bezpieczny sposób na sprawdzenie salda (tylko do odczytu)
    public double getBalance() {
        return balance;
    }

    // --- TESTOWANIE ---
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("Kuba", 1000.0);

        myAccount.deposit(500);    // Powinno zadziałać
        myAccount.withdraw(2000);  // Powinno wypisać błąd (brak środków)
        myAccount.withdraw(300);   // Powinno zadziałać

        System.out.println("---");
        System.out.println("Finalne saldo uzytkownika " + myAccount.owner + ": " + myAccount.getBalance() + " zł.");
    }
}