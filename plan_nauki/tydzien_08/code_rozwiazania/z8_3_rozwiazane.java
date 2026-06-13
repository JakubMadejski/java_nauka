package plan_nauki.tydzien_08.code_rozwiazania;

import java.util.Iterator;
import java.util.Objects;

public class z8_3_rozwiazane {
    public static void main(String[] args) {
        ListaOsobT8 lista = new ListaOsobT8();
        lista.dodaj(new OsobaT8("Anna", "Kowalska"));
        lista.dodaj(new OsobaT8("Jan", "Nowak"));
        lista.dodaj(new OsobaT8("Maria", "Wisniewska"));
        System.out.println(lista);

        try {
            lista.dodaj(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Blad: " + e.getMessage());
        }
    }
}

class OsobaT8 {
    private final String imie;
    private final String nazwisko;

    public OsobaT8(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie()     { return imie; }
    public String getNazwisko() { return nazwisko; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OsobaT8)) return false;
        OsobaT8 os = (OsobaT8) o;
        return Objects.equals(imie, os.imie) && Objects.equals(nazwisko, os.nazwisko);
    }

    @Override
    public int hashCode() { return Objects.hash(imie, nazwisko); }

    @Override
    public String toString() { return imie + " " + nazwisko; }
}

class ListaOsobT8 implements Iterable<OsobaT8> {
    private Object[] dane = new Object[100];
    private int rozmiar = 0;

    public void dodaj(OsobaT8 x) {
        if (x == null) throw new IllegalArgumentException("Nie mozna dodac null");
        dane[rozmiar++] = x;
    }

    public void usun(OsobaT8 x) {
        for (int i = 0; i < rozmiar; i++) {
            if (dane[i].equals(x)) {
                System.arraycopy(dane, i + 1, dane, i, rozmiar - i - 1);
                rozmiar--;
                return;
            }
        }
    }

    public int liczbaOsob() { return rozmiar; }

    @Override
    public Iterator<OsobaT8> iterator() {
        return new Iterator<OsobaT8>() {
            int idx = 0;
            public boolean hasNext() { return idx < rozmiar; }
            public OsobaT8 next()    { return (OsobaT8) dane[idx++]; }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (OsobaT8 o : this) {  // uzywa wlasnego iteratora!
            sb.append(o).append("\n");
        }
        return sb.toString();
    }
}
