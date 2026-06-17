package plan_nauki.tydzien_10;

// Z10.1 - Refaktoryzacja Figura (z egzaminu 2021 i 2025 - IDENTYCZNE!)
// Usun switch z obwod(), zastap wzorcem State
// Dodaj Szesciokat bez modyfikacji klasy Figura

public class z10_1 {
    public static void main(String[] args) {
        // jedna klasa Figura, rozny "rodzaj" wstrzykniety przez konstruktor
        Figura f1 = new Figura("kolo", new KoloF(), 5);
        Figura f2 = new Figura("trojkat", new TrojkatF(), 5);
        Figura f3 = new Figura("kwadrat", new KwadratF(), 5);
        Figura f4 = new Figura("szesciokat", new SzesciokatF(), 5);

        System.out.println(f1);   // obwod kola r=5
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);   // Szesciokat dodany BEZ zmiany klasy Figura!

        // mozna tez zmienic rodzaj w trakcie zycia obiektu:
        f1.zmienRodzaj(new KwadratF());
        System.out.println("po zmianie: " + f1);
    }
}

interface KsztaltFigury {
    double obliczObwod(double wielkosc);
}

class KoloF implements KsztaltFigury {
    public double obliczObwod(double wielkosc) { return 2 * Math.PI * wielkosc; }
}

class TrojkatF implements KsztaltFigury {
    public double obliczObwod(double wielkosc) { return 3 * wielkosc; }
}

class KwadratF implements KsztaltFigury {
    public double obliczObwod(double wielkosc) { return 4 * wielkosc; }
}

class SzesciokatF implements KsztaltFigury {
    public double obliczObwod(double wielkosc) { return 6 * wielkosc; }
}

class Figura {
    private final String nazwa;
    private final double wielkosc;
    private KsztaltFigury rodzaj;

    public Figura(String nazwa, KsztaltFigury rodzaj, double wielkosc) {
        this.nazwa = nazwa;
        this.rodzaj = rodzaj;
        this.wielkosc = wielkosc;
    }

    public double obwod() {
        return rodzaj.obliczObwod(wielkosc); // delegacja do stanu - zadnego switch!
    }

    public void zmienRodzaj(KsztaltFigury nowyRodzaj) { this.rodzaj = nowyRodzaj; }

    @Override
    public String toString() { return nazwa + ": obwod=" + obwod(); }
}
