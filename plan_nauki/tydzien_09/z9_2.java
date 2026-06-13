package plan_nauki.tydzien_09;

// Z9.2 - Wyjatek z danymi o pliku (z egzaminu 2021)
// Pola: nazwaPliku, numerLinii, zawartosc — wszystkie private final
// Komunikat super() zawiera wszystkie 3 informacje
// Gettery dla wszystkich pol

public class z9_2 {
    public static void main(String[] args) {
        // TODO: rzuc i wychwyc, wypisz getMessage() i kazdy getter
    }
}

class NieprawidlowaLiniaWyjatek extends RuntimeException {
    private final String nazwaPliku;
    private final int numerLinii;
    private final String zawartosc;

    public NieprawidlowaLiniaWyjatek(String nazwaPliku, int numerLinii, String zawartosc) {
        super(""); // TODO: komunikat zawierajacy wszystkie 3 dane
        this.nazwaPliku = nazwaPliku;
        this.numerLinii = numerLinii;
        this.zawartosc = zawartosc;
    }

    public String getNazwaPliku() { return nazwaPliku; }
    public int getNumerLinii()    { return numerLinii; }
    public String getZawartosc()  { return zawartosc; }
}
