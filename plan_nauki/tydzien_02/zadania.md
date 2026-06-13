# Tydzien 2 - Zadania

## Z2.1 - Klasyfikacja liczby
Wczytaj liczbe od uzytkownika i wypisz czy jest:
- ujemna, zero, czy dodatnia
- parzysta czy nieparzysta
- wielokrotnoscia 3

## Z2.2 - FizzBuzz (klasyczne zadanie)
Wypisz liczby od 1 do 100.
- Dla wielokrotnosci 3 wypisz "Fizz" zamiast liczby
- Dla wielokrotnosci 5 wypisz "Buzz"
- Dla wielokrotnosci i 3 i 5 wypisz "FizzBuzz"

Przykladowy wynik: 1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz...

## Z2.3 - Tabliczka mnozenia
Wypisz tabliczke mnozenia od 1 do 10 (uzywajac 2 zagniezdoznych petli for).
Format:
```
 1  2  3  4  5  6  7  8  9 10
 2  4  6  8 10 12 14 16 18 20
...
```
Wskazowka: uzyj `System.out.printf("%3d", liczba)` zeby wyrownac kolumny.

## Z2.4 - Operacje na tablicy
Stworz tablice 8 liczb calkowitych (wpisz recznie dowolne wartosci).
Wypisz:
- Wszystkie elementy
- Sume
- Srednia arytmetyczna
- Minimalna i maksymalna wartosc
- Elementy w odwrotnej kolejnosci

## Z2.5 - Zgadywanka (bonus)
Program losuje liczbe 1-100 (`int x = (int)(Math.random() * 100) + 1`).
Uzytkownik zgaduje dopoki nie trafi.
Po kazdej probce wypisz "za malo" lub "za duzo".
Na koncu wypisz ile prob zajelo.

## Sprawdzenie
1. Jaka jest roznica miedzy `while` a `do-while`?
2. Co sie stanie jezeli zapomnisz `break` w switch?
3. Jak sprawdzic dlugosc tablicy?
4. Jak dziala for-each - kiedy go uzywac, a kiedy zwykly for z indeksem?
