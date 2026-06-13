package plan_nauki.tydzien_09.code_rozwiazania;

public class z9_1_rozwiazane {
    public static void main(String[] args) {
        // poprawny prostokat
        ProstokatT9 p = new ProstokatT9(5, 3);
        System.out.println("Pole: " + p.pole());

        // zly wymiar - wyjatek
        try {
            new ProstokatT9(-1, 5);
        } catch (NiedodatniaDlugoscT9 e) {
            System.out.println("Blad: " + e.getMessage());
        }
    }
}

class NiedodatniaDlugoscT9 extends RuntimeException {
    public NiedodatniaDlugoscT9(String message) {
        super(message);
    }
}

class ProstokatT9 {
    private final double szerokosc;
    private final double wysokosc;

    public ProstokatT9(double szerokosc, double wysokosc) {
        if (szerokosc <= 0) throw new NiedodatniaDlugoscT9("Szerokosc musi byc > 0, bylo: " + szerokosc);
        if (wysokosc <= 0)  throw new NiedodatniaDlugoscT9("Wysokosc musi byc > 0, bylo: " + wysokosc);
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }

    public double pole()  { return szerokosc * wysokosc; }
    public double obwod() { return 2 * (szerokosc + wysokosc); }
}
