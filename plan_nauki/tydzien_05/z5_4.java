package plan_nauki.tydzien_05;

// Z5.4 - instanceof w praktyce
// Tablica Figura[] z kolami i kwadratami (klasy z README tygodnia 5)
// Policz osobno: suma pol kol, suma pol kwadratow
// Uzyj instanceof i rzutowania

public class z5_4 {
    public static void main(String[] args) {

    }
}

abstract class FiguraT5 {
    abstract double pole();
}

class KoloT5 extends FiguraT5 {
    // TODO: dodaj pole promien i konstruktor
    @Override
    double pole() { return 0; /* TODO */ }
}

class KwadratT5 extends FiguraT5 {
    // TODO: dodaj pole bok i konstruktor
    @Override
    double pole() { return 0; /* TODO */ }
}
