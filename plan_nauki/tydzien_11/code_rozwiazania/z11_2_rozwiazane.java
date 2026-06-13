package plan_nauki.tydzien_11.code_rozwiazania;

import java.util.HashMap;
import java.util.Map;

public class z11_2_rozwiazane {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> mapa = new HashMap<>();
        MapObserverT11 observer = new MapObserverT11(mapa, 500);
        observer.start(); // setDaemon(true) wywolane w konstruktorze

        Thread.sleep(600);
        mapa.put("A", 1);
        Thread.sleep(600);
        mapa.put("B", 2);
        mapa.put("C", 3);
        Thread.sleep(600);
        mapa.remove("A");
        Thread.sleep(600);
    }
}

class MapObserverT11 extends Thread {
    private final Map<?, ?> mapa;
    private final long intervalMs;
    private int ostatniRozmiar;

    public MapObserverT11(Map<?, ?> mapa, long intervalMs) {
        this.mapa = mapa;
        this.intervalMs = intervalMs;
        this.ostatniRozmiar = mapa.size();
        setDaemon(true); // MUSI byc przed start()!
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(intervalMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            int nowyRozmiar = mapa.size();
            if (nowyRozmiar != ostatniRozmiar) {
                System.out.println("Mapa zmienila rozmiar o: " + (nowyRozmiar - ostatniRozmiar));
                ostatniRozmiar = nowyRozmiar;
            }
        }
    }
}
