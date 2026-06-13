package plan_nauki.tydzien_09.code_rozwiazania;

public class z9_2_rozwiazane {
    public static void main(String[] args) {
        try {
            throw new NieprawidlowaLiniaT9("dane.csv", 42, "abc;def;xyz");
        } catch (NieprawidlowaLiniaT9 e) {
            System.out.println("Komunikat: " + e.getMessage());
            System.out.println("Plik: " + e.getNazwaPliku());
            System.out.println("Linia nr: " + e.getNumerLinii());
            System.out.println("Zawartosc: " + e.getZawartosc());
        }
    }
}

class NieprawidlowaLiniaT9 extends RuntimeException {
    private final String nazwaPliku;
    private final int numerLinii;
    private final String zawartosc;

    public NieprawidlowaLiniaT9(String nazwaPliku, int numerLinii, String zawartosc) {
        super("Nieprawidlowa linia " + numerLinii + " w pliku '" + nazwaPliku + "': " + zawartosc);
        this.nazwaPliku = nazwaPliku;
        this.numerLinii = numerLinii;
        this.zawartosc = zawartosc;
    }

    public String getNazwaPliku() { return nazwaPliku; }
    public int getNumerLinii()    { return numerLinii; }
    public String getZawartosc()  { return zawartosc; }
}
