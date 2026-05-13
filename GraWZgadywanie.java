import java.util.Scanner;
import java.util.Random;

public class GraWZgadywanie {
    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);
        Random losowanie = new Random();

        int wylosowanaLiczba = losowanie.nextInt(100) + 1; // Losuje od 1 do 100
        int proba = 0;

        System.out.println("Zgadnij liczbę od 1 do 100!");

        while (proba != wylosowanaLiczba) {
            System.out.print("Podaj swoją liczbę: ");
            proba = skaner.nextInt(); // Pobiera liczbę od użytkownika

            if (proba < wylosowanaLiczba) {
                System.out.println("Za mało!");
            } else if (proba > wylosowanaLiczba) {
                System.out.println("Za dużo!");
            } else {
                System.out.println("Brawo! Zgadłeś!");
            }
        }
        skaner.close();
    }
}