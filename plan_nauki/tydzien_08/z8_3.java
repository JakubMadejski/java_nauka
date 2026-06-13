package plan_nauki.tydzien_08;

import java.util.Iterator;

// Z8.3 - Lista<Osoba> z egzaminu 2021 (PRAWDZIWE ZADANIE)
// Lista implementuje Iterable<Osoba>
// toString MUSI iterowac przez "for (Osoba o : this)" - nie przez dane[] bezposrednio!

public class z8_3 {
    public static void main(String[] args) {
        // TODO: stworz liste, dodaj kilka osob, wypisz
    }
}

class Osoba {
    private final String imie;
    private final String nazwisko;

    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie()      { return imie; }
    public String getNazwisko()  { return nazwisko; }

    @Override
    public boolean equals(Object o) {
        return false; // TODO
    }

    @Override
    public int hashCode() {
        return 0; // TODO
    }

    @Override
    public String toString() {
        return ""; // TODO
    }
}

class Lista implements Iterable<Osoba> {
    private Object[] dane = new Object[100];
    private int rozmiar = 0;

    public void dodaj(Osoba x) {
        // TODO: null -> IllegalArgumentException
    }

    public void usun(Osoba x) {
        // TODO
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
