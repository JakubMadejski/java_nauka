package plan_nauki.tydzien_04.code_rozwiazania;

public class z4_4_rozwiazane {
    public static void main(String[] args) {
        LicznikT4 l = new LicznikT4();
        l.zwieksz();
        l.zwieksz();
        l.zwieksz(5);
        System.out.println(l);   // 7
        l.zmniejsz();
        l.zmniejsz();
        System.out.println(l);   // 5
        l.zeruj();
        System.out.println(l);   // 0
        l.zmniejsz();
        System.out.println(l);   // nie ponizej 0 -> 0
    }
}

class LicznikT4 {
    private int wartosc = 0;

    public void zwieksz()        { wartosc++; }
    public void zwieksz(int o)   { wartosc += o; }   // przeciazanie!
    public void zmniejsz()       { if (wartosc > 0) wartosc--; }
    public void zeruj()          { wartosc = 0; }
    public int odczytaj()        { return wartosc; }

    @Override
    public String toString() { return "Licznik(" + wartosc + ")"; }
}
