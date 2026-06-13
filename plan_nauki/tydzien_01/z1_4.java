package plan_nauki.tydzien_01;
import java.util.Scanner;
// Z1.4 - Reszta z dzielenia
// Wczytaj liczbe od uzytkownika.
// Wypisz czy jest parzysta czy nieparzysta (operator %)

public class z1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe sprawdze czy jest parzysta czy nie parzysta: ");
        int liczb = scanner.nextInt();
        boolean czyParzysta = (liczb % 2 == 0);
        System.out.println("Czy liczba jest parzysta: " + (czyParzysta ? "Parzysta" : "Nieparzysta"));
        scanner.close();



    }
}
