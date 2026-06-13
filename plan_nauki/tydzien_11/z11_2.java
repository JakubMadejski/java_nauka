package plan_nauki.tydzien_11;

import java.util.Map;

// Z11.2 - MapObserver (z egzaminu 2023 i 2024 - DOKLADNIE TO)
// Co intervalMs ms sprawdza rozmiar mapy, jesli zmienil sie - wypisuje o ile
// Musi byc demonem: setDaemon(true)

public class z11_2 {
    public static void main(String[] args) throws InterruptedException {
        // TODO: stworz mape, uruchom MapObserver, dodaj/usun elementy
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
                // TODO: wypisz "Map zmienil rozmiar o: X" gdzie X = nowyRozmiar - ostatniRozmiar
                ostatniRozmiar = nowyRozmiar;
            }
        }
    }
}
