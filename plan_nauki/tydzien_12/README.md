# Tydzien 12: Symulacje egzaminu

## Zasady

- Kazda symulacja: **90 minut**, bez podglądania teorii
- Po 90 minutach: skompiluj, sprawdz, oceń sie
- Zrob wszystkie 3 symulacje przed egzaminem

---

## Symulacja 1 (wzorowany na 2024)

**90 min | max 70 pkt**

### Pyt. 1 (10 pkt) - Przeciazanie vs przeslanianie
Napisz dwie klasy: `Auto` (baza) i `Minivan extends Auto`.
W Auto: przeciaz konstruktor i dowolna metode.
W Minivan: przeslaniaj te metode przez @Override.
Pokaz roznice w zachowaniu.

### Pyt. 2 (20 pkt) - SList<Student>
Klasa `SList` reprezentujaca liste studentow:
1. Implementuje `Iterable<Student>`, metody `void add(Student x)`, `Student del(Student x)`
2. `add` dodaje tylko gdy studenta jeszcze nie ma
3. `del` zwraca usunietego studenta lub null
4. Konstruktor, metoda zwracajaca liczbe, toString (posortowane po nazwisku)
5. Minimalne wymagania dla klasy Student

### Pyt. 3 (20 pkt) - Licznik wielowatkowy
Klasa `Licznik`: zwieksz, zmniejsz, zeruj, odczytaj - wszystkie thread-safe.
Napisz tez klase-watek ktora co 500ms zwieksza licznik.

### Pyt. 4 (20 pkt) - Opisz pojecia (4 x 5 pkt)
1. Przeciazanie metod
2. Ukrywanie implementacji (hermetyzacja)
3. Refaktoryzacja kodu
4. Wzorzec projektowy

---

## Symulacja 2 (wzorowany na 2021)

**90 min | max 70 pkt**

### Pyt. 1 (10 pkt) - Wyjatek plikowy
Wyjatek `NieprawidlowaLiniaWyjatek`: przechowuje nazwaPliku, numerLinii, zawartosc.
Gettery dla wszystkich pol. Komunikat zawiera wszystkie 3 informacje.

### Pyt. 2 (20 pkt) - Lista<Osoba>
Klasa `Lista` z `void dodaj(Osoba)`, `void usun(Osoba)`, liczba osob, toString.
Implementuje `Iterable<Osoba>`. toString MUSI iterowac przez Iterable.

### Pyt. 3 (20 pkt) - State: Figura
Zrefaktoryzuj klase Figura ze switch w obwod() na wzorzec State.
Usun switch. Kolo, Trojkat, Kwadrat jako oddzielne klasy.

### Pyt. 4 (20 pkt) - Opisz pojecia (4 x 5 pkt)
1. Interfejs
2. Test jednostkowy
3. Polimorfizm
4. Wzorzec projektowy

---

## Symulacja 3 (wzorowany na 2025)

**90 min | max 70 pkt**

### Pyt. 1 (10 pkt) - Wyjatek + kolekcja
Wyjatek `BrakElementuWyjatek`:
- Przechowuje referencje do `Iterable<?>` (zawartosc kolekcji)
- Getter getZawartosc()

### Pyt. 2 (20 pkt) - Koszyk
Klasa `Koszyk` - zbior obiektow `Zakup` (nazwa, cena):
- Implementuje Iterable<Zakup>
- void dodaj(Zakup), void wyjmij(Zakup) - wyjmij rzuca BrakElementuWyjatek
- int liczbaPozycji()
- String getNazwyTowarow() - nazwy po przecinku
- toString

### Pyt. 3 (20 pkt) - State: Figura (znowu!)
Identyczne jak Symulacja 2 Pyt. 3.
(Naprawde pojawila sie na obu egzaminach 2021 i 2025!)

### Pyt. 4 (20 pkt) - Observer i Command w Swingu
Opisz wzorce Observer i Command w koncepcji Listenerow Swing.
Przyklad z MouseListener i MouseAdapter (klasa szkieletowa).

---

## Ocenianie symuacji

| Pkt    | Ocena |
|--------|-------|
| 60-70  | 5.0   |
| 50-59  | 4.5   |
| 40-49  | 4.0   |
| 30-39  | 3.5   |
| 20-29  | 3.0   |
| < 20   | 2.0   |

---

## Taktyka na prawdziwym egzaminie

**Kolejnosc rozwiazywania:**
1. Wyjatek (10 pkt, ~10 min) - najszybszy, warto zaczac
2. Teoria (20 pkt, ~20 min) - punkty za wiedze, bez kodowania
3. Kolekcja + Iterable (20 pkt, ~35 min) - kluczowe, zacznij od szkieletu
4. Watki/State (20 pkt, ~25 min) - na koniec

**Jezeli brakuje czasu:**
- Napisz choc szkielet klasy z polami i sygnaturami metod
- Czesto daja punkty za czesciowe rozwiazanie
- Komentarze "tu byloby synchronized" sa lepsze niz pusta strona
