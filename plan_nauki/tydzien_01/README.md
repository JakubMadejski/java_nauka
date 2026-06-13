# Tydzien 1: Pierwsze kroki w Javie

## Jak uruchomic program w Javie

Kazdy program w Javie zaczyna sie od klasy z metoda `main`:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Witaj swiecie!");
    }
}
```

Kompilacja i uruchomienie w terminalu:
```
javac HelloWorld.java     <- kompiluje (tworzy HelloWorld.class)
java HelloWorld           <- uruchamia
```

---

## 1. Zmienne i typy danych

Java jest jezykiem statycznie typowanym - musisz deklarowac typ zmiennej.

```java
// Typy calkowite
int liczba = 42;
long duzoWieksza = 1_000_000_000L;   // L na koncu dla long

// Typy zmiennoprzecinkowe
double cena = 19.99;
float mniejsza = 3.14f;              // f na koncu dla float

// Tekst
String imie = "Kuba";
char litera = 'A';                   // pojedyncza litera - apostrofy

// Prawda/falsz
boolean czyDorec = true;
boolean czyFalsc = false;

// Drukowanie
System.out.println("Imie: " + imie);         // + laczy stringi
System.out.println("Liczba: " + liczba);
System.out.println("Cena: " + cena + " zl");
```

---

## 2. Operatory

```java
int a = 10;
int b = 3;

System.out.println(a + b);   // 13  - dodawanie
System.out.println(a - b);   // 7   - odejmowanie
System.out.println(a * b);   // 30  - mnozenie
System.out.println(a / b);   // 3   - dzielenie CALKOWITE (nie 3.33!)
System.out.println(a % b);   // 1   - reszta z dzielenia (modulo)

// Dzielenie zmiennoprzecinkowe - przynajmniej jeden musi byc double
System.out.println((double) a / b);  // 3.333...
System.out.println(10.0 / 3);        // 3.333...

// Operatory porownania - zwracaja boolean
System.out.println(a > b);   // true
System.out.println(a == b);  // false
System.out.println(a != b);  // true
System.out.println(a >= 10); // true
```

---

## 3. Drukowanie i formatowanie

```java
String imie = "Anna";
int wiek = 25;
double srednia = 4.75;

// Sposob 1: laczenie stringow przez +
System.out.println("Imie: " + imie + ", wiek: " + wiek);

// Sposob 2: printf (jak w C)
System.out.printf("Imie: %s, wiek: %d, srednia: %.2f%n", imie, wiek, srednia);
// %s = String, %d = int, %.2f = double z 2 miejscami po przecinku, %n = nowa linia

// Sposob 3: println bez nowej linii
System.out.print("bez nowej linii");
System.out.print(" - kontynuacja");
System.out.println();  // tylko nowa linia
```

---

## 4. Wczytywanie danych od uzytkownika (Scanner)

```java
import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj pierwsza liczbe: ");
        int a = scanner.nextInt();

        System.out.print("Podaj druga liczbe: ");
        int b = scanner.nextInt();

        System.out.println("Suma: " + (a + b));

        scanner.close();  // zawsze zamykaj na koncu
    }
}
```

Metody Scannera:
- `scanner.nextInt()` - wczytuje liczbe calkowita
- `scanner.nextDouble()` - wczytuje double
- `scanner.next()` - wczytuje jedno slowo
- `scanner.nextLine()` - wczytuje cala linie tekstu

---

## 5. Konwersja typow

```java
// int -> double (automatyczna - bezpieczna)
int liczba = 5;
double wynik = liczba;   // 5.0 - OK, nie gubi danych

// double -> int (reczna - traci czesc dziesietna)
double pi = 3.14;
int zaokraglone = (int) pi;   // 3 - uwaga, nie zaokragla, obcina!

// String -> int
String tekst = "42";
int num = Integer.parseInt(tekst);

// String -> double
String cenaStr = "19.99";
double cena = Double.parseDouble(cenaStr);

// int/double -> String
String s1 = String.valueOf(42);
String s2 = "" + 3.14;    // szybki trik
```

---

## ZADANIA

Zadania sa w [zadania.md](zadania.md).
