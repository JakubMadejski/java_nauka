package plan_nauki.tydzien_11;

import java.util.HashMap;
import java.util.Map;

// Z11.2 - MapObserver (z egzaminu 2023 i 2024 - DOKLADNIE TO)
// Co intervalMs ms sprawdza rozmiar mapy, jesli zmienil sie - wypisuje o ile
// Musi byc demonem: setDaemon(true)

public class z11_2 {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> mapa = new HashMap<>();
        MapObserver obserwator = new MapObserver(mapa, 500);
        obserwator.start();   // demon - zginie sam gdy main sie skonczy

        Thread.sleep(600);
        mapa.put("A", 1);          // rozmiar 0 -> 1, obserwator wypisze "+1"
        Thread.sleep(600);
        mapa.put("B", 2);
        mapa.put("C", 3);          // 1 -> 3, wypisze "+2"
        Thread.sleep(600);
        mapa.remove("A");          // 3 -> 2, wypisze "-1"
        Thread.sleep(600);
        System.out.println("Koniec main");
    }
}

class MapObserver extends Thread {
    private final Map<?, ?> mapa;
    private final long intervalMs;
    private int ostatniRozmiar;

    public MapObserver(Map<?, ?> mapa, long intervalMs) {
        this.mapa = mapa;
        this.intervalMs = intervalMs;
        this.ostatniRozmiar = mapa.size();
        setDaemon(true); // WAZNE: musi byc przed start()
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
