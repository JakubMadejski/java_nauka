package plan_nauki.tydzien_07;
import java.util.HashSet;
import java.util.Objects;
// Z7.4 - Znajdz i napraw bledy
// BUG 1: String porownywany przez == zamiast .equals()
// BUG 2: hashCode uwzglednia tylko rok, ale equals sprawdza tez marke

public class z7_4 {
    public static void main(String[] args) {
        Auto a1 = new Auto("Toyota", 2020);
        Auto a2 = new Auto("Toyota", 2020);   // identyczne jak a1
        Auto a3 = new Auto("Honda", 2020);    // ta sama rok, inna marka

        System.out.println("a1.equals(a2): " + a1.equals(a2)); // true
        System.out.println("a1.equals(a3): " + a1.equals(a3)); // false (inna marka)

        HashSet<Auto> zbior = new HashSet<>();
        zbior.add(a1);
        zbior.add(a2);   // duplikat - nie wejdzie
        zbior.add(a3);
        System.out.println("Rozmiar: " + zbior.size()); // 2
    }
}

class Auto {
    private final String marka;
    private final int rok;

    public Auto(String marka, int rok) {
        this.marka = marka;
        this.rok = rok;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Auto)) return false;
        Auto a = (Auto) o;
        return Objects.equals(marka, a.marka) && rok == a.rok;
    }

    @Override
    public int hashCode() {
        return Objects.hash(marka, rok);
    }
}
