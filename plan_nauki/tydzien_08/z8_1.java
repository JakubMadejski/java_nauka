package plan_nauki.tydzien_08;

import java.util.Iterator;

// Z8.1 - ListaLiczb (bez generyku, tylko Integer)
// void dodaj(int x), void usun(int x), int rozmiar()
// Implementuje Iterable<Integer>
// toString: "[1, 2, 3]"

public class z8_1 {
    public static void main(String[] args) {
        // TODO: dodaj 5 liczb, wypisz, usun srodkowa, wypisz znow
    }
}

class ListaLiczb implements Iterable<Integer> {
    private Object[] dane = new Object[100];
    private int rozmiar = 0;

    public void dodaj(int x) {
        // TODO
    }

    public void usun(int x) {
        // TODO
    }

    public int rozmiar() { return rozmiar; }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int idx = 0;
            public boolean hasNext() { return idx < rozmiar; }
            public Integer next() { return (Integer) dane[idx++]; }
        };
    }

    @Override
    public String toString() {
        return ""; // TODO: "[1, 2, 3]"
    }
}
