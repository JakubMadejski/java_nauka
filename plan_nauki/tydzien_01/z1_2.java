package plan_nauki.tydzien_01;
import java.util.Scanner;


public class z1_2 {
    private static main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbe: ");
        int a = scanner.nextInt();
        System.out.println("podaj 2 liczba: ");
        int b = scanner.nextInt();
        System.out.println("Suma: " + (a+b));
        System.out.println("roznica" + (a-b));
        System.out.println("iloczyn" + (a*b));
        System.out.println("iloraz" + (double)(a/b));
    }
}
