# Tydzien 3: Metody

## Po co sa metody?

Metoda to nazwany blok kodu ktory mozna wywolac wielokrotnie.
Zamiast pisac ten sam kod 5 razy - piszesz go raz i wywolujesz 5 razy.

---

## 1. Definicja i wywolanie

```java
public class Cwiczenia {

    // Metoda bez zwracanej wartosci i bez parametrow
    public static void przywitaj() {
        System.out.println("Czesc!");
    }

    // Metoda z parametrem
    public static void przywitajKogos(String imie) {
        System.out.println("Czesc, " + imie + "!");
    }

    // Metoda z parametrami i zwracana wartoscia
    public static int dodaj(int a, int b) {
        return a + b;
    }

    // Metoda zwracajaca double
    public static double srednia(int[] tablica) {
        int suma = 0;
        for (int x : tablica) suma += x;
        return (double) suma / tablica.length;
    }

    public static void main(String[] args) {
        przywitaj();                    // wywolanie bez parametrow
        przywitajKogos("Kuba");         // z parametrem
        przywitajKogos("Anna");         // mozna wywolac wiele razy

        int wynik = dodaj(3, 7);        // zwrocona wartosc idzie do zmiennej
        System.out.println(wynik);      // 10

        int[] oceny = {4, 5, 3, 4, 5};
        System.out.println(srednia(oceny));  // 4.2
    }
}
```

---

## 2. Modifiers: static, void, typy

```
public static int dodaj(int a, int b) { ... }
  ^      ^     ^         ^
  |      |     |         + typ parametru
  |      |     + typ zwracanej wartosci (void = nic nie zwraca)
  |      + static = metoda klasy, nie obiektu (na razie uzywamy zawsze static)
  + public = dostepna z zewnatrz
```

Jesli metoda zwraca wartosc (`int`, `double`, `String` itp.) - MUSI miec `return`.
Jesli `void` - nie musi (mozna uzyc samego `return;` zeby przerwac).

---

## 3. Przeslanianie nazw (przeciazanie - overloading)

Mozna miec kilka metod o tej samej nazwie - roznia sie parametrami:

```java
public static void wypisz(int x) {
    System.out.println("Liczba: " + x);
}

public static void wypisz(String s) {
    System.out.println("Tekst: " + s);
}

public static void wypisz(int x, int y) {
    System.out.println("Para: " + x + ", " + y);
}

// Java sama wybiera ktora wywolac:
wypisz(42);          // -> wypisz(int)
wypisz("Hej");       // -> wypisz(String)
wypisz(3, 7);        // -> wypisz(int, int)
```

---

## 4. Rekurencja (metoda wywoluje siebie)

```java
// Silnia: n! = n * (n-1) * ... * 1
public static long silnia(int n) {
    if (n <= 1) return 1;        // warunek stopu - KLUCZOWE
    return n * silnia(n - 1);    // wywoluje siebie z mniejszym argumentem
}

// Ciag Fibonacciego
public static int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}

// Uzycie:
System.out.println(silnia(5));  // 120
System.out.println(fib(10));    // 55
```

---

## 5. Zasieg zmiennych (scope)

```java
public static void przyklad() {
    int x = 10;   // zmienna lokalna - istnieje tylko w tej metodzie

    if (true) {
        int y = 20;   // zmienna lokalna bloku if
        System.out.println(x);   // OK - x jest widoczne
        System.out.println(y);   // OK - y jest widoczne
    }
    // System.out.println(y);   // BLAD - y juz nie istnieje poza if
}

public static void inna() {
    // System.out.println(x);   // BLAD - x nie istnieje w tej metodzie
}
```

---

## ZADANIA

Zadania sa w [zadania.md](zadania.md).
