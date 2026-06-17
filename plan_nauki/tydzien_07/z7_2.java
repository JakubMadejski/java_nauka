package plan_nauki.tydzien_07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

// Z7.2 - Klasa Produkt z Comparable
// Pola String nazwa, double cena; Comparable: od najtanszego do najdrozszego
// Pelne equals, hashCode, toString
// Test: lista 5 produktow, Collections.sort(), wypisz

public class z7_2 {
    public static void main(String[] args) {
        ArrayList<ProduktT7> produkty = new ArrayList<>();
        produkty.add(new ProduktT7("Mleko", 3.50));
        produkty.add(new ProduktT7("Chleb", 5.20));
        produkty.add(new ProduktT7("Jajka", 8.90));
        produkty.add(new ProduktT7("Maslo", 7.00));
        produkty.add(new ProduktT7("Ser", 12.50));

        Collections.sort(produkty);   // uzywa compareTo - od najtanszego

        System.out.println("Produkty od najtanszego:");
        for (ProduktT7 p : produkty) {
            System.out.println("  " + p);
        }
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
        return Double.compare(this.cena, other.cena); // od najtanszego do najdrozszego
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProduktT7)) return false;
        ProduktT7 p = (ProduktT7) o;
        return Double.compare(cena, p.cena) == 0 && Objects.equals(nazwa, p.nazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, cena);
    }

    @Override
    public String toString() {
        return nazwa + " - " + cena + " zl";
    }
}
