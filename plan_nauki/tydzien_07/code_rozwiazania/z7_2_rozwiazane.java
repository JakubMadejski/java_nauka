package plan_nauki.tydzien_07.code_rozwiazania;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class z7_2_rozwiazane {
    public static void main(String[] args) {
        ArrayList<ProduktT7r> produkty = new ArrayList<>();
        produkty.add(new ProduktT7r("Mleko", 3.50));
        produkty.add(new ProduktT7r("Chleb", 5.20));
        produkty.add(new ProduktT7r("Jajka", 8.90));
        produkty.add(new ProduktT7r("Maslo", 7.00));
        produkty.add(new ProduktT7r("Ser", 12.50));

        Collections.sort(produkty); // od najtanszego
        System.out.println("Od najtanszego:");
        for (ProduktT7r p : produkty) System.out.println("  " + p);
    }
}

class ProduktT7r implements Comparable<ProduktT7r> {
    private final String nazwa;
    private final double cena;

    public ProduktT7r(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public String getNazwa() { return nazwa; }
    public double getCena()  { return cena; }

    @Override
    public int compareTo(ProduktT7r other) {
        return Double.compare(this.cena, other.cena); // od najtanszego
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProduktT7r)) return false;
        ProduktT7r p = (ProduktT7r) o;
        return Double.compare(cena, p.cena) == 0 && Objects.equals(nazwa, p.nazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, cena);
    }

    @Override
    public String toString() {
        return String.format("%-10s %.2f zl", nazwa, cena);
    }
}
