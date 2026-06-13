package plan_nauki.tydzien_01.code_rozwiazania;

import java.util.Scanner;

public class z1_3_rozwiazane {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj temperature w Celsjuszach: ");
        double celsius = scanner.nextDouble();

        // Sposob 1: 9.0/5 wymusza dzielenie double
        double fahrenheit = celsius * (9.0 / 5) + 32;
        System.out.printf("%.1f C = %.1f F%n", celsius, fahrenheit);

        // Sposob 2: bezposrednio 1.8
        double fahrenheit2 = celsius * 1.8 + 32;
        System.out.printf("Sposob 2: %.1f F%n", fahrenheit2);

        scanner.close();
    }
}
