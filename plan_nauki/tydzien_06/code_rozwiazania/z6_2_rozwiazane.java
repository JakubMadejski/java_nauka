package plan_nauki.tydzien_06.code_rozwiazania;

import java.util.ArrayList;
import java.util.Collections;

public class z6_2_rozwiazane {
    public static void main(String[] args) {
        ArrayList<StudentT6> studenci = new ArrayList<>();
        studenci.add(new StudentT6("Jan", "Zielinski", 3.5));
        studenci.add(new StudentT6("Anna", "Kowalska", 4.8));
        studenci.add(new StudentT6("Piotr", "Adamski", 4.2));
        studenci.add(new StudentT6("Maria", "Nowak", 5.0));
        studenci.add(new StudentT6("Kasia", "Lis", 3.9));

        // Sposob 1: sort() uzywa compareTo (alfabetycznie po nazwisku)
        Collections.sort(studenci);
        System.out.println("Alfabetycznie:");
        for (StudentT6 s : studenci) System.out.println("  " + s);

        // Sposob 2: lambda - malejaco po sredniej
        studenci.sort((s1, s2) -> Double.compare(s2.getSrednia(), s1.getSrednia()));
        System.out.println("Po sredniej malejaco:");
        for (StudentT6 s : studenci) System.out.println("  " + s);
    }
}

class StudentT6 implements Comparable<StudentT6> {
    private final String imie;
    private final String nazwisko;
    private final double srednia;

    public StudentT6(String imie, String nazwisko, double srednia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.srednia = srednia;
    }

    public String getImie()     { return imie; }
    public String getNazwisko() { return nazwisko; }
    public double getSrednia()  { return srednia; }

    @Override
    public int compareTo(StudentT6 other) {
        return this.nazwisko.compareTo(other.nazwisko);
    }

    @Override
    public String toString() {
        return nazwisko + " " + imie + " (sr: " + srednia + ")";
    }
}
