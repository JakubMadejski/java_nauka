package plan_nauki.tydzien_08;

import java.util.Iterator;

// Z8.2 - MojaLista<T> (z generykiem)
// Taka sama jak z8_1 ale generyczna: MojaLista<T> implements Iterable<T>
// Test: MojaLista<String> i MojaLista<Integer> - oba musza dzialac

public class z8_2 {
    public static void main(String[] args) {
        // ta sama klasa dziala dla String...
        MojaLista<String> slowa = new MojaLista<>();
        slowa.dodaj("Ala");
        slowa.dodaj("ma");
        slowa.dodaj("kota");
        System.out.println(slowa);       // [Ala, ma, kota]
        slowa.usun("ma");
        System.out.println(slowa);       // [Ala, kota]

        // ...i dla Integer
        MojaLista<Integer> liczby = new MojaLista<>();
        liczby.dodaj(1);
        liczby.dodaj(2);
        liczby.dodaj(3);
        System.out.println(liczby);      // [1, 2, 3]

        for (String s : slowa) {         // for-each dziala dzieki Iterable
            System.out.print(s + " ");
        }
        System.out.println();
        for (int s : liczby) {         // for-each dziala dzieki Iterable
            System.out.print(s + " ");
        }
        System.out.println();
    }
}

class MojaLista<T> implements Iterable<T> {
    private Object[] dane = new Object[100];
    private int rozmiar = 0;

    public void dodaj(T x) {
        dane[rozmiar] = x;
        rozmiar++;
    }

    public void usun(T x) {
        for (int i = 0; i < rozmiar; i++) {
            if (dane[i].equals(x)) {   // obiekty przez equals, NIE ==
                for (int j = i; j < rozmiar - 1; j++) {
                    dane[j] = dane[j+1];
                }
                rozmiar--;
                return;
            }
        }
    }

    public int rozmiar() { return rozmiar; }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int idx = 0;
            public boolean hasNext() { 
                return idx < rozmiar; }
            @SuppressWarnings("unchecked")
            public T next() { 
                return (T) dane[idx++]; }
        };
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
