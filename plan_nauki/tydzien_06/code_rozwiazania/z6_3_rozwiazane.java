package plan_nauki.tydzien_06.code_rozwiazania;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class z6_3_rozwiazane {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj zdanie: ");
        String zdanie = scanner.nextLine();

        // Sposob 1: HashMap + getOrDefault
        HashMap<String, Integer> licznik = new HashMap<>();
        for (String slowo : zdanie.split(" ")) {
            licznik.put(slowo, licznik.getOrDefault(slowo, 0) + 1);
        }

        System.out.println("Wystapienia slow:");
        for (Map.Entry<String, Integer> e : licznik.entrySet()) {
            System.out.println("  '" + e.getKey() + "': " + e.getValue());
        }

        scanner.close();
    }
}
