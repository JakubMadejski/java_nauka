package plan_nauki.tydzien_09;

// Z9.2 - Wyjatek z danymi o pliku (z egzaminu 2021)
// Pola: nazwaPliku, numerLinii, zawartosc — wszystkie private final
// Komunikat super() zawiera wszystkie 3 informacje
// Gettery dla wszystkich pol

public class z9_2 {
    public static void main(String[] args) {
        try {
            // rzucamy wyjatek z konkretnymi danymi
            throw new NieprawidlowaLiniaWyjatek("dane.csv", 42, "abc;;xyz");
        } catch (NieprawidlowaLiniaWyjatek e) {
            System.out.println("Komunikat: " + e.getMessage());
            // a TERAZ czytamy poszczegolne dane przez gettery:
            System.out.println("Plik:      " + e.getNazwaPliku());
            System.out.println("Linia nr:  " + e.getNumerLinii());
            System.out.println("Zawartosc: " + e.getZawartosc());
        }
    }
}

class NieprawidlowaLiniaWyjatek extends RuntimeException {
    private final String nazwaPliku;
    private final int numerLinii;
    private final String zawartosc;

    public NieprawidlowaLiniaWyjatek(String nazwaPliku, int numerLinii, String zawartosc) {
        super("Wyjebalo sie w chuj zla nazwa pliku zny numer lini i zla zawarotxsc zjebie co to podal"+nazwaPliku+" "+numerLinii+" "+zawartosc); // TODO: komunikat zawierajacy wszystkie 3 dane
        this.nazwaPliku = nazwaPliku;
        this.numerLinii = numerLinii;
        this.zawartosc = zawartosc;
    }

    public String getNazwaPliku() { return nazwaPliku; }
    public int getNumerLinii()    { return numerLinii; }
    public String getZawartosc()  { return zawartosc; }
}
