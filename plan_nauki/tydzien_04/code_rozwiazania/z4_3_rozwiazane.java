package plan_nauki.tydzien_04.code_rozwiazania;

public class z4_3_rozwiazane {
    public static void main(String[] args) {
        KoszykT4 koszyk = new KoszykT4();
        koszyk.dodaj("Chleb", 3.50);
        koszyk.dodaj("Mleko", 4.20);
        koszyk.dodaj("Jajka", 8.90);
        koszyk.wypisz();
        System.out.printf("Suma: %.2f zl%n", koszyk.suma());
    }
}

class KoszykT4 {
    private final String[] produkty = new String[10];
    private final double[] ceny = new double[10];
    private int iloscPozycji = 0;

    public void dodaj(String produkt, double cena) {
        if (iloscPozycji >= 10) {
            System.out.println("Koszyk pelny!");
            return;
        }
        produkty[iloscPozycji] = produkt;
        ceny[iloscPozycji] = cena;
        iloscPozycji++;
    }

    public double suma() {
        double suma = 0;
        for (int i = 0; i < iloscPozycji; i++) suma += ceny[i];
        return suma;
    }

    public void wypisz() {
        for (int i = 0; i < iloscPozycji; i++) {
            System.out.printf("%-15s %.2f zl%n", produkty[i], ceny[i]);
        }
    }

    @Override
    public String toString() {
        return "Koszyk[" + iloscPozycji + " pozycji, suma=" + suma() + "]";
    }
}
