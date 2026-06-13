package kod;
// Słowo 'extends' sprawia, że ta klasa ma wszystko to, co BankAccount
public class BankAccountSavings extends BankAccount {
    
    private double interestRate; // Dodatkowy atrybut: stopa procentowa

    // Konstruktor
    public BankAccountSavings(String owner, double initialBalance, double interestRate) {
        // 'super' wywołuje konstruktor klasy nadrzędnej (BankAccount)
        // To musi być pierwsza instrukcja w konstruktorze!
        super(owner, initialBalance); 
        this.interestRate = interestRate;
    }

    // Nowa metoda dostępna tylko dla konta oszczędnościowego
    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest); // Używamy metody wpłaty z klasy nadrzędnej
        System.out.println("Naliczono odsetki: " + interest + " zł.");
    }

    // --- TESTOWANIE ---
    public static void main(String[] args) {
        // Tworzymy konto oszczędnościowe
        BankAccountSavings mySavings = new BankAccountSavings("Kuba", 1000.0, 0.05);

        // Korzystamy z metod zwykłego konta (mimo że ich tu nie pisaliśmy!)
        mySavings.deposit(500);
        
        // Korzystamy z nowej metody
        mySavings.applyInterest();

        System.out.println("Saldo końcowe: " + mySavings.getBalance() + " zł.");
    }
}