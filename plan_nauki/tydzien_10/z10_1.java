package plan_nauki.tydzien_10;

// Z10.1 - Refaktoryzacja Figura (z egzaminu 2021 i 2025 - IDENTYCZNE!)
// Usun switch z obwod(), zastap wzorcem State
// Dodaj Szesciokat bez modyfikacji klasy Figura

public class z10_1 {
    public static void main(String[] args) {
        // TODO: przetestuj Kolo, Trojkat, Kwadrat, Szesciokat
    }
}

interface KsztaltFigury {
    double obliczObwod(double wielkosc);
}

class KoloF implements KsztaltFigury {
    public double obliczObwod(double wielkosc) { return 0; /* TODO: 2 * Math.PI * wielkosc */ }
}

class TrojkatF implements KsztaltFigury {
    public double obliczObwod(double wielkosc) { return 0; /* TODO: 3 * wielkosc */ }
}

class KwadratF implements KsztaltFigury {
    public double obliczObwod(double wielkosc) { return 0; /* TODO: 4 * wielkosc */ }
}

class SzesciokатF implements KsztaltFigury {
    public double obliczObwod(double wielkosc) { return 0; /* TODO: 6 * wielkosc */ }
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
