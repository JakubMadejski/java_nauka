import java.util.ArrayList; // Musimy zaimportować listę
import java.util.Collections; // Narzędzia do sortowania itp.

public class ListsAndLoops {
    public static void main(String[] args) {
        // 1. Tworzymy dynamiczną listę (odpowiednik list w Pythonie)
        // Uwaga: używamy Integer zamiast int (to tzw. klasa opakowująca)
        ArrayList<Integer> numbers = new ArrayList<>();

        // 2. Dodawanie elementów
        numbers.add(42);
        numbers.add(10);
        numbers.add(7);
        numbers.add(100);

        // 3. Pętle - mamy dwa główne rodzaje
        
        System.out.println("Pętla FOR (jak w C):");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("Index " + i + ": " + numbers.get(i));
        }

        System.out.println("\nPętla FOR-EACH (jak w Pythonie):");
        for (Integer num : numbers) {
            System.out.println("Wartość: " + num);
        }

        // 4. Prosta logika i manipulacja
        if (numbers.contains(42)) {
            System.out.println("\nZnalazłem odpowiedź na wszystko (42)!");
        }

        Collections.sort(numbers); // Sortowanie
        System.out.println("Posortowane: " + numbers);
    }
}