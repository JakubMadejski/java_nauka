package plan_nauki.tydzien_10.code_rozwiazania;

public class z10_1_rozwiazane {
    public static void main(String[] args) {
        FiguraT10 f = new FiguraT10("figura", new KoloFT10(), 5);
        System.out.println(f); // obwod kola r=5

        f.zmienRodzaj(new KwadratFT10());
        System.out.println(f); // obwod kwadratu bok=5

        f.zmienRodzaj(new TrojkatFT10());
        System.out.println(f);

        // Szesciokat dodany bez modyfikacji klasy Figura - to jest wlasnie wzorzec State!
        f.zmienRodzaj(new SzesciokатFT10());
        System.out.println(f);
    }
}

interface KsztaltFiguryT10 {
    double obliczObwod(double wielkosc);
}

class KoloFT10 implements KsztaltFiguryT10 {
    public double obliczObwod(double r) { return 2 * Math.PI * r; }
}

class TrojkatFT10 implements KsztaltFiguryT10 {
    public double obliczObwod(double bok) { return 3 * bok; }
}

class KwadratFT10 implements KsztaltFiguryT10 {
    public double obliczObwod(double bok) { return 4 * bok; }
}

class SzesciokатFT10 implements KsztaltFiguryT10 {
    public double obliczObwod(double bok) { return 6 * bok; }
}

class FiguraT10 {
    private final String nazwa;
    private final double wielkosc;
    private KsztaltFiguryT10 rodzaj;

    public FiguraT10(String nazwa, KsztaltFiguryT10 rodzaj, double wielkosc) {
        this.nazwa = nazwa;
        this.rodzaj = rodzaj;
        this.wielkosc = wielkosc;
    }

    public double obwod() { return rodzaj.obliczObwod(wielkosc); }
    public void zmienRodzaj(KsztaltFiguryT10 nowyRodzaj) { this.rodzaj = nowyRodzaj; }

    @Override
    public String toString() { return nazwa + ": obwod=" + String.format("%.2f", obwod()); }
}
