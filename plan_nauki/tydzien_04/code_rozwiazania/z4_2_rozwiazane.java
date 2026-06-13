package plan_nauki.tydzien_04.code_rozwiazania;

public class z4_2_rozwiazane {
    public static void main(String[] args) {
        StudentT4 s1 = new StudentT4("Anna", "Kowalska", 4.5);
        StudentT4 s2 = new StudentT4("Jan", "Nowak", 3.8);
        StudentT4 s3 = new StudentT4("Maria", "Wiśniewska", 5.0);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println("Liczba studentow: " + StudentT4.getLiczbaStudentow());
    }
}

class StudentT4 {
    private static int liczbaStudentow = 0;

    private final String imie;
    private final String nazwisko;
    private final double srednia;

    public StudentT4(String imie, String nazwisko, double srednia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.srednia = srednia;
        liczbaStudentow++;
    }

    public String getImie()     { return imie; }
    public String getNazwisko() { return nazwisko; }
    public double getSrednia()  { return srednia; }

    public static int getLiczbaStudentow() { return liczbaStudentow; }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " (srednia: " + srednia + ")";
    }
}
