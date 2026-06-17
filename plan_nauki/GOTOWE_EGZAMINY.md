# Gotowe wzory egzaminacyjne (tydzien 1-11)

Te wzory POWTARZAJA sie na egzaminach JiMP2 (2019-2025). Naucz sie ich na pamiec -
to sa pewne punkty. Gdy na egzaminie zobaczysz dany typ zadania, odtworz wzor stad.

Spis:
1. Klasa z equals + hashCode + compareTo + toString (FUNDAMENT ~20 pkt)
2. Wlasna kolekcja generyczna z Iterable<T>
3. Zbior z equals calosci (kolejnosc bez znaczenia)
4. Wlasny wyjatek z danymi
5. Wyjatek niosacy kolekcje (throw this)
6. Lancuch wyjatkow (cause)
7. Sortowanie: Comparable vs Comparator (lambda)
8. Wzorzec State - zamiana switch na klasy stanow (egzamin 2021, 2025)
9. Watki: licznik synchronized, obserwator Map (demon), watek + wspolny zasob
10. Swing: Observer (Listener) + Command (egzamin 2025) - RZADKIE, dla pewnosci

---

## WZOR 1: Klasa z equals + hashCode + compareTo + toString (FUNDAMENT)

**Kiedy:** "Napisz klase Uczen/Student/Produkt z polami..., posortuj liste, porownaj obiekty."
Pojawia sie PRAWIE ZAWSZE. Egzamin 2021 = 20 pkt.

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

class Uczen implements Comparable<Uczen> {
    private final String imie;
    private final String nazwisko;
    private final double srednia;

    public Uczen(String imie, String nazwisko, double srednia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.srednia = srednia;
    }

    public String getImie()     { return imie; }
    public String getNazwisko() { return nazwisko; }
    public double getSrednia()  { return srednia; }

    // sortowanie: tu MALEJACO po sredniej (other przed this)
    @Override
    public int compareTo(Uczen other) {
        return Double.compare(other.srednia, this.srednia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Uczen)) return false;
        Uczen u = (Uczen) o;
        return Double.compare(srednia, u.srednia) == 0
            && Objects.equals(imie, u.imie)
            && Objects.equals(nazwisko, u.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, srednia);
    }

    @Override
    public String toString() {
        return nazwisko + " " + imie + " (srednia: " + srednia + ")";
    }
}

// uzycie:
ArrayList<Uczen> lista = new ArrayList<>();
lista.add(new Uczen("Anna", "Kowalska", 4.5));
Collections.sort(lista);            // uzywa compareTo
for (Uczen u : lista) System.out.println(u);
```

**Pulapki:**
- `equals(Object o)` - ZAWSZE Object, nie nazwa klasy
- equals + hashCode z TYCH SAMYCH pol
- Stringi -> `Objects.equals(a,b)`, double -> `Double.compare(a,b)==0`, int -> `==`
- compareTo: rosnaco `Double.compare(this, other)`, malejaco `Double.compare(other, this)`

---

## WZOR 2: Wlasna kolekcja generyczna z Iterable<T>

**Kiedy:** "Napisz wlasna liste/zbior <T>, iterowalny (dziala w for-each)."
Pojawia sie na KAZDYM egzaminie.

```java
import java.util.Iterator;

class MojaLista<T> implements Iterable<T> {
    private Object[] dane = new Object[100];   // w srodku ZAWSZE Object[]
    private int rozmiar = 0;

    public void dodaj(T x) {
        dane[rozmiar] = x;
        rozmiar++;
    }

    public void usun(T x) {
        for (int i = 0; i < rozmiar; i++) {
            if (dane[i].equals(x)) {            // obiekty -> equals, NIE ==
                for (int j = i; j < rozmiar - 1; j++) {
                    dane[j] = dane[j + 1];      // przesun reszte w lewo
                }
                dane[rozmiar - 1] = null;
                rozmiar--;
                return;
            }
        }
    }

    public int rozmiar() { return rozmiar; }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int idx = 0;
            public boolean hasNext() { return idx < rozmiar; }
            @SuppressWarnings("unchecked")
            public T next() { return (T) dane[idx++]; }
        };
    }

    @Override
    public String toString() {
        String wynik = "[";
        for (int i = 0; i < rozmiar; i++) {
            if (i > 0) wynik = wynik + ", ";
            wynik = wynik + dane[i];
        }
        return wynik + "]";
    }
}
```

**Pulapki:**
- `implements Iterable<T>` wymaga metody `iterator()`
- iterator ma `hasNext()` (czy jest nastepny) i `next()` (daj i przesun)
- tablica w srodku to `Object[]`, w `next()` rzutujesz na `(T)` z `@SuppressWarnings("unchecked")`
- usun: szukaj przez `.equals()`, przesun w lewo, NIE zapomnij `rozmiar--`
- iterujesz tylko do `rozmiar`, nie po calej tablicy (100)

---

## WZOR 3: Zbior z equals calosci (kolejnosc bez znaczenia)

**Kiedy:** "Zbior unikalny / SparseVector - dodaj ignoruje duplikaty, equals porownuje
zawartosc, kolejnosc bez znaczenia." Egzamin 2024/2025.

```java
import java.util.HashSet;
import java.util.Iterator;

class ZbiorUnikalny<T> implements Iterable<T> {
    private Object[] dane = new Object[100];
    private int rozmiar = 0;

    public void dodaj(T x) {
        if (x == null) throw new IllegalArgumentException("Nie mozna dodac null");
        for (int i = 0; i < rozmiar; i++) {
            if (dane[i].equals(x)) return;     // duplikat - ignoruj
        }
        dane[rozmiar++] = x;
    }

    public T usun(T x) {                        // zwraca usuniety lub null
        for (int i = 0; i < rozmiar; i++) {
            if (dane[i].equals(x)) {
                @SuppressWarnings("unchecked")
                T usuniety = (T) dane[i];
                for (int j = i; j < rozmiar - 1; j++) dane[j] = dane[j + 1];
                dane[--rozmiar] = null;
                return usuniety;
            }
        }
        return null;
    }

    public int rozmiar() { return rozmiar; }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int idx = 0;
            public boolean hasNext() { return idx < rozmiar; }
            @SuppressWarnings("unchecked")
            public T next() { return (T) dane[idx++]; }
        };
    }

    // equals: true gdy o jest Iterable z TYMI SAMYMI elementami (kolejnosc nievazna)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Iterable)) return false;
        HashSet<Object> moj = new HashSet<>();
        for (T x : this) moj.add(x);
        HashSet<Object> inny = new HashSet<>();
        for (Object x : (Iterable<?>) o) inny.add(x);
        return moj.equals(inny);               // porownanie zawartosci, NIE hashCode
    }

    // hashCode: suma hashCode elementow (kolejnosc nievazna)
    @Override
    public int hashCode() {
        int sum = 0;
        for (int i = 0; i < rozmiar; i++) sum += dane[i].hashCode();
        return sum;
    }
}
```

**Pulapki:**
- equals przez HashSet (Set ignoruje kolejnosc i duplikaty) - NIE przez porownanie hashCode!
- `(Iterable<?>) o` - bo `o` to Object, rzutujesz zeby iterowac; `<?>` = "Iterable czegokolwiek"
- hashCode: `dane[i].hashCode()` (NIE `Objects.hash(dane[i])` - to dodaje zbedne 31)
- suma jest niezalezna od kolejnosci -> rowne zbiory daja rowny hashCode

---

## WZOR 4: Wlasny wyjatek z danymi

**Kiedy:** "Stworz wyjatek X przechowujacy informacje o ... (numer linii, nazwa pliku...)."
Egzamin 2021. Wyjatek to ZWYKLA KLASA + `extends RuntimeException`.

```java
class NieprawidlowaLiniaWyjatek extends RuntimeException {
    private final String nazwaPliku;
    private final int numerLinii;
    private final String zawartosc;

    public NieprawidlowaLiniaWyjatek(String nazwaPliku, int numerLinii, String zawartosc) {
        super("Nieprawidlowa linia " + numerLinii + " w pliku '" + nazwaPliku + "': " + zawartosc);
        this.nazwaPliku = nazwaPliku;
        this.numerLinii = numerLinii;
        this.zawartosc = zawartosc;
    }

    public String getNazwaPliku() { return nazwaPliku; }
    public int getNumerLinii()    { return numerLinii; }
    public String getZawartosc()  { return zawartosc; }
}

// uzycie:
try {
    throw new NieprawidlowaLiniaWyjatek("dane.csv", 42, "abc;;xyz");
} catch (NieprawidlowaLiniaWyjatek e) {
    System.out.println(e.getMessage());        // ladny tekst
    System.out.println(e.getNumerLinii());     // surowa dana - do uzycia w kodzie
}
```

**Pulapki:**
- `extends RuntimeException`
- pola `private final` + konstruktor + gettery (jak zwykla klasa!)
- `super("komunikat...")` w 1. linii konstruktora - dzieki temu dziala `getMessage()`
- rzucasz przez `throw new ...`, NIE `return`

---

## WZOR 5: Wyjatek niosacy kolekcje (throw this)

**Kiedy:** "Metoda kolekcji rzuca wyjatek gdy elementu brak, przekazujac cala kolekcje."
Egzamin 2024/2025. Laczy kolekcje (wzor 2/3) z wyjatkiem (wzor 4).

```java
class BrakElementuWyjatek extends RuntimeException {
    private final Iterable<?> zawartosc;       // wyjatek niesie CALA kolekcje

    public BrakElementuWyjatek(String message, Iterable<?> zawartosc) {
        super(message);
        this.zawartosc = zawartosc;
    }

    public Iterable<?> getZawartosc() { return zawartosc; }
}

// w metodzie usun() kolekcji, gdy nie znaleziono:
public T usun(T x) {
    for (int i = 0; i < rozmiar; i++) {
        if (dane[i].equals(x)) { /* ...usun i zwroc... */ }
    }
    throw new BrakElementuWyjatek("Brak elementu: " + x, this);  // przekaz this!
}

// uzycie:
try {
    zbior.usun("X");
} catch (BrakElementuWyjatek e) {
    System.out.println(e.getMessage());
    for (Object o : e.getZawartosc()) System.out.print(o + " ");  // co bylo w zbiorze
}
```

**Pulapki:**
- wyjatek trzyma `Iterable<?>` (nie wiadomo jaki typ w kolekcji)
- `throw new ...(..., this)` - `this` = sama kolekcja, daje kontekst bledu
- `getZawartosc()` zwraca cos po czym mozna iterowac (for-each)

---

## WZOR 6: Lancuch wyjatkow (cause)

**Kiedy:** "Opakuj jeden wyjatek w drugi (zachowaj przyczyne)."

```java
class PrzetwarzanieWyjatek extends RuntimeException {
    public PrzetwarzanieWyjatek(String message, Throwable cause) {
        super(message, cause);     // cause = oryginalny wyjatek, getCause() go zwroci
    }
}

static void przetwarzaj() {
    try {
        throw new java.io.IOException("brak pliku");
    } catch (java.io.IOException e) {
        throw new PrzetwarzanieWyjatek("Blad przetwarzania", e);  // opakuj e jako cause
    }
}

// uzycie:
try {
    przetwarzaj();
} catch (PrzetwarzanieWyjatek e) {
    System.out.println("Blad: " + e.getMessage());
    System.out.println("Przyczyna: " + e.getCause().getMessage());  // brak pliku
}
```

**Pulapki:**
- konstruktor `super(message, cause)` - dwa argumenty
- `getCause()` zwraca oryginalny (opakowany) wyjatek
- przydatne gdy lapiesz niski blad i rzucasz wyzszy, nie tracac informacji

---

## WZOR 7: Sortowanie - Comparable vs Comparator

**Comparable** = jeden naturalny sposob WBUDOWANY w klase (`compareTo`):
```java
class Produkt implements Comparable<Produkt> {
    public int compareTo(Produkt o) { return Double.compare(this.cena, o.cena); }
}
Collections.sort(lista);   // uzywa compareTo
```

**Comparator** = dodatkowy sposob podany Z ZEWNATRZ (lambda przy sortowaniu):
```java
lista.sort((a, b) -> Double.compare(a.getCena(), b.getCena()));  // rosnaco
lista.sort((a, b) -> Double.compare(b.getCena(), a.getCena()));  // MALEJACO (zamiana a,b)
```

**Regula znaku** (compareTo i Double.compare):
- wynik UJEMNY  -> a przed b (a mniejsze)
- wynik ZERO    -> rowne
- wynik DODATNI -> a po b (a wieksze)

---

## WZOR 8: Wzorzec State - zamiana switch na klasy stanow

**Kiedy:** "Usun switch/if z metody, zastap wzorcem State. Dodaj nowy typ bez
modyfikacji klasy glownej." Egzamin 2021 i 2025 - IDENTYCZNE zadanie z Figura.

**Idea:** zamiast `switch` rozrozniajacego przypadki, KAZDY przypadek to osobna
klasa implementujaca wspolny interfejs. Klasa glowna trzyma referencje do interfejsu
i DELEGUJE mu prace - zadnego switch.

### Wariant A: stan staly (Figura - obwod wg rodzaju)
```java
interface KsztaltFigury {
    double obliczObwod(double wielkosc);
}
class KoloF implements KsztaltFigury {
    public double obliczObwod(double w) { return 2 * Math.PI * w; }
}
class KwadratF implements KsztaltFigury {
    public double obliczObwod(double w) { return 4 * w; }
}
// nowy ksztalt = nowa klasa, BEZ ruszania klasy Figura:
class SzesciokatF implements KsztaltFigury {
    public double obliczObwod(double w) { return 6 * w; }
}

class Figura {
    private final String nazwa;
    private final double wielkosc;
    private KsztaltFigury rodzaj;

    public Figura(String nazwa, KsztaltFigury rodzaj, double wielkosc) {
        this.nazwa = nazwa; this.rodzaj = rodzaj; this.wielkosc = wielkosc;
    }
    public double obwod() { return rodzaj.obliczObwod(wielkosc); }  // delegacja, ZERO switch
    public void zmienRodzaj(KsztaltFigury r) { this.rodzaj = r; }
    @Override public String toString() { return nazwa + ": obwod=" + obwod(); }
}
```

### Wariant B: stan zmienia sam siebie (Gracz: Aktywny/Ranny/Spiacy)
To pelny State - kazdy stan WIE w co sie przeksztalcic po akcji.
```java
interface StatusGracza {
    void ruch(Gracz g);
    void cios(Gracz g);
}
class Aktywny implements StatusGracza {
    public void ruch(Gracz g) { System.out.println("Biega szybko"); }
    public void cios(Gracz g) {
        System.out.println("Pelny cios!");
        g.setStatus(new Ranny());      // STAN SAM SIEBIE PODMIENIA
    }
}
class Ranny implements StatusGracza {
    public void ruch(Gracz g) { System.out.println("Kuleje"); }
    public void cios(Gracz g) {
        System.out.println("Slaby cios");
        g.setStatus(new Aktywny());    // powrot do Aktywny
    }
}
class Gracz {
    private StatusGracza status = new Aktywny();
    public void ruch() { status.ruch(this); }   // delegacja
    public void cios() { status.cios(this); }
    public void setStatus(StatusGracza s) { this.status = s; }
}
```

**Pulapki:**
- klasa glowna NIE ma switch/if od stanow - tylko `stan.metoda(this)`
- przekazujesz `this` do metody stanu, zeby stan mogl zawolac `setStatus(...)`
- przejscia stanow siedza W KLASACH STANOW, nie w klasie glownej
- dodanie nowego stanu = nowa klasa, bez modyfikacji klasy glownej (sedno zadania!)
- to ten sam polimorfizm co tablica Zwierze[] - rozne klasy, wspolny interfejs

---

## WZOR 9: Watki (3 typy z egzaminow)

### Typ A: Licznik thread-safe (egzamin 2024)
**Kiedy:** "N watkow zwieksza licznik, wynik ma byc dokladny."
```java
class Licznik {
    private int wartosc = 0;
    public synchronized void zwieksz() { wartosc++; }   // synchronized = 1 watek naraz
    public synchronized int odczytaj() { return wartosc; }
}

// main:
Licznik licznik = new Licznik();
Thread[] watki = new Thread[50];
for (int i = 0; i < 50; i++) {
    watki[i] = new Thread(() -> { for (int j = 0; j < 1000; j++) licznik.zwieksz(); });
    watki[i].start();
}
for (Thread w : watki) w.join();    // poczekaj az wszystkie skoncza
System.out.println(licznik.odczytaj());   // dokladnie 50000
```
**Klucz:** bez `synchronized` wynik losowy (<50000) - race condition. `join()` zeby poczekac.

### Typ B: Watek obserwujacy Map - demon (egzamin 2023, 2024, 2025)
**Kiedy:** "Watek co X ms sprawdza rozmiar mapy, wypisuje zmiane. Demon."
```java
class MapObserver extends Thread {
    private final Map<?, ?> mapa;
    private final long intervalMs;
    private int ostatniRozmiar;

    public MapObserver(Map<?, ?> mapa, long intervalMs) {
        this.mapa = mapa;
        this.intervalMs = intervalMs;
        this.ostatniRozmiar = mapa.size();
        setDaemon(true);                 // PRZED start()! demon ginie z main
    }

    @Override
    public void run() {
        while (true) {
            try { Thread.sleep(intervalMs); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); break; }
            int nowy = mapa.size();
            if (nowy != ostatniRozmiar) {
                System.out.println("Mapa zmienila rozmiar o: " + (nowy - ostatniRozmiar));
                ostatniRozmiar = nowy;
            }
        }
    }
}
```
**Klucz:** `setDaemon(true)` PRZED `start()`. `while(true)` + `sleep` w try/catch.

### Typ C: Watek + wspolny zasob (egzamin 2021)
**Kiedy:** "Watki dodaja do wspolnej kolekcji (nie thread-safe)."
```java
class WatekDodajacy extends Thread {
    private final Stos stos;             // wspolny zasob
    private volatile boolean running = true;

    public WatekDodajacy(Stos stos) { this.stos = stos; setDaemon(true); }

    @Override
    public void run() {
        Random rand = new Random();
        while (running) {
            synchronized (stos) {        // blokuj na WSPOLNYM zasobie, NIE this!
                stos.put(rand.nextDouble());
            }
            try { Thread.sleep(200); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); break; }
        }
    }
}
```
**Klucz:** `synchronized (stos)` - na wspolnym obiekcie. Na `this` nie zadziala (kazdy watek to inny obiekt).

**Pulapki watkow (wszystkie typy):**
- `start()` uruchamia watek, `run()` wywolane wprost to zwykla metoda (bez rownoleglosci!)
- `setDaemon(true)` MUSI byc PRZED `start()`
- `Thread.sleep()` ZAWSZE w try/catch (InterruptedException)
- `volatile` na fladze stop; `synchronized` na wspolnych danych
- `join()` gdy main musi poczekac na wynik watkow

---

## WZOR 10: Swing - Observer (Listener) + Command (egzamin 2025, RZADKIE)

**Kiedy:** "Reaguj na klikniecia myszka (MouseListener/MouseAdapter), akcje jako obiekty."
Bylo TYLKO raz (2025 egz1, 25 pkt). Mniej pewne niz wzory 1-9, ale warto rozumiec idee.

### Observer = "obiekt powiadamia sluchaczy o zdarzeniu"
W Swingu komponent (np. panel) ma liste sluchaczy. Gdy cos sie dzieje (klik),
komponent WOLA metode kazdego sluchacza. Ty piszesz sluchacza.

```java
import javax.swing.*;
import java.awt.event.*;

JButton przycisk = new JButton("Kliknij");

// sluchacz jako klasa anonimowa - reaguje na zdarzenie (Observer)
przycisk.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Klikniety!");
    }
});
```

### MouseAdapter = "klasa szkieletowa" (pusty MouseListener)
`MouseListener` ma 5 metod - musialbys napisac wszystkie. `MouseAdapter` to klasa
z PUSTYMI implementacjami - dziedziczysz i nadpisujesz TYLKO te ktore Cie interesuja.
```java
panel.addMouseListener(new MouseAdapter() {   // adapter - nadpisuje sie tylko potrzebne
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Klik w: " + e.getX() + ", " + e.getY());
    }
    // pozostalych 4 metod NIE musisz pisac - adapter je ma puste
});
```

### Command = "akcja opakowana w obiekt"
Zamiast wykonywac akcje od razu, pakujesz ja w obiekt z metoda `execute()`.
Mozna je przechowywac, kolejkowac, cofac.
```java
interface Command {
    void execute();
}
class RysujKolo implements Command {
    public void execute() { System.out.println("Rysuje kolo"); }
}
class Wyczysc implements Command {
    public void execute() { System.out.println("Czyszcze plansze"); }
}

// listener wykonuje Command - laczy Observer z Command:
Command akcja = new RysujKolo();
przycisk.addActionListener(e -> akcja.execute());

// mozna trzymac historie akcji (do cofania):
List<Command> historia = new ArrayList<>();
historia.add(akcja);
```

**Pulapki / co zapamietac:**
- Observer: rejestrujesz sluchacza przez `addXxxListener(...)`, on reaguje na zdarzenia
- MouseAdapter = szkieletowa klasa (puste metody) - nadpisujesz tylko potrzebne
  (to jest "klasa szkieletowa" z teorii!)
- Command = akcja jako obiekt z `execute()` - mozna ja zapisac/cofnac
- `e.getX()`, `e.getY()` - wspolrzedne klikniecia z MouseEvent

---

## Szybka sciaga "co zobacze na egzaminie -> ktory wzor"

| Tresc zadania zawiera...                          | Wzor |
|---------------------------------------------------|------|
| "posortuj", "porownaj obiekty", equals/hashCode   | 1    |
| "wlasna lista/kolekcja", "iterowalny", for-each   | 2    |
| "zbior unikalny", "kolejnosc bez znaczenia"       | 3    |
| "stworz wyjatek z polami / informacja o..."       | 4    |
| "metoda rzuca wyjatek gdy brak elementu"          | 5    |
| "opakuj wyjatek", "przyczyna/cause"               | 6    |
| "posortuj rosnaco/malejaco po..."                 | 7    |
| "usun switch", "wzorzec State", "dodaj typ bez zmian klasy" | 8 |
| "N watkow", "thread-safe", "synchronized", "demon", "obserwuj Map" | 9 |
| "MouseListener", "MouseAdapter", "klikniecie", "Observer", "Command", Swing | 10 |

Szczegoly skladniowe i pulapki: patrz POWTORKA.md
Definicje teoretyczne (do pytan opisowych): patrz sciagawka_teoria.md
