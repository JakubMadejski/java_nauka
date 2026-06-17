package plan_nauki.tydzien_08;

import java.util.HashSet;
import java.util.Iterator;

// Z8.4 - ZbiorUnikalny<T> (SparseVector z egzaminu 2024/2025)
// dodaj: ignoruje duplikaty, null -> wyjatek
// usun: zwraca element lub null
// equals: true jesli o jest Iterable z tymi samymi elementami (kolejnosc bez znaczenia!)
// hashCode: suma hashCode elementow

public class z8_4 {
    public static void main(String[] args) {
        ZbiorUnikalny<String> z1 = new ZbiorUnikalny<>();
        z1.dodaj("A");
        z1.dodaj("B");
        z1.dodaj("C");
        z1.dodaj("A");                 // duplikat - ignorowany
        System.out.println(z1);        // [A, B, C]
        System.out.println("rozmiar: " + z1.rozmiar()); // 3

        // drugi zbior - te same elementy, INNA kolejnosc
        ZbiorUnikalny<String> z2 = new ZbiorUnikalny<>();
        z2.dodaj("C");
        z2.dodaj("A");
        z2.dodaj("B");
        System.out.println("z1.equals(z2): " + z1.equals(z2)); // true (kolejnosc bez znaczenia)

        System.out.println("usunieto: " + z1.usun("B"));  // B
        System.out.println(z1);        // [A, C]
        System.out.println("usunieto nieistniejacy: " + z1.usun("X")); // null

        try {
            z1.dodaj(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Blad: " + e.getMessage());
        }
    }
}

class ZbiorUnikalny<T> implements Iterable<T> {
    private Object[] dane = new Object[100];
    private int rozmiar = 0;

    public void dodaj(T x) {
        if (x == null) {
            throw new IllegalArgumentException("Nie mozna dodac null");
        }
        for (int i = 0; i < rozmiar; i++) {   // tylko do rozmiar, nie po calej tablicy
            if (dane[i].equals(x)) {           // duplikat -> equals, NIE ==
                return;                        // juz jest, ignoruj
            }
        }
        dane[rozmiar] = x;
        rozmiar++;
    }

    public T usun(T x) {
        for (int i = 0; i < rozmiar; i++) {
            if (dane[i].equals(x)) {
                @SuppressWarnings("unchecked")
                T usuniety = (T) dane[i];           // zapamietaj zanim usuniesz
                for (int j = i; j < rozmiar - 1; j++) {
                    dane[j] = dane[j + 1];          // przesun reszte w lewo (jak w z8_1)
                }
                dane[rozmiar - 1] = null;           // wyczysc ostatni slot
                rozmiar--;
                return usuniety;
            }
        }
        return null;   // nie znaleziono
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
        if (this == o) return true;
        if (!(o instanceof Iterable)) return false;   // musi byc Iterable
        // zbierz elementy obu do HashSet (Set ignoruje kolejnosc)
        HashSet<Object> moj = new HashSet<>();
        for (T x : this) moj.add(x);
        HashSet<Object> inny = new HashSet<>();
        for (Object x : (Iterable<?>) o) inny.add(x);
        return moj.equals(inny);   // porownanie zawartosci, nie hashCode!
    }

    @Override
    public int hashCode() {
        int sum = 0;
        for (int i = 0; i < rozmiar; i++) {
            sum += dane[i].hashCode();   // suma hashCode elementow (kolejnosc bez znaczenia)
        }
        return sum;
    }

    @Override
    public String toString() {
        String wynik = "[";
        for (int i = 0; i < rozmiar; i++) {
            if (i > 0) wynik = wynik + ", ";
            wynik = wynik + dane[i];
        }
        return wynik + "]";
    }
}
