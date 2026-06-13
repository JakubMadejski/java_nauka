package plan_nauki.tydzien_11;

// Z11.4 - Licznik thread-safe (z egzaminu 2024)
// 50 watkow x 1000 razy zwieksz() = wynik musi byc dokladnie 50000
// Bez synchronized wynik bedzie losowy i mniejszy

public class z11_4 {
    public static void main(String[] args) throws InterruptedException {
        LicznikTS licznik = new LicznikTS();
        Thread[] watki = new Thread[50];

        for (int i = 0; i < 50; i++) {
            watki[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    licznik.zwieksz();
                }
            });
            watki[i].start();
        }

        for (Thread w : watki) w.join();
        System.out.println("Wynik: " + licznik.odczytaj()); // powinno byc 50000
    }
}

class LicznikTS {
    private int wartosc = 0;

    public synchronized void zwieksz()  { wartosc++; }
    public synchronized void zmniejsz() { wartosc--; }
    public synchronized void zeruj()    { wartosc = 0; }
    public synchronized int odczytaj()  { return wartosc; }
}
