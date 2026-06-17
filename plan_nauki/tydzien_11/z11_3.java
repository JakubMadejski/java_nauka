package plan_nauki.tydzien_11;

import java.util.ArrayList;
import java.util.Random;

// Z11.3 - Watek ze stosem (z egzaminu 2021 Grp A)
// Stos nie jest thread-safe - uzyj synchronized(stos) {}
// WatekDodajacy co intervalMs ms dodaje losowe double

public class z11_3 {
    public static void main(String[] args) throws InterruptedException {
        StosImpl stos = new StosImpl();
        WatekDodajacy w1 = new WatekDodajacy(stos, 200);
        WatekDodajacy w2 = new WatekDodajacy(stos, 300);
        WatekDodajacy w3 = new WatekDodajacy(stos, 150);
        w1.start(); w2.start(); w3.start();
        Thread.sleep(3000);
        System.out.println("Elementow w stosie: " + stos.rozmiar());
    }
}

interface Stos {
    void put(Object x);
}

class StosImpl implements Stos {
    private final ArrayList<Object> lista = new ArrayList<>();

    public void put(Object x) { lista.add(x); }
    public int rozmiar()      { return lista.size(); }
}

class WatekDodajacy extends Thread {
    private final Stos stos;
    private final long intervalMs;
    private volatile boolean running = true;

    public WatekDodajacy(Stos stos, long intervalMs) {
        this.stos = stos;
        this.intervalMs = intervalMs;
        setDaemon(true);
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (running) {
            double liczba = rand.nextDouble();
            synchronized (stos) {
                // synchronizujemy na STOS (wspolny zasob), nie na this:
                // kazdy watek to inny obiekt, wiec zamek na this nie blokowalby pozostalych
                stos.put(liczba);
            }
            try {
                Thread.sleep(intervalMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
