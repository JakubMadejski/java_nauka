package plan_nauki.tydzien_06;

// Z6.1 - Interfejs Ksztalt
// interface Ksztalt { double pole(); double obwod(); }
// Implementacje: Kolo(r), Prostokat(a, b), Trojkat(a, b, c)
// Stworz List<Ksztalt> i wypisz te o polu > 10

public class z6_1 {
    public static void main(String[] args) {
        // TODO
    }
}

interface Ksztalt {
    double pole();
    double obwod();
}

class KoloZ6 implements Ksztalt {
    public double pole()   { return 0; /* TODO */ }
    public double obwod()  { return 0; /* TODO */ }
}

class ProstokatZ6 implements Ksztalt {
    public double pole()   { return 0; /* TODO */ }
    public double obwod()  { return 0; /* TODO */ }
}

class TrojkatZ6 implements Ksztalt {
    public double pole()   { return 0; /* TODO */ }
    public double obwod()  { return 0; /* TODO */ }
}
