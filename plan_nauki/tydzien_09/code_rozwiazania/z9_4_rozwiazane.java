package plan_nauki.tydzien_09.code_rozwiazania;

public class z9_4_rozwiazane {
    public static void main(String[] args) {
        try {
            przetwarzaj();
        } catch (PrzetwarzanieT9 e) {
            System.out.println("Blad: " + e.getMessage());
            System.out.println("Przyczyna: " + e.getCause().getMessage());
        }
    }

    static void przetwarzaj() {
        try {
            throw new java.io.IOException("brak pliku");
        } catch (java.io.IOException e) {
            // opakowujemy pierwotny wyjatek jako "cause"
            throw new PrzetwarzanieT9("Blad przetwarzania danych", e);
        }
    }
}

class PrzetwarzanieT9 extends RuntimeException {
    public PrzetwarzanieT9(String message, Throwable cause) {
        super(message, cause); // cause dostepny przez getCause()
    }
}
