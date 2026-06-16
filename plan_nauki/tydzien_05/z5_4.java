package plan_nauki.tydzien_05;

// Z5.4 - instanceof w praktyce
// Tablica Figura[] z kolami i kwadratami (klasy z README tygodnia 5)
// Policz osobno: suma pol kol, suma pol kwadratow
// Uzyj instanceof i rzutowania

public class z5_4 {
    public static void main(String[] args) {
        // tablica trzyma rozne figury pod wspolnym typem FiguraT5
        FiguraT5[] figury = {
            new KoloT5(5),
            new KwadratT5(4),
            new KoloT5(3),
            new KwadratT5(6),
            new KoloT5(1)
        };

        double sumaKol = 0;
        double sumaKwadratow = 0;

        for (FiguraT5 f : figury) {
            if (f instanceof KoloT5) {        // sprawdz czy to kolo
                sumaKol += f.pole();
            } else if (f instanceof KwadratT5) {  // czy kwadrat
                sumaKwadratow += f.pole();
            }
        }

        System.out.printf("Suma pol kol: %.2f%n", sumaKol);
        System.out.printf("Suma pol kwadratow: %.2f%n", sumaKwadratow);
    }
}

abstract class FiguraT5 {
    abstract double pole();
}

class KoloT5 extends FiguraT5 {
    private double promien;

    public KoloT5(double promien) {
        this.promien = promien;
    }

    @Override
    double pole() { return Math.PI * promien * promien; }
}

class KwadratT5 extends FiguraT5 {
    private double bok;

    public KwadratT5(double bok) {
        this.bok = bok;
    }

    @Override
    double pole() { return bok * bok; }
}
