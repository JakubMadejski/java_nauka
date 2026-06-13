package plan_nauki.tydzien_06.code_rozwiazania;

import java.util.ArrayList;
import java.util.List;

public class z6_5_rozwiazane {
    public static void main(String[] args) {
        List<ProduktT6> produkty = new ArrayList<>();
        produkty.add(new ProduktT6("Laptop", 2999.0, KategoriaT6.ELEKTRONIKA));
        produkty.add(new ProduktT6("Koszula", 89.0, KategoriaT6.ODZIEŻ));
        produkty.add(new ProduktT6("Telefon", 449.0, KategoriaT6.ELEKTRONIKA));
        produkty.add(new ProduktT6("Chleb", 5.0, KategoriaT6.JEDZENIE));
        produkty.add(new ProduktT6("Kabel USB", 29.0, KategoriaT6.ELEKTRONIKA));
        produkty.add(new ProduktT6("Rower", 899.0, KategoriaT6.SPORT));
        produkty.add(new ProduktT6("Sluchawki", 199.0, KategoriaT6.ELEKTRONIKA));
        produkty.add(new ProduktT6("Buty", 299.0, KategoriaT6.SPORT));

        System.out.println("Elektronika ponizej 500 zl:");
        for (ProduktT6 p : produkty) {
            if (p.getKategoria() == KategoriaT6.ELEKTRONIKA && p.getCena() < 500) {
                System.out.println("  " + p);
            }
        }
    }
}

enum KategoriaT6 {
    ELEKTRONIKA, ODZIEŻ, JEDZENIE, SPORT
}

class ProduktT6 {
    private final String nazwa;
    private final double cena;
    private final KategoriaT6 kategoria;

    public ProduktT6(String nazwa, double cena, KategoriaT6 kategoria) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.kategoria = kategoria;
    }

    public String getNazwa()        { return nazwa; }
    public double getCena()         { return cena; }
    public KategoriaT6 getKategoria() { return kategoria; }

    @Override
    public String toString() {
        return String.format("%-15s %8.2f zl [%s]", nazwa, cena, kategoria);
    }
}
