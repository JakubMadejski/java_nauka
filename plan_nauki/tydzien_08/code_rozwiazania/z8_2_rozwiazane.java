package plan_nauki.tydzien_08.code_rozwiazania;

import java.util.Iterator;

public class z8_2_rozwiazane {
    public static void main(String[] args) {
        MojaListaT8<String> stringi = new MojaListaT8<>();
        stringi.dodaj("Ala");
        stringi.dodaj("ma");
        stringi.dodaj("kota");
        System.out.println(stringi); // [Ala, ma, kota]

        MojaListaT8<Integer> liczby = new MojaListaT8<>();
        liczby.dodaj(1);
        liczby.dodaj(2);
        liczby.dodaj(3);
        liczby.usun(2);
        System.out.println(liczby); // [1, 3]

        for (String s : stringi) System.out.print(s + " ");
        System.out.println();
    }
}

class MojaListaT8<T> implements Iterable<T> {
    private Object[] dane = new Object[100];
    private int rozmiar = 0;

    public void dodaj(T x) {
        dane[rozmiar++] = x;
    }

    public void usun(T x) {
        for (int i = 0; i < rozmiar; i++) {
            if (dane[i].equals(x)) {
                System.arraycopy(dane, i + 1, dane, i, rozmiar - i - 1);
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
            public boolean hasNext() { return idx < rozmiar; }
            @SuppressWarnings("unchecked")
            public T next() { return (T) dane[idx++]; }
        };
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
