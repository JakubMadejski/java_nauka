package plan_nauki.tydzien_07;

// Z7.2 - Klasa Produkt z Comparable
// Pola String nazwa, double cena; Comparable: od najtanszego do najdrozszego
// Pelne equals, hashCode, toString
// Test: lista 5 produktow, Collections.sort(), wypisz

public class z7_2 {
    public static void main(String[] args) {
        // TODO
    }
}

class ProduktT7 implements Comparable<ProduktT7> {
    private final String nazwa;
    private final double cena;

    public ProduktT7(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public String getNazwa() { return nazwa; }
    public double getCena()  { return cena; }

    @Override
    public int compareTo(ProduktT7 other) {
        return 0; // TODO: od najtanszego do najdrozszego
    }

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
