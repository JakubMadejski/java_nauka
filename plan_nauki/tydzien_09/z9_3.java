package plan_nauki.tydzien_09;

import java.util.Iterator;

// Z9.3 - Wyjatek z referencja do kolekcji (z egzaminu 2024/2025)
// BrakElementuWyjatek przechowuje Iterable<?> - zawartosc kolekcji
// ZbiorUnikatowy.usun() rzuca go gdy elementu nie ma, przekazujac this

public class z9_3 {
    public static void main(String[] args) {
        // TODO: dodaj elementy, sprobuj usunac nieistniejacy, wychwyc i wypisz zawartosc
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
        // TODO: brak duplikatow, null -> IllegalArgumentException
    }

    public T usun(T x) {
        // TODO: znajdz i usun; jezeli nie ma -> throw new BrakElementuWyjatek("...", this)
        return null;
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
