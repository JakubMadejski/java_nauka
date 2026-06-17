package plan_nauki.tydzien_10;

// Z10.2 - Gracz ze statusami (z egzaminu 2021 Grp A)
// Statusy: Aktywny, Ranny, Spiacy
// Ranny: wolny ruch, brak skoku, slaby cios; po ciosie -> Aktywny
// Spiacy: wszystko zablokowane; po 2x ruch() budzi sie

public class z10_2 {
    public static void main(String[] args) {
        Gracz g = new Gracz("Bohater");

        System.out.println("--- Start: Aktywny ---");
        g.ruch();   // Biega szybko
        g.skok();   // Skacze wysoko
        g.cios();   // Pelny cios! -> przechodzi w Ranny

        System.out.println("--- Teraz: Ranny ---");
        g.ruch();   // Kuleje
        g.skok();   // Nie moze skoczyc
        g.cios();   // Slaby cios -> wraca do Aktywny

        System.out.println("--- Znowu Aktywny ---");
        g.ruch();   // Biega szybko

        System.out.println("--- Zasypia ---");
        g.setStatus(new Spiacy());
        g.skok();   // Gracz spi
        g.ruch();   // spi... (1/2)
        g.ruch();   // spi... (2/2) -> budzi sie, Aktywny
        g.ruch();   // Biega szybko (juz obudzony)
    }
}

interface StatusGracza {
    void ruch(Gracz gracz);
    void skok(Gracz gracz);
    void cios(Gracz gracz);
}

class Aktywny implements StatusGracza {
    public void ruch(Gracz g)  { System.out.println("Biega szybko"); }
    public void skok(Gracz g)  { System.out.println("Skacze wysoko"); }
    public void cios(Gracz g)  {
        System.out.println("Pelny cios!");
        g.setStatus(new Ranny()); // TODO: zmiana stanu
    }
}

class Ranny implements StatusGracza {
    public void ruch(Gracz g)  { System.out.println("Kuleje"); }
    public void skok(Gracz g)  { System.out.println("Nie moze skoczyc"); }
    public void cios(Gracz g)  {
        System.out.println("Slaby cios");
        g.setStatus(new Aktywny()); // TODO: po ciosie wraca do Aktywny
    }
}

class Spiacy implements StatusGracza {
    private int liczbaRuchow = 0;

    public void ruch(Gracz g) {
        liczbaRuchow++;
        System.out.println("Gracz spi... (" + liczbaRuchow + "/2)");
        if (liczbaRuchow >= 2) g.setStatus(new Aktywny()); // TODO: po 2x budzi sie
    }
    public void skok(Gracz g)  { System.out.println("Gracz spi"); }
    public void cios(Gracz g)  { System.out.println("Gracz spi"); }
}

class Gracz {
    private final String imie;
    private StatusGracza status;

    public Gracz(String imie) {
        this.imie = imie;
        this.status = new Aktywny();
    }

    public void ruch() { status.ruch(this); }
    public void skok() { status.skok(this); }
    public void cios() { status.cios(this); }

    public void setStatus(StatusGracza s) { this.status = s; }
    public String getImie() { return imie; }
}
