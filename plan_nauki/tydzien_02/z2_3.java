package plan_nauki.tydzien_02;

// Z2.3 - Tabliczka mnozenia 10x10
// Dwie zagniezdzone petle for, wyrownanie kolumn: System.out.printf("%3d", liczba)

public class z2_3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) { 
            for (int j = 1; j <=10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }
}
