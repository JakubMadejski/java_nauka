package plan_nauki.tydzien_06;
import java.util.ArrayList;

// Z6.5 - Sklep z Enum
// enum Kategoria { ELEKTRONIKA, ODZIEŻ, JEDZENIE, SPORT }
// klasa Produkt: nazwa, cena, kategoria
// Wypisz tylko produkty ELEKTRONIKA ponizej 500 zl

public class z6_5 {
    public static void main(String[] args) {
        // TODO: stworz liste 8 produktow z roznych kategorii, wyfiltruj i wypisz
        ArrayList<Produkt> a1 = new ArrayList<>();
        a1.add(new Produkt("Mysz", 100, Kategoria.ELEKTRONIKA));
        a1.add(new Produkt("Laptop", 2999, Kategoria.ELEKTRONIKA));
        a1.add(new Produkt("Telefon", 449, Kategoria.ELEKTRONIKA));
        a1.add(new Produkt("Kabel USB", 29, Kategoria.ELEKTRONIKA));
        a1.add(new Produkt("Koszula", 89, Kategoria.ODZIEŻ));
        a1.add(new Produkt("Chleb", 5, Kategoria.JEDZENIE));
        a1.add(new Produkt("Rower", 899, Kategoria.SPORT));
        a1.add(new Produkt("Buty", 299, Kategoria.SPORT));
        for (int i = 0; i < a1.size(); i++) {
            if (a1.get(i).getCena() < 500 && a1.get(i).getKategoria() == Kategoria.ELEKTRONIKA){
                System.out.println(a1.get(i));
            }
        }
    
    }
}

enum Kategoria {
    ELEKTRONIKA, ODZIEŻ, JEDZENIE, SPORT
}

class Produkt {
    // TODO: pola nazwa, cena, kategoria; konstruktor; toString
    private String nazwa;
    private double cena;
    private Kategoria kategoria;

    public Produkt(String nazwa, double cena, Kategoria kategoria) {
        this.nazwa= nazwa;
        this.cena= cena;
        this.kategoria = kategoria;
    }
    public double getCena() {
        return cena;
    }
    public String getNazwa() {
        return nazwa;
    }
    public Kategoria getKategoria() {
        return kategoria;
    }
    @Override 
    public String toString() {
        return "Ten produkt ma nazwe: "+nazwa+" oraz cene: "+cena+" i jest w kategori: "+kategoria;
    }

}
