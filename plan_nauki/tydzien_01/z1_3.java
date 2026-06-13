package plan_nauki.tydzien_01;
import java.util.Scanner;
// Z1.3 - Przelicznik temperatury
// Wczytaj temperature w Celsjuszach, przelicz na Fahrenheity: F = C * 9/5 + 32
// Wypisz wynik z 1 miejscem po przecinku (printf)

public class z1_3 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj celciusze: ");
            int celc = scanner.nextInt();
            double farten = celc * (9 / 5) + 32;
            System.out.printf(farten);
            scanner.close();
    }
}
