package plan_nauki.tydzien_08;

import java.util.Iterator;
import java.util.Objects;

// Z8.3 - Lista<Osoba> z egzaminu 2021 (PRAWDZIWE ZADANIE)
// Lista implementuje Iterable<Osoba>
// toString MUSI iterowac przez "for (Osoba o : this)" - nie przez dane[] bezposrednio!

public class z8_3 {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.dodaj(new Osoba("Anna", "Kowalska"));
        lista.dodaj(new Osoba("Jan", "Nowak"));
        lista.dodaj(new Osoba("Maria", "Wisniewska"));
        System.out.println(lista);
        System.out.println("Liczba osob: " + lista.liczbaOsob());

        lista.usun(new Osoba("Jan", "Nowak"));   // dziala dzieki equals!
        System.out.println("Po usunieciu Jana:");
        System.out.println(lista);

        try {
            lista.dodaj(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Blad: " + e.getMessage());
        }
    }
}

class Osoba {
    private String imie;
    private String nazwisko;

    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie()      { return imie; }
    public String getNazwisko()  { return nazwisko; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Osoba)) return false;   // brakowalo tego!
        Osoba a = (Osoba) o;
        return Objects.equals(imie, a.imie) && Objects.equals(nazwisko, a.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko);
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }
}

class Lista implements Iterable<Osoba> {
    private Object[] dane = new Object[100];
    private int rozmiar = 0;

    public void dodaj(Osoba x) {
        if (x == null) {
            throw new IllegalArgumentException("Osoba nie moze byc null");
        }
        dane[rozmiar] = x;
        rozmiar++;
    }

    public void usun(Osoba x) {
        for (int i = 0; i<rozmiar; i++) {
            if (dane[i].equals(x)) {   // obiekty przez equals, NIE ==
                for (int j = i; j < rozmiar - 1; j++) {
                    dane[j] = dane[j+1];
                }
                rozmiar--;              // brakowalo!
                return;
            }
        }
    }

    public int liczbaOsob() { return rozmiar; }

    @Override
    public Iterator<Osoba> iterator() {
        return new Iterator<Osoba>() {
            int idx = 0;
            public boolean hasNext() { return idx < rozmiar; }
            public Osoba next() { return (Osoba) dane[idx++]; }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Osoba o : this) {
            sb.append(o).append("\n"); // TODO: dostosuj format
        }
        return sb.toString();
    }
}
