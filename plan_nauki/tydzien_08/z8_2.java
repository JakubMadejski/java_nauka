package plan_nauki.tydzien_08;

import java.util.Iterator;

// Z8.2 - MojaLista<T> (z generykiem)
// Taka sama jak z8_1 ale generyczna: MojaLista<T> implements Iterable<T>
// Test: MojaLista<String> i MojaLista<Integer> - oba musza dzialac

public class z8_2 {
    public static void main(String[] args) {
        // TODO: przetestuj MojaLista<String> i MojaLista<Integer>
    }
}

class MojaLista<T> implements Iterable<T> {
    private Object[] dane = new Object[100];
    private int rozmiar = 0;

    public void dodaj(T x) {
        // TODO
    }

    public void usun(T x) {
        // TODO
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
    public String toString() {
        return ""; // TODO
    }
}
