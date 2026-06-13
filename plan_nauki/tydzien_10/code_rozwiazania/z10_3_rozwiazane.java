package plan_nauki.tydzien_10.code_rozwiazania;

public class z10_3_rozwiazane {
    public static void main(String[] args) {
        AutomatT10 a = new AutomatT10();

        a.wybierzNapoj("Cola");    // Bezczynny -> NapojWybrany
        a.wplacMonete(5.0);        // NapojWybrany -> GotowDoWydania
        a.anuluj();                // wydaje i wraca do Bezczynny

        System.out.println("---");

        a.wybierzNapoj("Woda");
        a.anuluj();                // anuluje wybor, wraca do Bezczynny

        System.out.println("---");

        a.wplacMonete(2.0);        // Bezczynny - blad, najpierw wybierz
    }
}

interface StanAutomatuT10 {
    void wybierzNapoj(AutomatT10 a, String napoj);
    void wplacMonete(AutomatT10 a, double kwota);
    void anuluj(AutomatT10 a);
}

class BezczynnyT10 implements StanAutomatuT10 {
    public void wybierzNapoj(AutomatT10 a, String napoj) {
        System.out.println("Wybrano: " + napoj);
        a.setNapoj(napoj);
        a.setStan(new NapojWybranyT10());
    }
    public void wplacMonete(AutomatT10 a, double k) { System.out.println("Najpierw wybierz napoj"); }
    public void anuluj(AutomatT10 a)                { System.out.println("Nic do anulowania"); }
}

class NapojWybranyT10 implements StanAutomatuT10 {
    public void wybierzNapoj(AutomatT10 a, String n) { System.out.println("Juz wybrales: " + a.getNapoj()); }
    public void wplacMonete(AutomatT10 a, double kwota) {
        System.out.println("Wplacono: " + kwota + " zl");
        a.setStan(new GotowDoWydaniaT10());
    }
    public void anuluj(AutomatT10 a) {
        System.out.println("Anulowano wybor " + a.getNapoj());
        a.setStan(new BezczynnyT10());
    }
}

class GotowDoWydaniaT10 implements StanAutomatuT10 {
    public void wybierzNapoj(AutomatT10 a, String n) { System.out.println("Czeka na odebranie"); }
    public void wplacMonete(AutomatT10 a, double k)  { System.out.println("Juz zaplacono"); }
    public void anuluj(AutomatT10 a) {
        System.out.println("Wydaje " + a.getNapoj() + ". Smacznego!");
        a.setStan(new BezczynnyT10());
    }
}

class AutomatT10 {
    private StanAutomatuT10 stan = new BezczynnyT10();
    private String napoj = "";

    public void wybierzNapoj(String n) { stan.wybierzNapoj(this, n); }
    public void wplacMonete(double k)  { stan.wplacMonete(this, k); }
    public void anuluj()               { stan.anuluj(this); }

    public void setStan(StanAutomatuT10 s) { this.stan = s; }
    public void setNapoj(String n)         { this.napoj = n; }
    public String getNapoj()               { return napoj; }
}
