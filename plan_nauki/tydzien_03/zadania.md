# Tydzien 3 - Zadania

## Z3.1 - Podstawowe metody
Napisz metody (wszystkie static):
- `boolean czyParzysta(int n)` - zwraca true jesli n jest parzyste
- `int max(int a, int b, int c)` - zwraca maksimum z 3 liczb
- `String powtorz(String s, int n)` - zwraca s powtozone n razy (np. "ha", 3 -> "hahaha")
- `boolean czyPierwsza(int n)` - zwraca true jesli n jest liczba pierwsza

Przetestuj kazda w main().

## Z3.2 - Kalkulator z metodami
Przepisz kalkulator z tygodnia 1 uzywajac metod:
- `double dodaj(double a, double b)`
- `double odejmij(double a, double b)`
- `double pomnoz(double a, double b)`
- `double podziel(double a, double b)` - uwaga na dzielenie przez zero!

## Z3.3 - Przeciazanie
Napisz metode `pole` ktora oblicza:
- `pole(double r)` - pole kola (PI * r * r)
- `pole(double a, double b)` - pole prostokatu (a * b)
- `pole(double a, double b, double c)` - pole trojkata wzorem Herona

Przetestuj czy Java poprawnie rozpoznaje ktora wersje wywolac.

## Z3.4 - Rekurencja
Napisz rekurencyjnie:
- `int sumaCyfr(int n)` - suma cyfr liczby (np. 1234 -> 10)
  Wskazowka: ostatnia cyfra to `n % 10`, reszta to `n / 10`
- `String odwroc(String s)` - odwraca stringa (np. "abc" -> "cba")
  Wskazowka: pierwsza litera + odwrocona reszta

## Sprawdzenie
1. Czym rozni sie metoda `void` od metody zwracajacej `int`?
2. Co to jest przeciazanie metod (overloading)?
3. Co sie stanie jesli zapomnisz `return` w metodzie ktora ma zwracac `int`?
4. Czym jest warunek stopu w rekurencji i co sie stanie bez niego?
