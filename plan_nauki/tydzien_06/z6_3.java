package plan_nauki.tydzien_06;

import java.util.HashMap;
import java.util.Scanner;

// Z6.3 - Liczenie slow w zdaniu
// Wczytaj zdanie, policz wystapienia kazdego slowa: HashMap<String, Integer>
// zdanie.split(" ") rozbija na slowa

public class z6_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj zdanie: ");
        String wczyt = scanner.nextLine();

        // KROK 1: rozbij zdanie na slowa po spacjach
        String[] slowa = wczyt.split(" ");

        // mapa: slowo -> ile razy wystapilo
        HashMap<String, Integer> licznik = new HashMap<>();

        // KROK 2: dla kazdego slowa zwieksz jego licznik o 1
        for (int i = 0; i < slowa.length; i++) {
            String slowo = slowa[i];
            if (licznik.containsKey(slowo)) {
                // slowo juz bylo - wez jego licznik i dodaj 1
                int ile = licznik.get(slowo);
                licznik.put(slowo, ile + 1);
            } else {
                // slowa jeszcze nie bylo - ustaw na 1
                licznik.put(slowo, 1);
            }
        }

        // KROK 3: wypisz wszystkie pary slowo -> licznik
        // keySet() daje wszystkie slowa (klucze), a licznik.get(slowo) daje ile razy
        for (String slowo : licznik.keySet()) {
            System.out.println(slowo + " -> " + licznik.get(slowo));
        }

        scanner.close();
    }
}
