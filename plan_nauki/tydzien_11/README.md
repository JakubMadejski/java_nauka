# Tydzien 11: Watki i synchronizacja

## Na egzaminach 2021, 2023, 2024 - zawsze podobny schemat.

---

## 1. Jak stworzyc watek

**Sposob 1: extends Thread**
```java
public class MojWatek extends Thread {
    @Override
    public void run() {
        System.out.println("Watek dziala w tle!");
    }
}

MojWatek w = new MojWatek();
w.start();   // NIE wywoluj run() bezposrednio - to nie tworzy nowego watku!
```

**Sposob 2: implements Runnable (lepszy)**
```java
public class MojeZadanie implements Runnable {
    @Override
    public void run() {
        System.out.println("Zadanie dziala!");
    }
}

Thread t = new Thread(new MojeZadanie());
t.start();
```

---

## 2. Zatrzymywanie watku - flaga volatile

```java
public class PeriodicTask extends Thread {

    private volatile boolean running = true;
    // volatile = zmienna jest widoczna natychmiast dla wszystkich watkow

    @Override
    public void run() {
        while (running) {
            System.out.println("Pracuje...");
            try {
                Thread.sleep(1000);   // czekaj 1 sekunde
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
```

---

## 3. Watek demon (daemon thread)

Watek demon to watek "tla". JVM go automatycznie zabija gdy konca sie wszystkie watki glowne.

```java
Thread t = new Thread(zadanie);
t.setDaemon(true);   // MUSI byc przed start()!
t.start();
```

Na egzaminie 2023 i 2024: "Watek ma byc demonem" - zawsze setDaemon(true).

---

## 4. Synchronizacja - problem i rozwiazanie

**Problem**: kilka watkow naraz modyfikuje te sama zmienna -> nieprzewidywalne wyniki.

```java
// PROBLEM - race condition:
public class Licznik {
    private int wartosc = 0;

    public void zwieksz() {
        wartosc++;   // to sa 3 operacje CPU! (czytaj, dodaj, zapisz)
        // wiele watkow moze czytac te sama stara wartosc i nadpisywac sie nawzajem
    }
}
```

**Rozwiazanie**: `synchronized`

```java
// NAPRAWIONE:
public class Licznik {
    private int wartosc = 0;

    public synchronized void zwieksz() {
        wartosc++;   // tylko jeden watek na raz moze tu byc
    }

    public synchronized int odczytaj() {
        return wartosc;
    }
}
```

---

## 5. synchronized na zewnetrznym obiekcie (z egzaminu 2021)

Z egzaminu: "Stos nie jest thread-safe. Napisz watek ktory go bezpiecznie uzywa."

```java
public interface Stos {
    void put(Object x);   // nie thread-safe!
}

public class WatekDodajacy extends Thread {

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
        java.util.Random rand = new java.util.Random();
        while (running) {
            double liczba = rand.nextDouble();

            synchronized (stos) {   // blokujemy NA SAMYM STOSIE
                stos.put(liczba);   // teraz tylko jeden watek na raz
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
```

Kluczowe: **wszystkie watki musza synchronizowac na TYM SAMYM obiekcie!**

---

## 6. Watek obserwujacy Map (egzamin 2023 i 2024)

```java
import java.util.Map;

public class MapObserver extends Thread {

    private final Map<?, ?> mapa;
    private final long intervalMs;
    private int ostatniRozmiar;

    public MapObserver(Map<?, ?> mapa, long intervalMs) {
        this.mapa = mapa;
        this.intervalMs = intervalMs;
        this.ostatniRozmiar = mapa.size();
        setDaemon(true);   // musi byc demonem
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
                System.out.println("Map zmienil rozmiar o: "
                    + (nowyRozmiar - ostatniRozmiar));
                ostatniRozmiar = nowyRozmiar;
            }
        }
    }
}
```

---

## 7. join() - czekanie na zakonczenie watku

```java
Thread t = new Thread(() -> {
    // dlugie zadanie
});
t.start();
t.join();   // glowny watek czeka az t sie skonczy
System.out.println("Watek t zakonczyl prace");
```

---

## ZADANIA

Zadania sa w [zadania.md](zadania.md).
