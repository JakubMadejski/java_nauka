package plan_nauki.tydzien_02;
import java.util.Scanner;
// Z2.1 - Klasyfikacja liczby
// Wczytaj liczbe i wypisz czy jest: ujemna/zero/dodatnia, parzysta/nieparzysta, wielokrotnosc 3

public class z2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe do analizy: ");
        int wczyt_liczb = scanner.nextInt();
        if (wczyt_liczb == 0) {
            System.out.println("Jest rowna zero ");
        } else if (wczyt_liczb > 0) {
            System.out.println("Wieksza od zera");
        } else {
            System.out.println("Mniejsza od zera");
        }
        if (wczyt_liczb % 2 == 0) {
            System.out.println("Parzysta");
        } else {
            System.out.println("Nieparzysta");
        }
        if (wczyt_liczb % 3 == 0){
            System.out.println("Jest wielokrotnoscia 3 ");
        } else {
            System.out.println("Nie jest wielokrotnoscia 3");
        }
    }
}
