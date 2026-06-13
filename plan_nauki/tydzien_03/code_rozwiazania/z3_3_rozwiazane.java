package plan_nauki.tydzien_03.code_rozwiazania;

public class z3_3_rozwiazane {

    // kolo: jedno pole -> promien
    static double pole(double r) {
        return Math.PI * r * r;
    }

    // prostokat: dwa pola -> a i b
    static double pole(double a, double b) {
        return a * b;
    }

    // trojkat wzorem Herona: trzy boki
    static double pole(double a, double b, double c) {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static void main(String[] args) {
        System.out.printf("Kolo r=5: %.2f%n", pole(5));
        System.out.printf("Prostokat 3x4: %.2f%n", pole(3, 4));
        System.out.printf("Trojkat 3,4,5: %.2f%n", pole(3, 4, 5)); // trojkat prostokat -> 6.0
    }
}
