# Tydzien 8 - Zadania

## Z8.1 - Prosta lista (rozgrzewka)
Napisz `ListaLiczb` bez generyku (tylko Integer).
- void dodaj(int x), void usun(int x), int rozmiar()
- Implementuje Iterable<Integer>
- toString: "[1, 2, 3]"
Test: dodaj 5 liczb, wypisz, usun srodkowa, wypisz znow.

## Z8.2 - Lista z generykiem
Przepisz Z8.1 jako `MojaLista<T>`.
Test: stworz `MojaLista<String>` i `MojaLista<Integer>` - oba musza dzialac.

## Z8.3 - Lista<Osoba> z egzaminu 2021 (PRAWDZIWE ZADANIE)
Napisz klase `Osoba` z polami: String imie, String nazwisko.
Napisz klase `Lista` (bez generyku) reprezentujaca grupe Osoba.

Wymagania DOKLADNIE jak na egzaminie:
1. Implementuje Iterable<Osoba>
2. void dodaj(Osoba x), void usun(Osoba x)
3. Metoda zwracajaca liczbe osob
4. toString iterujacy po osobach PRZEZ Iterable (nie przez pole dane[] bezposrednio)

## Z8.4 - Unikalna kolekcja (SparseVector z egzaminu 2024/2025)
Napisz `ZbiorUnikalny<T>`:
1. void dodaj(T x) - ignoruje duplikaty; null -> wyjatek
2. T usun(T x) - zwraca usuniety element lub null jezeli nie bylo
3. int rozmiar()
4. Implementuje Iterable<T>
5. equals zwraca true jesli o jest Iterable z tymi samymi elementami (kolejnosc nie ma znaczenia)
6. hashCode kompatybilny z equals

Test duplikatow:
```java
ZbiorUnikalny<String> z = new ZbiorUnikalny<>();
z.dodaj("a"); z.dodaj("b"); z.dodaj("a");  // duplikat
System.out.println(z.rozmiar());  // 2
```

Test equals:
```java
ZbiorUnikalny<String> z1 = new ZbiorUnikalny<>();
z1.dodaj("x"); z1.dodaj("y");
ZbiorUnikalny<String> z2 = new ZbiorUnikalny<>();
z2.dodaj("y"); z2.dodaj("x");  // inna kolejnosc
System.out.println(z1.equals(z2));  // true!
```

## Sprawdzenie
1. Jakie dwie metody ma interfejs Iterator<T>?
2. Dlaczego w toString() piszemy `for (T elem : this)` zamiast petli po tablicy dane[]?
3. Dlaczego hashCode() dla zbioru uzywamy sumy hashCode elementow (a nie np. iloczynu)?
4. Napisz z pamieci minimalny szkielet anonimowego Iteratora na tablicy.
