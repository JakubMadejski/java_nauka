package plan_nauki.tydzien_11.code_rozwiazania;

import java.util.ArrayList;
import java.util.Random;

public class z11_3_rozwiazane {
    public static void main(String[] args) throws InterruptedException {
        StosT11 stos = new StosImplT11();
        WatekDodajacyT11 w1 = new WatekDodajacyT11(stos, 200);
        WatekDodajacyT11 w2 = new WatekDodajacyT11(stos, 300);
        WatekDodajacyT11 w3 = new WatekDodajacyT11(stos, 150);
        w1.start(); w2.start(); w3.start();

        Thread.sleep(3000);
        System.out.println("Elementow w stosie: " + stos.rozmiar());
    }
}

interface StosT11 {
    void put(Object x);
    int rozmiar();
}

class StosImplT11 implements StosT11 {
    private final ArrayList<Object> lista = new ArrayList<>();

    public void put(Object x) { lista.add(x); }
    public int rozmiar()      { return lista.size(); }
}

class WatekDodajacyT11 extends Thread {
    private final StosT11 stos;
    private final long intervalMs;
    private volatile boolean running = true;

    public WatekDodajacyT11(StosT11 stos, long intervalMs) {
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
                // synchronizujemy na stos bo to wspolny zasob - nie na this!
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
