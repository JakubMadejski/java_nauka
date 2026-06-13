package plan_nauki.tydzien_05.code_rozwiazania;

public class z5_2_rozwiazane {
    public static void main(String[] args) {
        PojazdT5[] pojazdy = {
            new SamochodT5("Toyota", 2020, 5),
            new RowerT5("Trek", 2019, true),
            new MotorT5("Yamaha", 2021)
        };
        for (PojazdT5 p : pojazdy) {
            System.out.println(p);
        }
    }
}

abstract class PojazdT5 {
    protected final String marka;
    protected final int rok;

    public PojazdT5(String marka, int rok) {
        this.marka = marka;
        this.rok = rok;
    }

    abstract String typPojazdu();

    public String opis() {
        return typPojazdu() + " " + marka + " (" + rok + ")";
    }

    @Override
    public String toString() { return opis(); }
}

class SamochodT5 extends PojazdT5 {
    private final int liczbaDrzwi;

    public SamochodT5(String marka, int rok, int liczbaDrzwi) {
        super(marka, rok);
        this.liczbaDrzwi = liczbaDrzwi;
    }

    @Override String typPojazdu() { return "Samochod"; }

    @Override
    public String toString() { return opis() + ", drzwi: " + liczbaDrzwi; }
}

class RowerT5 extends PojazdT5 {
    private final boolean maGlosnik;

    public RowerT5(String marka, int rok, boolean maGlosnik) {
        super(marka, rok);
        this.maGlosnik = maGlosnik;
    }

    @Override String typPojazdu() { return "Rower"; }

    @Override
    public String toString() { return opis() + ", glosnik: " + maGlosnik; }
}

class MotorT5 extends PojazdT5 {
    public MotorT5(String marka, int rok) { super(marka, rok); }
    @Override String typPojazdu() { return "Motor"; }
}
