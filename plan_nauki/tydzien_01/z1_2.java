package plan_nauki.tydzien_01;
import java.util.Scanner;


public class z1_2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbe: ");
        int a = scanner.nextInt();
        System.out.print("Podaj 2 liczba: ");
        int b = scanner.nextInt();
        System.out.println("Suma: " + (a+b));
        System.out.println("Roznica: " + (a-b));
        System.out.println("Iloczyn: " + (a*b));
        System.out.println("Iloraz: " + ((double)a/b));
        scanner.close();
    }
}
