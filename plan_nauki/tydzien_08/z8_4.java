package plan_nauki.tydzien_08;

import java.util.Iterator;

// Z8.4 - ZbiorUnikalny<T> (SparseVector z egzaminu 2024/2025)
// dodaj: ignoruje duplikaty, null -> wyjatek
// usun: zwraca element lub null
// equals: true jesli o jest Iterable z tymi samymi elementami (kolejnosc bez znaczenia!)
// hashCode: suma hashCode elementow

public class z8_4 {
    public static void main(String[] args) {
        // TODO: przetestuj duplikaty i equals z rozna kolejnoscia
    }
}

class ZbiorUnikalny<T> implements Iterable<T> {
    private Object[] dane = new Object[100];
    private int rozmiar = 0;

    public void dodaj(T x) {
        // TODO: null -> wyjatek; sprawdz czy juz jest
    }

    public T usun(T x) {
        return null; // TODO: znajdz, usun przez arraycopy, zwroc
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
        return false; // TODO: zbierz do HashSet, porownaj
    }

    @Override
    public int hashCode() {
        return 0; // TODO: suma hashCode elementow (kolejnosc nie ma znaczenia)
    }

    @Override
    public String toString() {
        return ""; // TODO
    }
}
