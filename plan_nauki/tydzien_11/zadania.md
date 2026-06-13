# Tydzien 11 - Zadania

## Z11.1 - Pierwszy watek
Napisz `LicznikWatek extends Thread` ktory co 500ms wypisuje "Tick: N" (N rosnie).
Uruchom, poczekaj 3 sekundy w main (Thread.sleep(3000)), zatrzymaj przez flage.

## Z11.2 - MapObserver (z egzaminu 2023 i 2024 - DOKLADNIE TO)
Napisz `MapObserver extends Thread`:
- Konstruktor: `Map<?, ?> mapa`, `long intervalMs`
- Co intervalMs ms sprawdza rozmiar mapy
- Jezeli zmienil sie - wypisuje "Map zmienil rozmiar o: X"
- Musi byc demonem

Test:
```java
Map<String, Integer> mapa = new HashMap<>();
new MapObserver(mapa, 1000).start();
Thread.sleep(500);
mapa.put("a", 1); mapa.put("b", 2);
Thread.sleep(1500);
mapa.remove("a");
Thread.sleep(1500);
```

## Z11.3 - Watek ze stosem (z egzaminu 2021 Grp A)
Interfejs `Stos { void put(Object x); }`.
Napisz `WatekDodajacy extends Thread`:
- Konstruktor: `Stos stos`, `long intervalMs`
- Co intervalMs ms dodaje losowe double do stosu
- Synchronized na stosie
- Demon

Napisz prosta `StosImpl implements Stos` (opakowuje ArrayList).
Przetestuj: 3 watki z tym samym stosem przez 3 sekundy.

## Z11.4 - Licznik thread-safe (z egzaminu 2024)
Napisz `Licznik`:
- Pole int wartosc = 0
- synchronized: zwieksz(), zmniejsz(), zeruj(), odczytaj()

Test: 50 watkow, kazdy wywoluje zwieksz() 1000 razy.
Po join() na wszystkich: wynik powinien byc dokladnie 50000.

## Sprawdzenie
1. Jaka jest roznica miedzy t.run() a t.start()?
2. Co to jest watek demon i kiedy JVM go zabija?
3. Dlaczego uzywamy `volatile` dla flagi running?
4. Jezeli 2 watki synchronizuja na ROZNYCH obiektach - czy to zapewnia bezpieczenstwo?
5. Co to jest race condition?
