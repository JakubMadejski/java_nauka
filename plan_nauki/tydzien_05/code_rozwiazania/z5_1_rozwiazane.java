package plan_nauki.tydzien_05.code_rozwiazania;

public class z5_1_rozwiazane {
    public static void main(String[] args) {
        ZwierzeT5[] zwierzeta = {
            new PiesT5("Rex", 3),
            new KotT5("Mruczek", 5),
            new KrowaT5("Basia", 4)
        };
        for (ZwierzeT5 z : zwierzeta) {
            z.przedstawSie();
        }
    }
}

abstract class ZwierzeT5 {
    private final String imie;
    private final int wiek;

    public ZwierzeT5(String imie, int wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }

    public String getImie() { return imie; }
    public int getWiek()    { return wiek; }

    abstract String dzwiek();

    public void przedstawSie() {
        System.out.println("Jestem " + imie + ", mam " + wiek + " lat. Mowie: " + dzwiek());
    }
}

class PiesT5 extends ZwierzeT5 {
    public PiesT5(String imie, int wiek) { super(imie, wiek); }
    @Override String dzwiek() { return "Hau!"; }
}

class KotT5 extends ZwierzeT5 {
    public KotT5(String imie, int wiek) { super(imie, wiek); }
    @Override String dzwiek() { return "Miau!"; }
}

class KrowaT5 extends ZwierzeT5 {
    public KrowaT5(String imie, int wiek) { super(imie, wiek); }
    @Override String dzwiek() { return "Muuuu!"; }
}
