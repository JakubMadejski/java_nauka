package plan_nauki.tydzien_07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

// Z7.3 - Klasa Uczen (PRAWDZIWE ZADANIE z egzaminu 2021)
// Pola: String imie, nazwisko, double sredniaOcen
// Comparable: od NAJWYZSZEJ do NAJNIZSZEJ sredniej
// equals, hashCode, toString, konstruktor, gettery

public class z7_3 {
    public static void main(String[] args) {
        ArrayList<Uczen> uczniowie = new ArrayList<>();
        uczniowie.add(new Uczen("Anna", "Kowalska", 4.5));
        uczniowie.add(new Uczen("Jan", "Nowak", 3.2));
        uczniowie.add(new Uczen("Maria", "Wisniewska", 5.0));
        uczniowie.add(new Uczen("Piotr", "Lewandowski", 4.8));

        Collections.sort(uczniowie);   // uzywa compareTo - najwyzsza srednia na gorze

        System.out.println("Uczniowie od najlepszego:");
        for (Uczen u : uczniowie) {
            System.out.println("  " + u);
        }
    }
}

class Uczen implements Comparable<Uczen> {
    private String imie;
    private String nazwisko;
    private double sredniaOcen;

    public Uczen(String imie, String nazwisko, double sredniaOcen) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.sredniaOcen = sredniaOcen;
    }

    public String getImie()         { return imie; }
    public String getNazwisko()     { return nazwisko; }
    public double getSredniaOcen()  { return sredniaOcen; }

    @Override
    public int compareTo(Uczen other) {
        return Double.compare(other.sredniaOcen, this.sredniaOcen); // TODO: Double.compare(other.sredniaOcen, this.sredniaOcen)
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Uczen)) return false;
        Uczen a = (Uczen) o;                          // a = rzutowany Uczen
        return Double.compare(sredniaOcen, a.sredniaOcen) == 0
            && Objects.equals(imie, a.imie)           // String przez equals
            && Objects.equals(nazwisko, a.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, sredniaOcen);
    }

    @Override
    public String toString() {
        return nazwisko + " " + imie + " (srednia: " + sredniaOcen + ")";
    }
}
