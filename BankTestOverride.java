import java.util.ArrayList;

public class BankTestOverride {
    public static void main(String[] args) {
        // Tworzymy listę na obiekty typu bazowego (BankAccountOverride)
        ArrayList<BankAccountOverride> myAccounts = new ArrayList<>();

        // Dodajemy zwykłe konto
        myAccounts.add(new BankAccountOverride("Jan Kowalski", 1000.0));
        
        // Dodajemy konto kredytowe (Java na to pozwala, bo to też rodzaj konta)
        myAccounts.add(new CredditOverride("Firma X", 500.0, 2000.0));

        System.out.println("--- PRÓBA WYPŁATY PO 1000 ZŁ Z KAŻDÉGO KONTA ---");

        // Pętla przechodzi po wszystkich kontach w liście
        for (BankAccountOverride account : myAccounts) {
            // Magia! Dla Jana Kowalskiego odpali się zwykły withdraw(), 
            // a dla Firmy X odpali się nadpisany @Override withdraw() z kredytem.
            account.withdraw(1000); 
        }
    }
}