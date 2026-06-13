package plan_nauki.tydzien_06.code_rozwiazania;

import java.util.ArrayList;
import java.util.List;

public class z6_1_rozwiazane {
    public static void main(String[] args) {
        List<KsztaltT6> ksztalty = new ArrayList<>();
        ksztalty.add(new KoloT6(4));
        ksztalty.add(new ProstokatT6(2, 3));
        ksztalty.add(new TrojkatT6(3, 4, 5));
        ksztalty.add(new KoloT6(1));

        System.out.println("Ksztalty o polu > 10:");
        for (KsztaltT6 k : ksztalty) {
            if (k.pole() > 10) System.out.printf("  pole=%.2f, obwod=%.2f%n", k.pole(), k.obwod());
        }
    }
}

interface KsztaltT6 {
    double pole();
    double obwod();
}

class KoloT6 implements KsztaltT6 {
    private final double r;
    public KoloT6(double r) { this.r = r; }
    public double pole()  { return Math.PI * r * r; }
    public double obwod() { return 2 * Math.PI * r; }
}

class ProstokatT6 implements KsztaltT6 {
    private final double a, b;
    public ProstokatT6(double a, double b) { this.a = a; this.b = b; }
    public double pole()  { return a * b; }
    public double obwod() { return 2 * (a + b); }
}

class TrojkatT6 implements KsztaltT6 {
    private final double a, b, c;
    public TrojkatT6(double a, double b, double c) { this.a = a; this.b = b; this.c = c; }
    public double pole() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    public double obwod() { return a + b + c; }
}
