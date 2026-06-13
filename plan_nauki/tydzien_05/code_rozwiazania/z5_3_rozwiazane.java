package plan_nauki.tydzien_05.code_rozwiazania;

public class z5_3_rozwiazane {
    public static void main(String[] args) {
        OsobaT5[] osoby = {
            new StudentT5b("Anna", "Kowalska", 4.5),
            new PracownikT5("Jan", "Nowak", "Programista"),
            new StudentT5b("Maria", "Wisniewska", 5.0),
            new PracownikT5("Piotr", "Lewandowski", "Manager")
        };
        for (OsobaT5 o : osoby) {
            System.out.println(o);
        }
    }
}

abstract class OsobaT5 {
    protected final String imie;
    protected final String nazwisko;

    public OsobaT5(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
}

class StudentT5b extends OsobaT5 {
    private final double srednia;

    public StudentT5b(String imie, String nazwisko, double srednia) {
        super(imie, nazwisko);
        this.srednia = srednia;
    }

    @Override
    public String toString() {
        return "Student: " + imie + " " + nazwisko + " (srednia: " + srednia + ")";
    }
}

class PracownikT5 extends OsobaT5 {
    private final String stanowisko;

    public PracownikT5(String imie, String nazwisko, String stanowisko) {
        super(imie, nazwisko);
        this.stanowisko = stanowisko;
    }

    @Override
    public String toString() {
        return "Pracownik: " + imie + " " + nazwisko + " [" + stanowisko + "]";
    }
}
