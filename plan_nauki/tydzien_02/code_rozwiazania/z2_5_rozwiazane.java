package plan_nauki.tydzien_02.code_rozwiazania;

import java.util.Scanner;

public class z2_5_rozwiazane {
    public static void main(String[] args) {
        int tajnaLiczba = (int) (Math.random() * 100) + 1;
        Scanner scanner = new Scanner(System.in);
        int proby = 0;

        System.out.println("Zgadnij liczbe od 1 do 100!");

        // Sposob 1: while(true) z break
        while (true) {
            System.out.print("Twoj typ: ");
            int typ = scanner.nextInt();
            proby++;

            if (typ < tajnaLiczba) {
                System.out.println("Za malo!");
            } else if (typ > tajnaLiczba) {
                System.out.println("Za duzo!");
            } else {
                System.out.println("Trafiony! Proby: " + proby);
                break;
            }
        }

        scanner.close();
    }
}
