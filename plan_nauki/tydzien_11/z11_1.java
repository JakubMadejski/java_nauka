package plan_nauki.tydzien_11;

// Z11.1 - Pierwszy watek
// LicznikWatek co 500ms wypisuje "Tick: N" (N rosnie)
// Zatrzymaj przez flage volatile po 3 sekundach

public class z11_1 {
    public static void main(String[] args) throws InterruptedException {
        LicznikWatek w = new LicznikWatek();
        w.start();
        Thread.sleep(3000);
        w.zatrzymaj();
    }
}

class LicznikWatek extends Thread {
    private volatile boolean running = true;

    @Override
    public void run() {
        int n = 1;
        while (running) {
            System.out.println("Tick: " + n++); // TODO: dodaj sleep(500)
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void zatrzymaj() {
        running = false;
    }
}
