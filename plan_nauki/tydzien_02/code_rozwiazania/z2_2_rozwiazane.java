package plan_nauki.tydzien_02.code_rozwiazania;

public class z2_2_rozwiazane {
    public static void main(String[] args) {
        // Sposob 1: warunek FizzBuzz przez && (kolejnosc MA znaczenie)
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

        System.out.println("--- Sposob 2: % 15 zamiast && ---");

        // Sposob 2: % 15 (15 = 3 x 5, dzialanie identyczne)
        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
