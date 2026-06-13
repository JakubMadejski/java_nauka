package kod;
import java.util.Scanner;
import java.util.ArrayList;

public class EvenNumbersTask {
    public static void main(String[] args) {
        // 1. Inicjalizacja narzędzi
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Podaj 5 liczb całkowitych:");

        // 2. Pobieranie danych (pętla for jak w C)
        for (int i = 0; i < 5; i++) {
            System.out.print("Liczba " + (i + 1) + ": ");
            int input = scanner.nextInt();
            numbers.add(input); // Dodajemy do listy (jak .append() w Pythonie)
        }

        System.out.println("\nLiczby parzyste z Twojej listy:");

        // 3. Sprawdzanie parzystości (pętla for-each jak w Pythonie)
        for (Integer num : numbers) {
            if (num % 2 == 0) { // Operator modulo - identyczny jak w C/Python
                System.out.println(num);
            }
        }

        // 4. Sprzątanie
        scanner.close();
    }
}