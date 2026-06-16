package plan_nauki.tydzien_07;

import java.util.HashSet;
import java.util.Objects;

// Z7.1 - Klasa Punkt
// Pola double x, y; konstruktor, gettery, toString, equals, hashCode
// Test: dwa identyczne punkty w HashSet -> rozmiar == 1

public class z7_1 {
    public static void main(String[] args) {
        Punkt p1 = new Punkt(3, 4);
        Punkt p2 = new Punkt(3, 4);   // identyczny jak p1
        Punkt p3 = new Punkt(1, 2);   // inny

        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false

        HashSet<Punkt> zbior = new HashSet<>();
        zbior.add(p1);
        zbior.add(p2);   // duplikat - nie wejdzie
        zbior.add(p3);
        System.out.println("Rozmiar zbioru: " + zbior.size()); // 2
    }
}

class Punkt {
    private double x;
    private double y;

    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    @Override
    public String toString() {
        return "Punkt o wspolczednych "+x+" "+y; // TODO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;             // ten sam obiekt
        if (!(o instanceof Punkt)) return false; // czy to w ogole Punkt?
        Punkt p = (Punkt) o;                     // rzutuj na Punkt
        return this.x == p.x && this.y == p.y;   // porownaj pola
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
