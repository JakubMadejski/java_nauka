package plan_nauki.tydzien_05.code_rozwiazania;

public class z5_4_rozwiazane {
    public static void main(String[] args) {
        FiguraT5r[] figury = {
            new KoloT5r(5),
            new KwadratT5r(4),
            new KoloT5r(3),
            new KwadratT5r(6),
            new KoloT5r(1)
        };

        double sumaKol = 0;
        double sumaKwadratow = 0;

        for (FiguraT5r f : figury) {
            if (f instanceof KoloT5r) {
                sumaKol += f.pole();
            } else if (f instanceof KwadratT5r) {
                sumaKwadratow += f.pole();
            }
        }

        System.out.printf("Suma pol kol: %.2f%n", sumaKol);
        System.out.printf("Suma pol kwadratow: %.2f%n", sumaKwadratow);
    }
}

abstract class FiguraT5r {
    abstract double pole();
}

class KoloT5r extends FiguraT5r {
    private final double promien;
    public KoloT5r(double promien) { this.promien = promien; }
    @Override double pole() { return Math.PI * promien * promien; }
}

class KwadratT5r extends FiguraT5r {
    private final double bok;
    public KwadratT5r(double bok) { this.bok = bok; }
    @Override double pole() { return bok * bok; }
}
