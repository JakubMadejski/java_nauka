package plan_nauki.tydzien_02;
// Z2.5 - Zgadywanka (bonus)
// Program losuje liczbe 1-100, uzytkownik zgaduje, wypisuje "za malo"/"za duzo", liczy proby
// int x = (int)(Math.random() * 100) + 1;
import java.util.Scanner;

public class z2_5 {
    public static void main(String[] args) {
        int x = (int)(Math.random()*100) + 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zgadnij liczbe ");
        System.out.println("Wylosowana liczba " + x );

        int n = scanner.nextInt();
        while (n != x) {
            if (n > x) { 
                System.out.println("Mniej");
            } else {
                System.out.println("Wiecej");
            }
            System.out.println("Niezgadles podaj nowa liczba");
            n = scanner.nextInt();
        }
        System.out.println("zgadles!!!");
        scanner.close();


    }
}

