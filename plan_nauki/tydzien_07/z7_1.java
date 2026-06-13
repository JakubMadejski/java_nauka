package plan_nauki.tydzien_07;

// Z7.1 - Klasa Punkt
// Pola double x, y; konstruktor, gettery, toString, equals, hashCode
// Test: dwa identyczne punkty w HashSet -> rozmiar == 1

public class z7_1 {
    public static void main(String[] args) {
        // TODO
    }
}

class Punkt {
    private final double x;
    private final double y;

    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    @Override
    public String toString() {
        return ""; // TODO
    }

    @Override
    public boolean equals(Object o) {
        return false; // TODO
    }

    @Override
    public int hashCode() {
        return 0; // TODO: Objects.hash(x, y)
    }
}
