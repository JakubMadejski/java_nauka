package plan_nauki.tydzien_07.code_rozwiazania;

import java.util.HashSet;
import java.util.Objects;

public class z7_4_rozwiazane {
    public static void main(String[] args) {
        AutoT7 a1 = new AutoT7("Toyota", 2020);
        AutoT7 a2 = new AutoT7("Toyota", 2020);
        AutoT7 a3 = new AutoT7("Honda", 2020);

        System.out.println(a1.equals(a2)); // true (ta sama marka i rok)
        System.out.println(a1.equals(a3)); // false

        HashSet<AutoT7> zbior = new HashSet<>();
        zbior.add(a1);
        zbior.add(a2); // duplikat
        zbior.add(a3);
        System.out.println("Rozmiar: " + zbior.size()); // 2
    }
}

class AutoT7 {
    private final String marka;
    private final int rok;

    public AutoT7(String marka, int rok) {
        this.marka = marka;
        this.rok = rok;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutoT7)) return false;
        AutoT7 a = (AutoT7) o;
        // POPRAWKA BUG 1: equals() zamiast == dla Stringa
        return marka.equals(a.marka) && rok == a.rok;
    }

    @Override
    public int hashCode() {
        // POPRAWKA BUG 2: uwzgledniamy tez marke
        return Objects.hash(marka, rok);
    }
}
