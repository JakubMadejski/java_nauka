package plan_nauki.tydzien_09;

// Z9.4 - Lancuch wyjatkow
// Stworz PrzetwarzanieWyjatek ktory opakowuje inny wyjatek (cause)
// Symuluj: IOException -> opakuj w PrzetwarzanieWyjatek -> wypisz oba komunikaty

public class z9_4 {
    public static void main(String[] args) {
        try {
            przetwarzaj();
        } catch (PrzetwarzanieWyjatek e) {
            System.out.println("Blad: " + e.getMessage());
            System.out.println("Przyczyna: " + e.getCause().getMessage());
        }
    }

    static void przetwarzaj() {
        try {
            throw new java.io.IOException("brak pliku"); // symulacja bledu IO
        } catch (java.io.IOException e) {
            // lapiemy niski blad IO i opakowujemy w nasz wyjatek (e = cause)
            throw new PrzetwarzanieWyjatek("Blad przetwarzania danych", e);
        }
    }
}

class PrzetwarzanieWyjatek extends RuntimeException {
    public PrzetwarzanieWyjatek(String message, Throwable cause) {
        super(message, cause);
    }
}
