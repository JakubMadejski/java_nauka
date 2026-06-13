# Tydzien 9 - Zadania

## Z9.1 - Prosty wyjatek (z egzaminu 2021 Grp A)
Napisz klase `NiedodatniaDlugoscWyjatek extends RuntimeException`.
Klasa `Prostokat` rzuca go w konstruktorze gdy szerokosc lub wysokosc <= 0.
Wychwyc i wypisz komunikat.

## Z9.2 - Wyjatek z danymi o pliku (z egzaminu 2021)
Napisz klase `NieprawidlowaLiniaWyjatek extends RuntimeException`:
- Pola: nazwaPliku, numerLinii, zawartosc
- Komunikat super() zawiera wszystkie 3
- Gettery dla wszystkich pol

Test:
```java
try {
    throw new NieprawidlowaLiniaWyjatek("dane.txt", 42, "Jan abc");
} catch (NieprawidlowaLiniaWyjatek e) {
    System.out.println(e.getMessage());
    System.out.println("Plik: " + e.getNazwaPliku());
    System.out.println("Linia: " + e.getNumerLinii());
}
```

## Z9.3 - Wyjatek z kolekcja (z egzaminu 2024/2025)
Rozszerz `ZbiorUnikalny<T>` z tygodnia 8.
Napisz `BrakElementuWyjatek extends RuntimeException`:
- Konstruktor: (String message, Iterable<?> zawartosc)
- Getter getZawartosc()

Zmien metode usun() zeby rzucala ten wyjatek gdy nie znajdzie elementu.
Przekaz `this` jako zawartosc.

Test:
```java
ZbiorUnikalny<String> z = new ZbiorUnikalny<>();
z.dodaj("a"); z.dodaj("b");
try {
    z.usun("c");
} catch (BrakElementuWyjatek e) {
    System.out.println("Blad: " + e.getMessage());
    for (Object o : e.getZawartosc()) System.out.println("  " + o);
}
```

## Z9.4 - Lancuch wyjatkow
Napisz program ktory:
1. Wczytuje plik z liczbami (po jednej na linie)
2. Jezeli linia zawiera nie-liczbe - rzuca `NieprawidlowaLiniaWyjatek`
3. W catch - opakowuje oryginaly wyjatek w nowy `PrzetwarzanieWyjatek(message, cause)`
4. Wypisuje obie wiadomosci i getCause().getMessage()

## Sprawdzenie
1. Jaka jest roznica miedzy checked a unchecked exception?
2. Czemu przekazujemy `this` jako zawartosc w wyjatku kolekcji?
3. Co sie stanie jesli checked exception nie jest obsluzone ani nie ma `throws` w sygnaturze?
4. Napisz z pamieci szkielet wyjatku z jednym dodatkowym polem i getterem.
