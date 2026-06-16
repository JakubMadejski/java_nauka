package plan_nauki.tydzien_04;

// Z4.4 - Klasa Licznik
// Pole private int wartosc = 0
// zwieksz(), zmniejsz() (nie ponizej 0), zwieksz(int o) (przeciazanie!), zeruj(), odczytaj(), toString()

public class z4_4 {
    public static void main(String[] args) {
        Licznik l = new Licznik();
        l.zwieksz();        // 1
        l.zwieksz();        // 2
        l.zwieksz(5);       // 7 - przeciazenie z argumentem
        System.out.println(l);   // Licznik7
        l.zmiejsz();        // 6
        l.zmiejsz();        // 5
        System.out.println("Wartosc: " + l.odczytaj()); // 5
        l.zeruj();          // 0
        System.out.println(l);   // Licznik0
        l.zmiejsz();        // nie ponizej 0 -> zostaje 0
        System.out.println("Po zmiejsz na zero: " + l.odczytaj()); // 0
    }
}

class Licznik {
    // TODO: pole, metody - pamietaj o przeciazaniu zwieksz()
    private int wartosc = 0;
    
    public void zwieksz() {
        wartosc += 1;
    }
    public void zmiejsz() {
        if (wartosc > 0) {
            wartosc -= 1;
        }
    }
    public void zwieksz(int o) { 
        if (o > 0) {
            wartosc += o;
        }
    }
    public void zeruj() {
        wartosc = 0;
    }
    public int odczytaj() {
        return wartosc;
    }
    @Override
    public String toString() {
        return "Licznik(" + wartosc + ")";
    }

}
