package plan_nauki.tydzien_02.code_rozwiazania;

public class z2_3_rozwiazane {
    public static void main(String[] args) {
        // Sposob 1: dwie zagniezdzone petle for
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }

        System.out.println("--- Sposob 2: while zamiast for ---");

        // Sposob 2: while (rzadszy, ale tez poprawny)
        int i = 1;
        while (i <= 10) {
            int j = 1;
            while (j <= 10) {
                System.out.printf("%4d", i * j);
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
