package plan_nauki.tydzien_06;

// Z6.2 - Dziennik klasy
// ArrayList<StudentZ6>, posortuj alfabetycznie (Comparable), potem po sredniej malejaco (Comparator)
// studenci.sort((s1, s2) -> Double.compare(s2.getSrednia(), s1.getSrednia()));

public class z6_2 {
    public static void main(String[] args) {
        // TODO: stworz liste, dodaj 5 studentow, posortuj i wypisz
    }
}

class StudentZ6 implements Comparable<StudentZ6> {
    private final String imie;
    private final String nazwisko;
    private final double srednia;

    public StudentZ6(String imie, String nazwisko, double srednia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.srednia = srednia;
    }

    public String getImie()      { return imie; }
    public String getNazwisko()  { return nazwisko; }
    public double getSrednia()   { return srednia; }

    @Override
    public int compareTo(StudentZ6 other) {
        return 0; // TODO: alfabetycznie po nazwisku
    }

    @Override
    public String toString() {
        return ""; // TODO
    }
}
