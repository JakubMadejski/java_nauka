package plan_nauki.tydzien_04;

// Z4.3 - Klasa Koszyk (bez ArrayList, tylko tablice)
// Pola: String[] produkty, double[] ceny, int iloscPozycji (max 10)
// Metody: dodaj(String, double), suma(), wypisz(), toString()

public class z4_3 {
    public static void main(String[] args) {
        Koszyk a1 = new Koszyk();
        a1.dodaj("Chleb", 3.50);
        a1.dodaj("Mleko", 4.20);
        a1.dodaj("Jajka", 8.90);
        a1.wypisz();
        System.out.println("Suma: " + a1.suma());
        System.out.println(a1);
    }
}

class Koszyk {
    // TODO: pola, konstruktor, metody
    String[] produkty;
    double[] ceny;
    int iloscPozycji;
    public Koszyk() {
        this.produkty = new String[10];
        this.ceny = new double[10];
        this.iloscPozycji = 0;
    } 
    public void dodaj(String produkt, double cena) {
        if (iloscPozycji < 10) {
            produkty[iloscPozycji] = produkt;
            ceny[iloscPozycji] = cena;
            iloscPozycji++;
        }
    }
    public double suma() {
        double n = 0;
        for (int i = 0; i<iloscPozycji; i++) {
            n+= ceny[i];
        }
        return n;
    }
    public void wypisz() {
        System.out.println("Produkty: ");
        for (int i = 0; i<iloscPozycji; i++) {
            System.out.println( (i+1) + " " + produkty[i] + "Cena: " + ceny[i]);
        }
    }
    @Override
    public String toString() {
        return "Koszuk: " + iloscPozycji + " suma: " + suma();
    }
}
