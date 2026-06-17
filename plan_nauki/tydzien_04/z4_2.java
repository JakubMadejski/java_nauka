package plan_nauki.tydzien_04;

// Z4.2 - Klasa Student
// Pola private: imie, nazwisko, srednia
// Konstruktor, gettery, toString()
// Pole statyczne: static int liczbaStudentow - liczy ile razy wywolano new Student()

public class z4_2 {
    public static void main(String[] args) {
        Student a1 = new Student("Kuba", "Madejski", 4.5);
        System.out.println(a1.getName());
        System.out.println(a1.getNazwisko());
        System.out.println(a1.getSredia());
        System.out.println(a1);
        new Student("Anna", "Nowak", 3.9);   // drugi student - licznik rosnie do 2
        Student.liczbStworzStudentow();

    }
}

class Student {
    private String name;
    private String nazwisko;
    private double srednia;
    private static int liczb_stworzonych;
    // TODO: pola, konstruktor, gettery, toString, pole statyczne
    public Student(String name, String nazwisko, double srednia) {
        this.name = name;
        this.nazwisko = nazwisko;
        this.srednia = srednia;
        liczb_stworzonych +=1;
    }
    public String getName() { 
        return name;
    }
    public String getNazwisko() { 
        return nazwisko;
    }
    public double getSredia() { 
        return srednia;
    }
    @Override
    public String toString() {
        return name + " " + nazwisko + " " + srednia;
    }
    public static void liczbStworzStudentow() {
        System.out.println("Liczba stworzoncyh studentow wynosi: " + liczb_stworzonych);
    }

}

