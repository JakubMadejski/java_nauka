package plan_nauki.tydzien_05;

// Z5.3 - Rozszerzenie z T4: abstract Osoba (imie, nazwisko)
// Student extends Osoba (dodaje srednia)
// Pracownik extends Osoba (dodaje stanowisko)
// Test: tablica Osoba[] z mieszanymi obiektami, wypisz wszystkich

public class z5_3 {
    public static void main(String[] args) {
        Osoba[] osoby = {
            new Student("Anna", "Kowalska", 4.5),
            new Pracownik("Jan", "Nowak", "Programista"),
            new Student("Maria", "Wisniewska", 5.0),
            new Pracownik("Piotr", "Lewandowski", "Manager")
        };
        for (Osoba o : osoby) {
            System.out.println(o);   // kazdy wola SWOJ toString()
        }
    }
}

abstract class Osoba {
    // TODO
    private String imie;
    private String nazwisko;
    public Osoba(String imie, String nazwisko){
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    public String getImie()     { return imie; }
    public String getNazwisko() { return nazwisko; }

    @Override
    public String toString() {
        return "Imie tej osoby to: "+imie+" i nazwisko: "+nazwisko;
    }
}

class Student extends Osoba {
    // TODO: srednia
    private double srednia;
    public Student(String imie, String nazwisko, double srednia){
        super(imie, nazwisko);
        this.srednia = srednia;
    }
    @Override
    public String toString() {
        return "Student: "+getImie()+" "+getNazwisko()+", srednia: "+srednia;
    }
}

class Pracownik extends Osoba {
    // TODO: stanowisko
    private String stanowisko;
    public Pracownik(String imie, String nazwisko, String stanowisko){
        super(imie, nazwisko);
        this.stanowisko = stanowisko;
    }
    @Override
    public String toString() {
        return "Pracownik: "+getImie()+" "+getNazwisko()+", stanowisko: "+stanowisko;
    }
}
