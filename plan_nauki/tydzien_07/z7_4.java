package plan_nauki.tydzien_07;

// Z7.4 - Znajdz i napraw bledy
// BUG 1: String porownywany przez == zamiast .equals()
// BUG 2: hashCode uwzglednia tylko rok, ale equals sprawdza tez marke

public class z7_4 {
    public static void main(String[] args) {
        // TODO: napraw klase Auto ponizej, potem przetestuj
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
        return marka == a.marka && rok == a.rok; // BUG: String przez ==
    }

    @Override
    public int hashCode() {
        return rok; // BUG: nie uwzglednia marki
    }
}
