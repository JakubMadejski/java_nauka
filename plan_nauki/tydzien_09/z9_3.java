package plan_nauki.tydzien_09;

import java.util.Iterator;

// Z9.3 - Wyjatek z referencja do kolekcji (z egzaminu 2024/2025)
// BrakElementuWyjatek przechowuje Iterable<?> - zawartosc kolekcji
// ZbiorUnikatowy.usun() rzuca go gdy elementu nie ma, przekazujac this

public class z9_3 {
    public static void main(String[] args) {
        ZbiorUnikatowy<String> zbior = new ZbiorUnikatowy<>();
        zbior.dodaj("A");
        zbior.dodaj("B");
        zbior.dodaj("C");

        System.out.println("Usunieto: " + zbior.usun("B"));  // dziala -> B

        try {
            zbior.usun("X");   // X nie istnieje -> rzuci BrakElementuWyjatek
        } catch (BrakElementuWyjatek e) {
            System.out.println("Blad: " + e.getMessage());
            // wyjatek niesie cala kolekcje - mozemy ja przejsc petla:
            System.out.print("Zawartosc zbioru w chwili bledu: ");
            for (Object o : e.getZawartosc()) {
                System.out.print(o + " ");
            }
            System.out.println();
        }
    }
}

class BrakElementuWyjatek extends RuntimeException {
    private final Iterable<?> zawartosc;

    public BrakElementuWyjatek(String message, Iterable<?> zawartosc) {
        super(message);
        this.zawartosc = zawartosc;
    }

    public Iterable<?> getZawartosc() { return zawartosc; }
}

class ZbiorUnikatowy<T> implements Iterable<T> {
    private Object[] dane = new Object[100];
    private int rozmiar = 0;

    public void dodaj(T x) {
        if (x == null) {
            throw new IllegalArgumentException("Nie mozna dodac null");
        }
        for (int i = 0; i < rozmiar; i++) {
            if (dane[i].equals(x)) return;   // duplikat - ignoruj
        }
        dane[rozmiar] = x;
        rozmiar++;
    }

    public T usun(T x) {
        for (int i = 0; i < rozmiar; i++) {
            if (dane[i].equals(x)) {
                @SuppressWarnings("unchecked")
                T usuniety = (T) dane[i];
                for (int j = i; j < rozmiar - 1; j++) {
                    dane[j] = dane[j + 1];
                }
                dane[rozmiar - 1] = null;
                rozmiar--;
                return usuniety;
            }
        }
        // nie znaleziono -> rzuc wyjatek, przekazujac CALA kolekcje (this)
        throw new BrakElementuWyjatek("Brak elementu: " + x, this);
    }

    public int rozmiar() { return rozmiar; }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int idx = 0;
            public boolean hasNext() { return idx < rozmiar; }
            @SuppressWarnings("unchecked")
            public T next() { return (T) dane[idx++]; }
        };
    }
}
