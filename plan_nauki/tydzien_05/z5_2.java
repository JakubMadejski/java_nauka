package plan_nauki.tydzien_05;

// Z5.2 - Hierarchia pojazdow
// abstract Pojazd: marka, rok, abstract typPojazdu(), opis()
// Podklasy: Samochod (liczbaDrzwi), Rower (maGlosnik boolean), Motor
// Kazda: typPojazdu() + toString()

public class z5_2 {
    public static void main(String[] args) {
        Pojazd[] pojazdy = {
            new Samochod("Toyota", 2020, 5),
            new Rower("Trek", 2019, true),
            new Motor("Yamaha", 2021)
        };
        for (Pojazd p : pojazdy) {
            System.out.println(p.opis());   // uzywa typPojazdu() + marka + rok
            System.out.println(p);          // wola toString()
        }
    }
}

abstract class Pojazd {
    private String marka;
    private int rok;

    public Pojazd(String marka, int rok) {
        this.marka = marka;
        this.rok = rok;
    }
    public abstract String typPojazdu();

    public String opis() {
        return typPojazdu() + " " + marka + " z roku " + rok;
    }
}

class Samochod extends Pojazd {
    // TODO
    private int liczbaDrzwi;
    public Samochod(String marka, int rok, int n) {
        super(marka, rok);
        this.liczbaDrzwi = n;
    }
    @Override
    public String typPojazdu() { 
        return "Samochod";
    }
    @Override
    public String toString() {
        return "Prowadze "+typPojazdu();
    }
}

class Rower extends Pojazd {
    // TODO
    private boolean maGlosnik;
    public Rower(String marka, int rok, boolean n) {
        super(marka, rok);
        this.maGlosnik = n;
    }
    @Override
    public String typPojazdu() { 
        return "Rower";
    }
    @Override
    public String toString() {
        return "Prowadze "+typPojazdu();
    }
}

class Motor extends Pojazd {
    // TODO
    public Motor(String marka, int rok) {
        super(marka, rok);
    }
    @Override
    public String typPojazdu() {
        return "Motor";
    }
    @Override
    public String toString() {
        return "Prowadze "+typPojazdu();
    }
}

