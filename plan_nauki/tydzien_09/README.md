# Tydzien 9: Wlasne wyjatki (Custom Exceptions)

## Dlaczego to jest wazne?

Wyjatki sa na KAZDYM egzaminie JiMP2. Kazdy rok ma zadanie:
"Napisz wlasny wyjatek". Na nowszych egzaminach (2023-2025) wyjatek musi niesc dodatkowe dane.

---

## 1. Jak dzialaja wyjatki

```java
try {
    // kod ktory moze sie "wylozyc"
    int[] t = new int[5];
    t[10] = 1;                  // ArrayIndexOutOfBoundsException!
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Blad: " + e.getMessage());
} finally {
    System.out.println("To sie wykona zawsze");  // czy byl blad czy nie
}
```

---

## 2. Hierarchia wyjatkow

```
Throwable
  ├── Error (bledy JVM - nie lapaj)
  └── Exception
        ├── RuntimeException (unchecked - kompilator nie wymaga obslugi)
        │     ├── IllegalArgumentException
        │     ├── NullPointerException
        │     └── IllegalStateException
        └── IOException i inne (checked - MUSI byc w try/catch lub throws)
```

Na egzaminie: zwykle chca **unchecked** (extends RuntimeException).

---

## 3. Najprostszy wlasny wyjatek

```java
public class PustyKoszykWyjatek extends RuntimeException {
    public PustyKoszykWyjatek(String message) {
        super(message);
    }
}

// Uzycie:
public class Koszyk {
    private int liczbaElementow = 0;

    public void kupuj() {
        if (liczbaElementow == 0) {
            throw new PustyKoszykWyjatek("Koszyk jest pusty!");
        }
        System.out.println("Kupuje...");
    }
}

// W main:
try {
    koszyk.kupuj();
} catch (PustyKoszykWyjatek e) {
    System.out.println("Nie mozna kupic: " + e.getMessage());
}
```

---

## 4. Wyjatek z dodatkowymi danymi (wzor egzaminowy 2021)

Z egzaminu 2021:
"Wyjatek zglaszany gdy wykryta nieprawidlowa linia. Musi umozliwic ustalenie:
jaki to blad, ktora linia, ktory plik."

```java
public class NieprawidlowaLiniaWyjatek extends RuntimeException {

    private final String nazwaPliku;
    private final int numerLinii;
    private final String zawartosc;

    public NieprawidlowaLiniaWyjatek(String nazwaPliku, int numerLinii, String zawartosc) {
        super("Nieprawidlowa linia " + numerLinii
              + " w pliku '" + nazwaPliku + "': " + zawartosc);
        this.nazwaPliku = nazwaPliku;
        this.numerLinii = numerLinii;
        this.zawartosc = zawartosc;
    }

    public String getNazwaPliku() { return nazwaPliku; }
    public int getNumerLinii()    { return numerLinii; }
    public String getZawartosc()  { return zawartosc; }
}
```

---

## 5. Wyjatek z referencja do kolekcji (wzor 2023/2024/2025)

Z egzaminu 2024/2025:
"Wyjatek zglaszany przez remove() gdy element nie istnieje.
Musi umozliwiac sprawdzenie zawartosci kolekcji."

```java
public class BrakElementuWyjatek extends RuntimeException {

    private final Iterable<?> zawartosc;

    public BrakElementuWyjatek(String message, Iterable<?> zawartosc) {
        super(message);
        this.zawartosc = zawartosc;
    }

    public Iterable<?> getZawartosc() {
        return zawartosc;
    }
}

// W klasie ZbiorUnikalny:
public T usun(T x) {
    for (int i = 0; i < rozmiar; i++) {
        if (dane[i].equals(x)) {
            T wynik = (T) dane[i];
            System.arraycopy(dane, i + 1, dane, i, rozmiar - i - 1);
            rozmiar--;
            return wynik;
        }
    }
    throw new BrakElementuWyjatek("Nie ma elementu: " + x, this);
    //                                                       ^^^^ przekazujemy siebie!
}

// W main:
try {
    zbior.usun("nieistniejacy");
} catch (BrakElementuWyjatek e) {
    System.out.println(e.getMessage());
    System.out.println("Zawartosc zbioru:");
    for (Object elem : e.getZawartosc()) {
        System.out.println("  " + elem);
    }
}
```

---

## 6. throws - deklaracja checked exception

Checked exceptions musza byc zadeklarowane lub obsluzone:

```java
// Metoda deklaruje ze moze rzucic wyjatek
public void czytajPlik(String nazwa) throws IOException {
    // ...
    throw new IOException("Brak pliku");
}

// Wywolujacy musi obslugiwac:
try {
    czytajPlik("dane.txt");
} catch (IOException e) {
    System.out.println("Blad: " + e.getMessage());
}
```

---

## ZADANIA

Zadania sa w [zadania.md](zadania.md).
