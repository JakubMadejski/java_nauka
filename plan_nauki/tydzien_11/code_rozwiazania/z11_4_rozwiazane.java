package plan_nauki.tydzien_11.code_rozwiazania;

public class z11_4_rozwiazane {
    public static void main(String[] args) throws InterruptedException {
        LicznikTST11 licznik = new LicznikTST11();
        Thread[] watki = new Thread[50];

        for (int i = 0; i < 50; i++) {
            watki[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    licznik.zwieksz();
                }
            });
            watki[i].start();
        }

        for (Thread w : watki) w.join(); // poczekaj az wszystkie skonczą

        System.out.println("Wynik: " + licznik.odczytaj()); // musi byc 50000
        System.out.println("Poprawny: " + (licznik.odczytaj() == 50000));
    }
}

class LicznikTST11 {
    private int wartosc = 0;

    // synchronized - tylko jeden watek naraz moze wywolac te metode
    public synchronized void zwieksz()  { wartosc++; }
    public synchronized void zmniejsz() { wartosc--; }
    public synchronized void zeruj()    { wartosc = 0; }
    public synchronized int odczytaj()  { return wartosc; }
}
