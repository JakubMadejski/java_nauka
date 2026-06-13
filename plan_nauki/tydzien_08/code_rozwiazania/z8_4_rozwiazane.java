package plan_nauki.tydzien_08.code_rozwiazania;

import java.util.HashSet;
import java.util.Iterator;

public class z8_4_rozwiazane {
    public static void main(String[] args) {
        ZbiorUnikalnyT8<String> z1 = new ZbiorUnikalnyT8<>();
        z1.dodaj("A");
        z1.dodaj("B");
        z1.dodaj("C");
        z1.dodaj("A"); // duplikat - ignorowany
        System.out.println(z1);         // [A, B, C]
        System.out.println("Rozmiar: " + z1.rozmiar()); // 3

        ZbiorUnikalnyT8<String> z2 = new ZbiorUnikalnyT8<>();
        z2.dodaj("C");
        z2.dodaj("A");
        z2.dodaj("B");
        System.out.println("equals (rozna kolejnosc): " + z1.equals(z2)); // true

        try {
            z1.dodaj(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Blad null: " + e.getMessage());
        }
    }
}

class ZbiorUnikalnyT8<T> implements Iterable<T> {
    private Object[] dane = new Object[100];
    private int rozmiar = 0;

    public void dodaj(T x) {
        if (x == null) throw new IllegalArgumentException("Null niedozwolony");
        for (int i = 0; i < rozmiar; i++) {
            if (dane[i].equals(x)) return; // duplikat - ignoruj
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Iterable)) return false;
        // zbierz oba do HashSet i porownaj (kolejnosc bez znaczenia)
        HashSet<Object> moj = new HashSet<>();
        for (T x : this) moj.add(x);
        HashSet<Object> inny = new HashSet<>();
        for (Object x : (Iterable<?>) o) inny.add(x);
        return moj.equals(inny);
    }

    @Override
    public int hashCode() {
        int suma = 0;
        for (T x : this) suma += x.hashCode(); // suma - kolejnosc bez znaczenia
        return suma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < rozmiar; i++) {
            if (i > 0) sb.append(", ");
            sb.append(dane[i]);
        }
        return sb.append("]").toString();
    }
}
