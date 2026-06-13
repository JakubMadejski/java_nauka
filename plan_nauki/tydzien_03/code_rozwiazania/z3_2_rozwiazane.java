package plan_nauki.tydzien_03.code_rozwiazania;

public class z3_2_rozwiazane {

    static double dodaj(double a, double b)    { return a + b; }
    static double odejmij(double a, double b)  { return a - b; }
    static double pomnoz(double a, double b)   { return a * b; }

    // Sposob 1: zwroc Double.NaN gdy dzielenie przez 0
    static double podziel(double a, double b) {
        if (b == 0) return Double.NaN;
        return a / b;
    }

    // Sposob 2: rzuc wyjatek (bardziej "javowy")
    static double podzielV2(double a, double b) {
        if (b == 0) throw new ArithmeticException("Dzielenie przez zero!");
        return a / b;
    }

    public static void main(String[] args) {
        System.out.println(dodaj(5, 3));       // 8.0
        System.out.println(odejmij(5, 3));     // 2.0
        System.out.println(pomnoz(5, 3));      // 15.0
        System.out.println(podziel(10, 3));    // 3.3333...
        System.out.println(podziel(10, 0));    // NaN

        try {
            System.out.println(podzielV2(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Blad: " + e.getMessage());
        }
    }
}
