package plan_nauki.tydzien_08.code_rozwiazania;

import java.util.Iterator;

public class z8_1_rozwiazane {
    public static void main(String[] args) {
        ListaLiczbT8 lista = new ListaLiczbT8();
        lista.dodaj(10);
        lista.dodaj(20);
        lista.dodaj(30);
        lista.dodaj(40);
        lista.dodaj(50);
        System.out.println(lista); // [10, 20, 30, 40, 50]

        lista.usun(30);
        System.out.println(lista); // [10, 20, 40, 50]

        // for-each dziala bo implements Iterable
        for (int n : lista) System.out.print(n + " ");
        System.out.println();
    }
}

class ListaLiczbT8 implements Iterable<Integer> {
    private Object[] dane = new Object[100];
    private int rozmiar = 0;

    public void dodaj(int x) {
        dane[rozmiar++] = x;
    }

    public void usun(int x) {
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
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int idx = 0;
            public boolean hasNext() { return idx < rozmiar; }
            public Integer next()    { return (Integer) dane[idx++]; }
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
