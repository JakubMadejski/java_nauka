# Tydzien 6: Interfejsy + kolekcje java.util

## 1. Interfejs

Interfejs to "kontrakt" - lista metod ktore klasa implementujaca MUSI dostarczyc.
Roznica od klasy abstrakcyjnej: brak pol (tylko stale), klasa moze implementowac WIELE interfejsow.

```java
// Definicja interfejsu
public interface Figurowalny {
    double pole();     // deklaracja - bez ciala
    double obwod();
}

public interface Rysowany {
    void rysuj();
}

// Klasa implementuje oba interfejsy
public class Kolo implements Figurowalny, Rysowany {
    private double r;
    public Kolo(double r) { this.r = r; }

    @Override
    public double pole() { return Math.PI * r * r; }

    @Override
    public double obwod() { return 2 * Math.PI * r; }

    @Override
    public void rysuj() { System.out.println("Rysuje kolo o r=" + r); }
}
```

---

## 2. ArrayList - lista dynamiczna

`ArrayList` to lista ktora automatycznie zmienia rozmiar. Zastepuje tablice w wiekszosci przypadkow.

```java
import java.util.ArrayList;
import java.util.Collections;

ArrayList<String> imiona = new ArrayList<>();

// Dodawanie
imiona.add("Anna");
imiona.add("Piotr");
imiona.add("Zofia");

// Dostep
System.out.println(imiona.get(0));     // "Anna"
System.out.println(imiona.size());     // 3

// Modyfikacja
imiona.set(1, "Marek");               // zastap Piotr -> Marek

// Usuwanie
imiona.remove("Zofia");               // usun po wartosci
imiona.remove(0);                      // usun po indeksie

// Sprawdzanie
System.out.println(imiona.contains("Anna"));  // true/false

// Petla for-each
for (String s : imiona) {
    System.out.println(s);
}

// Sortowanie
Collections.sort(imiona);             // alfabetycznie
```

---

## 3. HashMap - slownik klucz -> wartosc

```java
import java.util.HashMap;
import java.util.Map;

HashMap<String, Integer> wiek = new HashMap<>();

// Wstawianie
wiek.put("Anna", 25);
wiek.put("Piotr", 30);
wiek.put("Zofia", 22);

// Pobieranie
System.out.println(wiek.get("Anna"));     // 25
System.out.println(wiek.get("Jan"));      // null (nie ma)
System.out.println(wiek.getOrDefault("Jan", 0));  // 0 zamiast null

// Sprawdzanie
System.out.println(wiek.containsKey("Anna"));    // true
System.out.println(wiek.size());                  // 3

// Iteracja po wszystkich parach
for (Map.Entry<String, Integer> entry : wiek.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}

// Usuwanie
wiek.remove("Piotr");
```

---

## 4. HashSet - zbior unikalnych elementow

```java
import java.util.HashSet;

HashSet<String> zbior = new HashSet<>();
zbior.add("a");
zbior.add("b");
zbior.add("a");   // duplikat - ignorowany!

System.out.println(zbior.size());         // 2, nie 3
System.out.println(zbior.contains("a")); // true
```

---

## 5. Interfejsy z java.util

### List (interfejs) - ArrayList i LinkedList go implementuja

```java
import java.util.List;

List<String> lista = new ArrayList<>();  // List, nie ArrayList - dobre praktyka
lista.add("x");
```

### Comparable - sortowanie wlasnych obiektow

```java
public class Student implements Comparable<Student> {
    String nazwisko;
    double srednia;

    @Override
    public int compareTo(Student other) {
        // Sortowanie alfabetycznie po nazwisku
        return this.nazwisko.compareTo(other.nazwisko);
    }
}

List<Student> studenci = new ArrayList<>();
// ... dodaj studentow ...
Collections.sort(studenci);  // uzyje compareTo()
```

---

## 6. Enum

Enum to specjalny typ wyliczeniowy - zbior stalych wartosci.

```java
public enum DzienTygodnia {
    PONIEDZIALEK, WTOREK, SRODA, CZWARTEK, PIATEK, SOBOTA, NIEDZIELA
}

DzienTygodnia dzien = DzienTygodnia.SRODA;
System.out.println(dzien);           // "SRODA"
System.out.println(dzien.ordinal()); // 2 (indeks od 0)

if (dzien == DzienTygodnia.SOBOTA || dzien == DzienTygodnia.NIEDZIELA) {
    System.out.println("Weekend!");
}
```

---

## ZADANIA

Zadania sa w [zadania.md](zadania.md).
