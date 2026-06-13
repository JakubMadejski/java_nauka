package plan_nauki.tydzien_07.code_rozwiazania;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class z7_3_rozwiazane {
    public static void main(String[] args) {
        ArrayList<UczenT7> uczniowie = new ArrayList<>();
        uczniowie.add(new UczenT7("Anna", "Kowalska", 4.5));
        uczniowie.add(new UczenT7("Jan", "Nowak", 3.2));
        uczniowie.add(new UczenT7("Maria", "Wisniewska", 5.0));
        uczniowie.add(new UczenT7("Piotr", "Lewandowski", 4.8));

        Collections.sort(uczniowie); // najwyzsza srednia na gorze
        System.out.println("Posortowani od najlepszego:");
        for (UczenT7 u : uczniowie) System.out.println("  " + u);
    }
}

class UczenT7 implements Comparable<UczenT7> {
    private final String imie;
    private final String nazwisko;
    private final double sredniaOcen;

    public UczenT7(String imie, String nazwisko, double sredniaOcen) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.sredniaOcen = sredniaOcen;
    }

    public String getImie()        { return imie; }
    public String getNazwisko()    { return nazwisko; }
    public double getSredniaOcen() { return sredniaOcen; }

    @Override
    public int compareTo(UczenT7 other) {
        // malejaco: other przed this
        return Double.compare(other.sredniaOcen, this.sredniaOcen);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UczenT7)) return false;
        UczenT7 u = (UczenT7) o;
        return Double.compare(sredniaOcen, u.sredniaOcen) == 0
                && Objects.equals(imie, u.imie)
                && Objects.equals(nazwisko, u.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, sredniaOcen);
    }

    @Override
    public String toString() {
        return nazwisko + " " + imie + " (srednia: " + sredniaOcen + ")";
    }
}
