package kod;
// Dziedziczymy po Exception, dzięki czemu Java traktuje tę klasę jako oficjalny Błąd
public class NiewlasciwyFormatWierszaWyjatek extends Exception {
    
    // Dodajemy własne, analityczne pola (Hermetyzacja)
    private String wadliwaLinia;
    private int numerLinii;
    private String nazwaPliku;

    // Konstruktor
    public NiewlasciwyFormatWierszaWyjatek(String wiadomosc, String wadliwaLinia, int numerLinii, String nazwaPliku) {
        // super() wysyła "wiadomosc" do klasy-rodzica (Exception), żeby zachować standardowe działanie
        super(wiadomosc); 
        this.wadliwaLinia = wadliwaLinia;
        this.numerLinii = numerLinii;
        this.nazwaPliku = nazwaPliku;
    }

    // Klasa winna implementować pełen zestaw publicznych metod dostępowych (zgodnie z poleceniem)
    public String getWadliwaLinia() {
        return wadliwaLinia;
    }

    public int getNumerLinii() {
        return numerLinii;
    }

    public String getNazwaPliku() {
        return nazwaPliku;
    }
}