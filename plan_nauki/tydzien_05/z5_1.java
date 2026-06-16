package plan_nauki.tydzien_05;

// Z5.1 - Hierarchia zwierzat
// Klasa abstrakcyjna Zwierze: imie, wiek, abstract String dzwiek(), void przedstawSie()
// Podklasy: Pies, Kot, Krowa - kazda implementuje dzwiek() inaczej
// Test: tablica Zwierze[] z roznymi obiektami, wypisz wszystkich

public class z5_1 {
    public static void main(String[] args) {
        Zwierze[] zwierzeta = {
            new Pies("Rex", 3),
            new Kot("Mruczek", 5),
            new Krowa("Basia", 4)
        };
        for (Zwierze z : zwierzeta) {
            z.przedstawSie();
        }
    }
}

abstract class Zwierze {
    // TODO: pola imie/wiek, konstruktor, abstract dzwiek(), przedstawSie()
    private String imie;
    private int wiek;

    public Zwierze(String imie, int wiek){
        this.imie = imie;
        this.wiek = wiek;
    }
    
    abstract String dzwiek();
    
    public void przedstawSie() {
        System.out.println("Jestem "+ imie + " mam " + wiek + " lat i mowie "+ dzwiek());
    }


}

class Pies extends Zwierze {
    public Pies(String imie, int wiek) {
        super(imie, wiek);
    }
    @Override
    public String dzwiek() {
        return "hau hau hau";
    }
}

class Kot extends Zwierze {
    public Kot(String imie, int wiek) {
        super(imie, wiek);
    }
    @Override
    public String dzwiek() {
        return "miau";
    }
}

class Krowa extends Zwierze {
    public Krowa(String imie, int wiek) {
        super(imie, wiek);
    }
    @Override
    public String dzwiek() {
        return "muuuuu";
    }
}
