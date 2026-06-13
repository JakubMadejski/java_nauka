# Analiza egzaminow JiMP2 (2019-2025)

## TOP 5 - co wychodzi ZAWSZE

1. **Wlasna kolekcja + Iterable** (20-25 pkt) - KAZDY egzamin
2. **Wlasny wyjatek** (10 pkt) - KAZDY egzamin
3. **Teoria** (20 pkt) - KAZDY egzamin
4. **Wzorzec State** - 2021 x2, 2025 (ta sama Figura 3 razy!)
5. **Watki + synchronized** - 2021, 2023, 2024

---

## Egzamin 2021 (pytania_0)

| Nr | Pkt | Temat                           |
|----|-----|---------------------------------|
| 1  | 10  | Wyjatek z info o pliku i linii  |
| 2  | 20  | Lista<Osoba> z Iterable         |
| 3  | 20  | State: refaktoryzacja Figura    |
| 4  | 20  | Teoria: interfejs, test, polimorfizm, wzorzec |

## Egzamin 2021 Grp A (pytania_1 / pytania_21_6)

| Nr | Pkt | Temat                           |
|----|-----|---------------------------------|
| 1  | 20  | Uczen: Comparable, equals, hashCode, toString |
| 2  | 20  | State: Gracz ze statusami       |
| 3  | 10  | Prosty przyklad wlasnego wyjatku|
| 4  | 20  | Watek + synchronizacja (Stos)   |

## Egzamin 2023 Zestaw egz1

| Nr | Pkt | Temat                           |
|----|-----|---------------------------------|
| 1  | 25  | SparseColumn<Entry>: add, remove, Iterable, equals(Iterable), hashCode |
| 2  | 15  | Watek obserwujacy Map (demon)   |
| 3  | 10  | Wyjatek dla remove (niesc zawartosc) |
| 4  | 20  | Teoria: przeciazanie, ukrywanie, refaktoryzacja, wzorzec |

## Egzamin 2024 (Egz1_2024)

| Nr | Pkt | Temat                           |
|----|-----|---------------------------------|
| 1  | 10  | Przeciazanie vs przeslanianie (Auto, Minivan) |
| 2  | 20  | SList<Student>: add (unikalny), del, Iterable, toString posortowany |
| 3  | 20  | Licznik thread-safe + watek     |
| 4  | 20  | Odczyt pliku -> Map<String,String> |

## Egzamin 2025 (egz0)

| Nr | Pkt | Temat                           |
|----|-----|---------------------------------|
| 1  | 10  | Wyjatek plikowy (ta sama co 2021!)  |
| 2  | 20  | Koszyk: Iterable, dodaj, usun, getNazwyTowarow |
| 3  | 20  | State: Figura (ta sama co 2021!) |
| 4  | 20  | Teoria: interfejs, test, polimorfizm, wzorzec |

## Egzamin 2025 (egz1)

| Nr | Pkt | Temat                           |
|----|-----|---------------------------------|
| 1  | 20  | SparseVector<Entry>: jak SparseColumn z 2023 |
| 2  | 15  | Watek obserwujacy Map (jak 2023)  |
| 3  | 10  | Wyjatek dla remove SparseVector |
| 4  | 25  | Observer + Command w Swingu (MouseListener, MouseAdapter) |

---

## Wzory zadan ktore sie powtarzaja

### Wzor A: "Zbior unikalnych obiektow" (SparseVector/Column, Koszyk)
Pojawil sie: 2023, 2024, 2025.
- add: brak duplikatow, brak null
- remove: zwraca element lub rzuca wyjatek
- Iterable
- equals dla Iterable (kolejnosc nie ma znaczenia)
- hashCode jako suma

### Wzor B: "Watek obserwujacy Map"
Pojawil sie: 2023, 2024, 2025.
- Konstruktor: Map + intervalMs
- run(): sleep + sprawdz rozmiar + wypisz roznice
- setDaemon(true)

### Wzor C: "Wyjatek z zawartoscia kolekcji"
Pojawil sie: 2023, 2024, 2025.
- Konstruktor: message + Iterable<?>
- getZawartosc()
- Rzucany w remove() przez kolekcje

### Wzor D: "State: Figura ze switchem"
Pojawil sie: 2021 (pytania_0), 2025 (egz0).
- Interfejs KsztaltFigury
- Klasy: Kolo, Trojkat, Kwadrat
- Figura deleguje do stanu
