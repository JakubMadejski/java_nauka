# SCIAGAWKA TEORII - JiMP2

## Pojecia ktore powtarzaja sie NA KAZDYM egzaminie

---

### Interfejs (interface)
Interfejs to "kontrakt" - deklaracja metod bez implementacji.
Klasa implementujaca MUSI dostarczyc wszystkie metody. Klasa moze implementowac wiele interfejsow.
```java
public interface Iterable<T> { Iterator<T> iterator(); }
```
Rola: oddziela "co" od "jak" - umozliwia polimorfizm i wymiennosc implementacji.

---

### Klasa abstrakcyjna
Nie moze byc bezposrednio stworzona (new). Moze miec metody abstrakcyjne (bez ciala) i zwykle.
Rozniocc od interfejsu: moze miec pola i implementacje; tylko 1 klasa bazowa.
Klasa szkieletowa (np. MouseAdapter) - implementuje interfejs z pustymi metodami.

---

### Polimorfizm
Zdolnosc obiektow roznych typow do reagowania inaczej na te same wywolanie.
```java
Figura[] figury = {new Kolo(5), new Kwadrat(4)};
for (Figura f : figury) f.obwod();  // kazda liczy inaczej
```
Realizowany przez dziedziczenie i @Override.

---

### Dziedziczenie
Tworzenie nowej klasy (pochodna) na podstawie istniejaciej (bazowa).
`class Samochod extends Pojazd` - Samochod dziedziczy pola i metody Pojazd.

---

### Konstruktor
Specjalna metoda wywolywana przy new. Inicjalizuje obiekt.
Nie ma zwracanego typu. Ta sama nazwa co klasa.
```java
public Student(String imie, double srednia) { ... }
```

---

### Przeciazanie metod (overloading)
Kilka metod o tej samej nazwie ale roznych parametrach.
Java wybiera odpowiednia wersje na etapie kompilacji.
```java
void dodaj(int a) { ... }
void dodaj(int a, int b) { ... }
```
**Roznica od przeslaniania**: @Override - ta sama sygnatura w klasie pochodnej.

---

### Ukrywanie implementacji (hermetyzacja)
Pola private, dostep przez publiczne metody.
Chroni przed niepoprawnym ustawieniem danych. Mozna zmienic implementacje bez zmiany interfejsu.
```java
private double balance;
public double getBalance() { return balance; }
```

---

### Refaktoryzacja kodu
Zmiana struktury kodu BEZ zmiany jego zachowania.
Cel: czytelnosc, usuniecie duplikacji, latwiejsze utrzymanie.
Przyklad: zamiana switch na wzorzec State - to samo zachowanie, inna struktura.

---

### Wzorzec projektowy
Sprawdzone, wielokrotnie uzywane rozwiazanie typowego problemu projektowego.
3 kategorie:
- Kreacyjne (tworzenie): Singleton, Factory
- Strukturalne (kompozycja): Adapter, Decorator
- Behawioralne (zachowanie): **State**, **Observer**, **Command**

**State**: stan obiektu jako oddzielna klasa implementujaca interfejs. Brak switch.
**Observer**: obiekt powiadamia liste obserwatorow o zmianach (Swing Listeners).
**Command**: akcja opakowana w obiekt (ActionListener, mozliwosc cofania).

---

### Test jednostkowy
Automatyczny test izolowanej jednostki kodu (metody/klasy).
Cechy: szybki, powtarzalny, niezalezny od innych testow.
W Javie: JUnit, adnotacja @Test.
```java
@Test
public void testDodaj() { assertEquals(5, kalk.dodaj(2, 3)); }
```

---

### Wyjatek (Exception)
Mechanizm obslugi bledow. Checked (extends Exception) - kompilator wymaga obslugi.
Unchecked (extends RuntimeException) - opcjonalna obsluga.

---

## SCIAGA KODOWA - wzory na egzamin

### Wzor 1: equals + hashCode
```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MojaKlasa)) return false;
    MojaKlasa m = (MojaKlasa) o;
    return pole1.equals(m.pole1) && Double.compare(m.pole2, pole2) == 0;
}
@Override
public int hashCode() { return Objects.hash(pole1, pole2); }
```

### Wzor 2: Iterable (Iterator anonimowy)
```java
@Override
public Iterator<T> iterator() {
    return new Iterator<T>() {
        int idx = 0;
        public boolean hasNext() { return idx < rozmiar; }
        public T next() { return (T) dane[idx++]; }
    };
}
```

### Wzor 3: Watek demon z flaga
```java
public class MojWatek extends Thread {
    private volatile boolean running = true;
    public MojWatek() { setDaemon(true); }
    @Override
    public void run() {
        while (running) {
            // zadanie
            try { Thread.sleep(intervalMs); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); break; }
        }
    }
    public void zatrzymaj() { running = false; }
}
```

### Wzor 4: Wyjatek z danymi
```java
public class MojWyjatek extends RuntimeException {
    private final String daneDodatkowe;
    public MojWyjatek(String message, String dane) {
        super(message);
        this.daneDodatkowe = dane;
    }
    public String getDaneDodatkowe() { return daneDodatkowe; }
}
```

### Wzor 5: State
```java
// Interfejs
interface Stan { void akcja(Kontekst k); }
// Stany
class StanA implements Stan { public void akcja(Kontekst k) { k.setStan(new StanB()); } }
class StanB implements Stan { public void akcja(Kontekst k) { System.out.println("B"); } }
// Kontekst
class Kontekst {
    private Stan stan = new StanA();
    public void setStan(Stan s) { stan = s; }
    public void wykonaj() { stan.akcja(this); }
}
```

---

## TABELA SKROTOW NA EGZAMINIE

| Tresc zadania                         | Co piszesz                                       |
|---------------------------------------|--------------------------------------------------|
| "zbior unikalnych obiektow"           | tablica + sprawdz duplikat w dodaj()             |
| "implementuje Iterable"               | + anonimowy Iterator w metodzie iterator()       |
| "dziala wielowatkowo"                 | synchronized na wspoldzielonym obiekcie          |
| "watek ma byc demonem"                | setDaemon(true) PRZED start()                    |
| "wzorzec State"                       | interfejs + klasy stanow + delegacja w metodach  |
| "wyjatek z danymi"                    | private final pole + getter                      |
| "equals dla Iterable"                 | zbierz do Set, porownaj rozmiar i zawartosc      |
| "compareTo malejaco"                  | Double.compare(other.pole, this.pole)            |
| "null niedozwolony"                   | if (x == null) throw new IllegalArgumentException|
| "wyjmij/usun - nie ma elementu"       | throw new XxxWyjatek("...", this)                |
