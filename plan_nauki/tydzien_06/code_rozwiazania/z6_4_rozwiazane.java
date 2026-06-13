package plan_nauki.tydzien_06.code_rozwiazania;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class z6_4_rozwiazane {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> liczby = new ArrayList<>();

        System.out.println("Podaj 10 liczb:");
        for (int i = 0; i < 10; i++) {
            liczby.add(scanner.nextInt());
        }

        // Sposob 1: HashSet do sledzenia juz widzianych
        HashSet<Integer> widziane = new HashSet<>();
        System.out.print("Bez duplikatow: ");
        for (int n : liczby) {
            if (widziane.add(n)) {  // add() zwraca false jesli juz bylo
                System.out.print(n + " ");
            }
        }
        System.out.println();

        // Sposob 2: nowa lista bez duplikatow (zachowuje kolejnosc)
        ArrayList<Integer> bezDuplikatow = new ArrayList<>();
        for (int n : liczby) {
            if (!bezDuplikatow.contains(n)) bezDuplikatow.add(n);
        }
        System.out.println("Sposob 2: " + bezDuplikatow);

        scanner.close();
    }
}
