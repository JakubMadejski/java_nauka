package plan_nauki.tydzien_09.code_rozwiazania;

import java.util.Iterator;

public class z9_3_rozwiazane {
    public static void main(String[] args) {
        ZbiorUnikatowyT9<String> zbior = new ZbiorUnikatowyT9<>();
        zbior.dodaj("A");
        zbior.dodaj("B");
        zbior.dodaj("C");

        System.out.println("Usunieto: " + zbior.usun("B")); // B

        try {
            zbior.usun("X"); // nie istnieje
        } catch (BrakElementuT9 e) {
            System.out.println("Blad: " + e.getMessage());
            System.out.print("Zawartosc zbior: ");
            for (Object o : e.getZawartosc()) System.out.print(o + " ");
            System.out.println();
        }
    }
}

class BrakElementuT9 extends RuntimeException {
    private final Iterable<?> zawartosc;

    public BrakElementuT9(String message, Iterable<?> zawartosc) {
        super(message);
        this.zawartosc = zawartosc;
    }

    public Iterable<?> getZawartosc() { return zawartosc; }
}

class ZbiorUnikatowyT9<T> implements Iterable<T> {
    private Object[] dane = new Object[100];
    private int rozmiar = 0;

    public void dodaj(T x) {
        if (x == null) throw new IllegalArgumentException("Null niedozwolony");
        for (int i = 0; i < rozmiar; i++) {
            if (dane[i].equals(x)) return;
        }
        dane[rozmiar++] = x;
    }

    public T usun(T x) {
        for (int i = 0; i < rozmiar; i++) {
            if (dane[i].equals(x)) {
                @SuppressWarnings("unchecked")
                T wynik = (T) dane[i];
                System.arraycopy(dane, i + 1, dane, i, rozmiar - i - 1);
                rozmiar--;
                return wynik;
            }
        }
        throw new BrakElementuT9("Brak elementu: " + x, this);
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
