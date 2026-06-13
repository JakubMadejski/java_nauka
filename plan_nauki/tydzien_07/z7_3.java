package plan_nauki.tydzien_07;

// Z7.3 - Klasa Uczen (PRAWDZIWE ZADANIE z egzaminu 2021)
// Pola: String imie, nazwisko, double sredniaOcen
// Comparable: od NAJWYZSZEJ do NAJNIZSZEJ sredniej
// equals, hashCode, toString, konstruktor, gettery

public class z7_3 {
    public static void main(String[] args) {
        // TODO: stworz liste uczniow, Collections.sort(), wypisz
        // Oczekiwany wynik: najwyzsza srednia na gorze
    }
}

class Uczen implements Comparable<Uczen> {
    private final String imie;
    private final String nazwisko;
    private final double sredniaOcen;

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
        return 0; // TODO: Double.compare(other.sredniaOcen, this.sredniaOcen)
    }

    @Override
    public boolean equals(Object o) {
        return false; // TODO
    }

    @Override
    public int hashCode() {
        return 0; // TODO: Objects.hash(imie, nazwisko, sredniaOcen)
    }

    @Override
    public String toString() {
        return ""; // TODO: np. "Kowalska Anna (srednia: 4.5)"
    }
}
