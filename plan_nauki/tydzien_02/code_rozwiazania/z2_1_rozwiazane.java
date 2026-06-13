package plan_nauki.tydzien_02.code_rozwiazania;

import java.util.Scanner;

public class z2_1_rozwiazane {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbe: ");
        int n = scanner.nextInt();

        // ujemna/zero/dodatnia
        if (n == 0) {
            System.out.println("Zero");
        } else if (n > 0) {
            System.out.println("Dodatnia");
        } else {
            System.out.println("Ujemna");
        }

        // parzysta/nieparzysta
        System.out.println(n % 2 == 0 ? "Parzysta" : "Nieparzysta");

        // wielokrotnosc 3 - sposob 1: % 3
        System.out.println(n % 3 == 0 ? "Wielokrotnosc 3" : "Nie jest wielokrotnoscia 3");

        scanner.close();
    }
}
