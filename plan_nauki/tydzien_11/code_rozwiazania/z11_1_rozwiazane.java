package plan_nauki.tydzien_11.code_rozwiazania;

public class z11_1_rozwiazane {
    public static void main(String[] args) throws InterruptedException {
        LicznikWatekT11 w = new LicznikWatekT11();
        w.start();
        Thread.sleep(3000);
        w.zatrzymaj();
        System.out.println("Watek zatrzymany");
    }
}

class LicznikWatekT11 extends Thread {
    private volatile boolean running = true; // volatile - widoczne z innego watku

    @Override
    public void run() {
        int n = 1;
        while (running) {
            System.out.println("Tick: " + n++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void zatrzymaj() {
        running = false; // bezpieczne - volatile
    }
}
