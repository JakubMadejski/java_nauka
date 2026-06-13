# Tydzien 6 - Zadania

## Z6.1 - Interfejs Ksztalt
Napisz interfejs `Ksztalt` z metodami `double pole()` i `double obwod()`.
Implementacje: `Kolo(double r)`, `Prostokat(double a, double b)`, `Trojkat(double a, double b, double c)`.
Stworz `List<Ksztalt>` z roznymi figurami i wypisz te o polu > 10.

## Z6.2 - Dziennik klasy
Stworz `ArrayList<Student>` (Student z Z4.2).
Dodaj 5 studentow, posortuj alfabetycznie po nazwisku (Comparable), wypisz.
Nastepnie posortuj po sredniej malejaco (uzyj `Comparator`):
```java
studenci.sort((s1, s2) -> Double.compare(s2.getSrednia(), s1.getSrednia()));
```

## Z6.3 - Liczenie slow
Napisz program ktory wczyta zdanie od uzytkownika i policzy ile razy kazde slowo
wystepuje. Uzyj `HashMap<String, Integer>`.
Wskazowka: `zdanie.split(" ")` rozbija na slowa.
Wynik: wypisz slowa i ich liczbe wystapien.

## Z6.4 - Usuwanie duplikatow
Wczytaj 10 liczb od uzytkownika do `ArrayList<Integer>`.
Wypisz te liczby bez powtorzen, zachowujac kolejnosc pierwszego wystapienia.
Wskazowka: uzyj `HashSet` do sprawdzania czy juz bylo.

## Z6.5 - Sklep z Enum
Stworz enum `Kategoria { ELEKTRONIKA, ODZIEŻ, JEDZENIE, SPORT }`.
Stworz klase `Produkt` z polami: `String nazwa`, `double cena`, `Kategoria kategoria`.
Stworz `ArrayList<Produkt>` z 8 produktami z roznych kategorii.
Wypisz tylko produkty z kategorii ELEKTRONIKA ktore kosztuja mniej niz 500 zl.

## Sprawdzenie
1. Jaka jest roznica miedzy interfejsem a klasa abstrakcyjna?
2. Czy klasa moze dziedziczyc po 2 klasach? A implementowac 2 interfejsy?
3. Jaka jest roznica miedzy `ArrayList` a tablicą?
4. Co to jest `Comparable` i do czego sluzy?
5. Kiedy uzywac `HashMap`, a kiedy `ArrayList`?
