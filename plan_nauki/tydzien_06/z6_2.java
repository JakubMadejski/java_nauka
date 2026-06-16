package plan_nauki.tydzien_06;
import java.util.ArrayList;
import java.util.Collections;

// Z6.2 - Dziennik klasy
// ArrayList<StudentZ6>, posortuj alfabetycznie (Comparable), potem po sredniej malejaco (Comparator)
// studenci.sort((s1, s2) -> Double.compare(s2.getSrednia(), s1.getSrednia()));

public class z6_2 {
    public static void main(String[] args) {
        // TODO: stworz liste, dodaj 5 studentow, posortuj i wypisz
        ArrayList<Student> a1 = new ArrayList<>();
        a1.add(new Student("Kuba", "M", 4.5));
        a1.add(new Student("Kuba", "Ma", 4.65));
        a1.add(new Student("Kuba", "Mad", 4.7));
        a1.add(new Student("Kuba", "Aaadej", 4.8));
        a1.add(new Student("Kuba", "Madejski", 4.9));
        System.out.println("--- Przed sortowaniem ---");
        for (int i = 0; i < a1.size(); i++) {
            System.out.println((i + 1) + ". " + a1.get(i));
        }

        Collections.sort(a1);   // sortuje po nazwisku (compareTo)

        System.out.println("--- Po sortowaniu (alfabetycznie po nazwisku) ---");
        for (int i = 0; i < a1.size(); i++) {
            System.out.println((i + 1) + ". " + a1.get(i));
        }

        // Comparator jako lambda - sortuj po sredniej MALEJACO (s2 przed s1)
        a1.sort((s1, s2) -> Double.compare(s2.getSrednia(), s1.getSrednia()));

        System.out.println("--- Po sortowaniu (srednia malejaco) ---");
        for (int i = 0; i < a1.size(); i++) {
            System.out.println((i + 1) + ". " + a1.get(i));
        }
    }
}

class Student implements Comparable<Student> {
    private final String imie;
    private final String nazwisko;
    private final double srednia;

    public Student(String imie, String nazwisko, double srednia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.srednia = srednia;
    }

    public String getImie()      { return imie; }
    public String getNazwisko()  { return nazwisko; }
    public double getSrednia()   { return srednia; }

    @Override
    public int compareTo(Student other) {
        return this.nazwisko.compareTo(other.nazwisko); // TODO: alfabetycznie po nazwisku
    }

    @Override
    public String toString() {
        return "Imie i nazwikso studenta: "+imie+" "+nazwisko+" oraz srednia: "+srednia; // TODO
    }
}
