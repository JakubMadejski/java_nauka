# Tydzien 5 - Zadania

## Z5.1 - Hierarchia zwierzat
Stworz klase abstrakcyjna `Zwierze` z polami: `String imie`, `int wiek`.
Metoda abstrakcyjna: `String dzwiek()`.
Metoda zwykla: `void przedstawSie()` - wypisuje "Jestem [imie], mam [wiek] lat i mowie: [dzwiek()]"

Stwroz podklasy: `Pies`, `Kot`, `Krowa` - kazda implementuje `dzwiek()` inaczej.

Przetestuj polimorfizm: stworz tablice `Zwierze[]` z roznym i wypisz wszystkie.

## Z5.2 - Hierarchia pojazdow
Klasa abstrakcyjna `Pojazd`:
- Pola: `String marka`, `int rok`
- Abstrakcyjna metoda: `String typPojazdu()`
- Metoda `opis()`: zwraca "[typPojazdu()] [marka] z roku [rok]"

Podklasy: `Samochod` (pole: `int liczbaDrzwi`), `Rower` (pole: `boolean maGlosnik`), `Motor`
Kazda implementuje `typPojazdu()` i przeslania `toString()`.

## Z5.3 - Rozszerzenie z tygodnia 4
Rozszerz zadanie Z4.2 (Student):
- Stworz klase abstrakcyjna `Osoba` z polami `imie`, `nazwisko`
- `Student extends Osoba` dodaje `srednia`
- Stworz `Pracownik extends Osoba` z polem `String stanowisko`
- Stworz tablice `Osoba[]` z mieszanymi obiektami i wypisz wszystkich

## Z5.4 - instanceof w praktyce
Masz tablice `Figura[] figury` z kolami i kwadratami (z README).
Wypisz osobno:
- Sume pol wszystkich kol
- Sume pol wszystkich kwadratow
Uzyj `instanceof` i rzutowania.

## Sprawdzenie
1. Co to jest polimorfizm? Podaj przyklad.
2. Jaka jest roznica miedzy klasa abstrakcyjna a zwykla klasa?
3. Czy mozna stworzyc obiekt klasy abstrakcyjnej?
4. Co to jest `super()` i kiedy trzeba je wywolac?
5. Jaka jest roznica miedzy `private` a `protected`?
