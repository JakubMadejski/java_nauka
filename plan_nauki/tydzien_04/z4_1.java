package plan_nauki.tydzien_04;

// Z4.1 - Klasa Prostokat
// Pola private: szerokosc, wysokosc
// Konstruktor (sprawdz > 0), gettery, pole(), obwod(), toString()

public class z4_1 {
    public static void main(String[] args) {
        Prostokat nr1 = new Prostokat(10,290);
        Prostokat nr2 = new Prostokat(-10,290);
        System.out.println(nr1.getSzerokosc());
        System.out.println(nr1.getWysokosc());
        System.out.println(nr2.getSzerokosc());
        System.out.println(nr1.pole());
        System.out.println(nr1.obwod());
        System.out.println(nr1);
    }
}

class Prostokat {
    // TODO: dodaj pola, konstruktor, metody
    private int szerokosc;
    private int wysokosc;

    public Prostokat(int szerokosc, int wysokosc) {
        if (szerokosc > 0 && wysokosc > 0) {
            this.szerokosc = szerokosc;
            this.wysokosc = wysokosc;
        } else {
            System.out.println("Bład zla wysoksoc lub szeerokosc ma byc wiecej niz 0");
        }
    }
    public int getSzerokosc() {
        return szerokosc;
    }
    public int getWysokosc() {
        return wysokosc;
    }
    public double pole() {
        return szerokosc * wysokosc;
    }
    public double obwod() {
        return 2 * (szerokosc + wysokosc);
    }
    @Override
    public String toString() { 
        return "Prostokat ma wymiary" + szerokosc + "x" + wysokosc;
    }
}

