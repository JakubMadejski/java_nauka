package plan_nauki.tydzien_10;

// Z10.3 - Automat z napojami
// Stany: Bezczynny, NapojWybrany, GotowDoWydania
// Przejscia: Bezczynny --wybierz--> NapojWybrany --wplac--> GotowDoWydania

public class z10_3 {
    public static void main(String[] args) {
        Automat a = new Automat();

        System.out.println("--- Poprawny scenariusz ---");
        a.wybierzNapoj("Cola");   // Bezczynny -> NapojWybrany
        a.wplacMonete(5.0);       // NapojWybrany -> GotowDoWydania
        a.anuluj();               // wydaje napoj i wraca do Bezczynny

        System.out.println("--- Proba zlej kolejnosci ---");
        a.wplacMonete(2.0);       // Bezczynny - "Najpierw wybierz napoj"
        a.wybierzNapoj("Woda");   // Bezczynny -> NapojWybrany
        a.wybierzNapoj("Sok");    // NapojWybrany - "Juz wybrales"
        a.anuluj();               // anuluje wybor, wraca do Bezczynny
    }
}

interface StanAutomatu {
    void wybierzNapoj(Automat a, String napoj);
    void wplacMonete(Automat a, double kwota);
    void anuluj(Automat a);
}

class Bezczynny implements StanAutomatu {
    public void wybierzNapoj(Automat a, String napoj) {
        System.out.println("Wybrano: " + napoj);
        a.setNapoj(napoj);
        a.setStan(new NapojWybrany()); // TODO: przejdz do nastepnego stanu
    }
    public void wplacMonete(Automat a, double k) { System.out.println("Najpierw wybierz napoj"); }
    public void anuluj(Automat a)                { System.out.println("Nic do anulowania"); }
}

class NapojWybrany implements StanAutomatu {
    public void wybierzNapoj(Automat a, String n) { System.out.println("Juz wybrales"); }
    public void wplacMonete(Automat a, double kwota) {
        System.out.println("Wplacono: " + kwota);
        a.setStan(new GotowDoWydania()); // TODO: przejdz dalej
    }
    public void anuluj(Automat a) {
        System.out.println("Anulowano");
        a.setStan(new Bezczynny());
    }
}

class GotowDoWydania implements StanAutomatu {
    public void wybierzNapoj(Automat a, String n) { System.out.println("Czeka na odebranie"); }
    public void wplacMonete(Automat a, double k)  { System.out.println("Juz zaplacono"); }
    public void anuluj(Automat a) {
        System.out.println("Wydaje " + a.getNapoj() + " i zwracam monete");
        a.setStan(new Bezczynny());
    }
}

class Automat {
    private StanAutomatu stan = new Bezczynny();
    private String napoj = "";

    public void wybierzNapoj(String n) { stan.wybierzNapoj(this, n); }
    public void wplacMonete(double k)  { stan.wplacMonete(this, k); }
    public void anuluj()               { stan.anuluj(this); }

    public void setStan(StanAutomatu s) { this.stan = s; }
    public void setNapoj(String n)      { this.napoj = n; }
    public String getNapoj()            { return napoj; }
}
