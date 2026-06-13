# Tydzien 4 - Zadania

## Z4.1 - Klasa Prostokat
Napisz klase `Prostokat` z polami `szerokosc` i `wysokosc` (private double).
- Konstruktor przyjmujacy oba wymiary (sprawdz czy sa > 0)
- Gettery dla obu pol
- Metody: `double pole()`, `double obwod()`
- `toString()` zwracajacy np. "Prostokat 5.0x3.0"

Przetestuj w main().

## Z4.2 - Klasa Student
Napisz klase `Student` z polami: `String imie`, `String nazwisko`, `double srednia` (private).
- Konstruktor z wszystkimi 3 polami
- Gettery
- `toString()` zwracajacy np. "Kowalski Jan (4.5)"
- Pole statyczne `int liczbaStudentow` ktore liczy ile obiektow Student stworzono

## Z4.3 - Klasa Koszyk
Napisz klase `Koszyk` (uproszczona, bez tablic na razie):
- Pola: `String[] produkty` (max 10), `double[] ceny`, `int iloscPozycji`
- Konstruktor bezparametrowy (inicjalizuje tablice)
- `void dodaj(String produkt, double cena)` - dodaje jezeli nie ma jeszcze 10
- `double suma()` - suma cen
- `void wypisz()` - wypisuje wszystkie produkty z cenami
- `toString()` - zwraca "Koszyk: X pozycji, suma: Y zl"

## Z4.4 - Klasa Licznik
Napisz klase `Licznik` z polem `int wartosc` (private, start = 0).
- `void zwieksz()` - zwieksza o 1
- `void zmniejsz()` - zmniejsza (nie ponizej 0)
- `void zwieksz(int o)` - zwieksza o podana wartosc (przeciazanie!)
- `void zeruj()`
- `int odczytaj()`
- `toString()`

## Sprawdzenie
1. Czym rozni sie pole `static` od zwyklego pola instancyjnego?
2. Po co jest `private`? Co by sie stalo gdyby wszystko bylo `public`?
3. Co to jest `this` w Javie?
4. Czym rozni sie konstruktor od metody?
