package plan_nauki.tydzien_06;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

// Z6.4 - Usuwanie duplikatow
// Wczytaj 10 liczb do ArrayList, wypisz bez powtorzen (zachowaj kolejnosc pierwszego wystapienia)
// Wskazowka: HashSet<Integer> do sprawdzania czy juz bylo

public class z6_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: wczytaj 10 liczb, wypisz bez duplikatow
        ArrayList<Integer> a1 = new ArrayList<>();
        HashSet<Integer> a2 = new HashSet<>();
        int wczyt = 0;
        for (int i = 0; i< 10; i++){
            wczyt = scanner.nextInt();
            if (a2.contains(wczyt)) {
            } else {
                a1.add(wczyt);
                a2.add(wczyt);
            }
        }
        for (int i = 0; i < a1.size(); i++) {
            System.out.println(a1.get(i));
        }
        scanner.close();
    }
}
