package plan_nauki.tydzien_08;

import java.util.Iterator;

// Z8.1 - ListaLiczb (bez generyku, tylko Integer)
// void dodaj(int x), void usun(int x), int rozmiar()
// Implementuje Iterable<Integer>
// toString: "[1, 2, 3]"

public class z8_1 {
    public static void main(String[] args) {
        ListaLiczb lista = new ListaLiczb();
        lista.dodaj(10);
        lista.dodaj(20);
        lista.dodaj(30);
        lista.dodaj(40);
        lista.dodaj(50);
        System.out.println(lista);           // [10, 20, 30, 40, 50]

        lista.usun(30);                       // usun srodkowa
        System.out.println(lista);           // [10, 20, 40, 50]

        // for-each dziala dzieki Iterable:
        for (int x : lista) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

class ListaLiczb implements Iterable<Integer> {
    private Object[] dane = new Object[100];
    private int rozmiar = 0;

    public void dodaj(int x) {
        dane[rozmiar] = x;
        rozmiar++;
        // TODO
    }

    public void usun(int x) {
        for (int i = 0; i < rozmiar; i++) {
            if ((Integer) dane[i] == x) {
                // przesun wszystkie elementy po i o jedno w lewo (zapelnij dziure)
                for (int j = i; j < rozmiar - 1; j++) {
                    dane[j] = dane[j + 1];
                }
                rozmiar--;
                return; // usuwamy tylko pierwsze wystapienie
            }
        }
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
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < rozmiar; i++) {
            if (i > 0) sb.append(", ");   // przecinek przed kazdym oprocz pierwszego
            sb.append(dane[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
