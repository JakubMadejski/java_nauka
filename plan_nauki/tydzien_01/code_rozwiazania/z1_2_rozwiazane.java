package plan_nauki.tydzien_01.code_rozwiazania;

import java.util.Scanner;

public class z1_2_rozwiazane {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj pierwsza liczbe: ");
        int a = scanner.nextInt();
        System.out.print("Podaj druga liczbe: ");
        int b = scanner.nextInt();

        System.out.println("Suma: " + (a + b));
        System.out.println("Roznica: " + (a - b));
        System.out.println("Iloczyn: " + (a * b));

        // Sposob 1: rzutowanie licznika przed dzieleniem
        System.out.println("Iloraz: " + (double) a / b);

        // Sposob 2: rzutowanie mianownika
        System.out.println("Iloraz: " + (a / (double) b));

        // Sposob 3: deklaracja jako double od razu (wymaga wczytania inaczej)
        // double da = a; -> da / b tez daje double

        scanner.close();
    }
}
