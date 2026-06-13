package plan_nauki.tydzien_07.code_rozwiazania;

import java.util.HashSet;
import java.util.Objects;

public class z7_1_rozwiazane {
    public static void main(String[] args) {
        PunktT7 p1 = new PunktT7(3.0, 4.0);
        PunktT7 p2 = new PunktT7(3.0, 4.0);
        PunktT7 p3 = new PunktT7(1.0, 2.0);

        System.out.println(p1.equals(p2)); // true
        System.out.println(p1.equals(p3)); // false

        HashSet<PunktT7> zbior = new HashSet<>();
        zbior.add(p1);
        zbior.add(p2); // duplikat - nie wejdzie
        zbior.add(p3);
        System.out.println("Rozmiar zbior: " + zbior.size()); // 2
    }
}

class PunktT7 {
    private final double x;
    private final double y;

    public PunktT7(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    @Override
    public String toString() { return "(" + x + ", " + y + ")"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PunktT7)) return false;
        PunktT7 p = (PunktT7) o;
        return Double.compare(x, p.x) == 0 && Double.compare(y, p.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
