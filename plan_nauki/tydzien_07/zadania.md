# Tydzien 7 - Zadania

## Z7.1 - Klasa Punkt
Napisz klase `Punkt` z polami `double x`, `double y`.
Zaimplementuj: konstruktor, gettery, `toString`, `equals`, `hashCode`.
Test: wrzuc dwa identyczne punkty do `HashSet<Punkt>` - powinien miec rozmiar 1.

## Z7.2 - Klasa Produkt z Comparable
Klasa `Produkt`: `String nazwa`, `double cena`.
Comparable: od najtanszego do najdrozszego.
Pelne equals/hashCode/toString.
Test: stworz liste 5 produktow, posortuj, wypisz.

## Z7.3 - Klasa Uczen (PRAWDZIWE ZADANIE z egzaminu 2021)
Napisz klase `Uczen` z polami: `String imie`, `String nazwisko`, `double sredniaOcen`.
Wymagania DOKLADNIE jak na egzaminie:
1. Dziedziczy po Object (normalnie, bez extends)
2. Implementuje `Comparable<Uczen>` - sortowanie od NAJWYZSZEJ do NAJNIZSZEJ sredniej
3. Przeslania equals, hashCode, toString
4. Konstruktor z 3 argumentami + gettery

Test:
```java
List<Uczen> uczniowie = new ArrayList<>();
uczniowie.add(new Uczen("Anna", "Kowalska", 4.5));
uczniowie.add(new Uczen("Piotr", "Nowak", 3.8));
uczniowie.add(new Uczen("Maria", "Wis", 5.0));
Collections.sort(uczniowie);
uczniowie.forEach(System.out::println);
// Oczekiwany wynik: Maria(5.0), Anna(4.5), Piotr(3.8)
```

## Z7.4 - Bug do znalezienia
Ten kod ma blad. Znajdz i napraw:
```java
public class Auto {
    private String marka;
    private int rok;

    public Auto(String marka, int rok) { this.marka = marka; this.rok = rok; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Auto)) return false;
        Auto a = (Auto) o;
        return marka == a.marka && rok == a.rok;  // BUG
    }

    @Override
    public int hashCode() {
        return rok;  // BUG - hashCode uwzglednia tylko rok, a equals uwzglednia tez marke
    }
}
```

## Sprawdzenie
1. Dlaczego nie mozna porownywac Stringow przez `==`?
2. Co sie stanie jezeli przeslonisz equals() ale NIE przeslonisz hashCode()?
3. Co zwraca compareTo() gdy `this` jest "wieksze" od `other`?
4. Jak posortowac malejaco jezeli klasa juz implementuje Comparable (rosnaco)?
