package plan_nauki.tydzien_01.code_rozwiazania;

import java.util.Scanner;

public class z1_4_rozwiazane {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbe: ");
        int liczba = scanner.nextInt();

        // Sposob 1: boolean + if/else
        boolean czyParzysta = (liczba % 2 == 0);
        if (czyParzysta) {
            System.out.println("Parzysta");
        } else {
            System.out.println("Nieparzysta");
        }

        // Sposob 2: operator trojargumentowy (krotszy)
        System.out.println(liczba % 2 == 0 ? "Parzysta" : "Nieparzysta");

        // Sposob 3: przez przesuniecie bitowe (ciekawostka, nie wymagana)
        System.out.println((liczba & 1) == 0 ? "Parzysta (bitowo)" : "Nieparzysta (bitowo)");

        scanner.close();
    }
}
