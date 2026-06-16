# Powtórka — rzeczy które mnie wywaliły

## 1. println vs printf

`println` — wypisuje wartość bezpośrednio, bez formatowania:
```java
System.out.println(3.14159);   // 3.14159
System.out.println("tekst");   // tekst
```

`printf` — pierwszy argument to ZAWSZE format, potem wartości:
```java
System.out.printf("%.1f%n", 3.14159);       // 3.1
System.out.printf("%d + %d = %d%n", 2, 3, 5); // 2 + 3 = 5
```

Formaty:
- `%d`   — int
- `%f`   — double (6 miejsc domyślnie)
- `%.2f` — double z 2 miejscami po przecinku
- `%s`   — String
- `%n`   — nowa linia

**Pułapka:** `System.out.printf(jakasCyferka)` — błąd kompilacji, zawsze potrzebny format.

## 2. Metody na Stringu

```java
String s = "abcdef";

s.length()        // 6 — długość
s.charAt(0)       // 'a' — znak na indeksie (char, nie String!)
s.substring(1)    // "bcdef" — od indeksu 1 do końca
s.substring(1, 4) // "bcd" — od 1 do 4 (4 nie włącznie)
s.equals("abc")   // porównanie — NIGDY nie używaj ==
s.contains("bc")  // true — czy zawiera
s.indexOf("c")    // 2 — indeks pierwszego wystąpienia (-1 jeśli brak)
s.toUpperCase()   // "ABCDEF"
s.toLowerCase()   // "abcdef"
s.trim()          // usuwa białe znaki z początku i końca
s.split(" ")      // tablica String[] po podziale na spacje
s.isEmpty()       // true jeśli ""
```

**Pułapka:** `charAt()` zwraca `char`, nie `String`. Żeby dodać do Stringa: `"" + s.charAt(0)` lub `String.valueOf(s.charAt(0))`.

## 3. Klasy abstrakcyjne i polimorfizm

**Pola zawsze `private`** (egzamin tego wymaga). Klasa abstrakcyjna i tak ma do nich dostęp przez metody, a podklasy przez konstruktor `super(...)`.

Szkielet:
```java
abstract class Zwierze {
    private String imie;      // private!
    private int wiek;

    public Zwierze(String imie, int wiek) {  // konstruktor BEZ slowa "class"
        this.imie = imie;
        this.wiek = wiek;
    }

    abstract String dzwiek();  // bez ciala, sam srednik - podklasa musi napisac

    public void przedstawSie() {  // wspolna metoda - ma cialo, wola dzwiek()
        System.out.println("Jestem " + imie + ", mowie " + dzwiek());
    }
}

class Pies extends Zwierze {
    public Pies(String imie, int wiek) {
        super(imie, wiek);     // MUSI przekazac do rodzica - inaczej blad kompilacji
    }
    @Override
    String dzwiek() { return "hau"; }   // nadpisuje po swojemu
}
```

### Petla polimorficzna (tablica typu nadrzednego, rozne obiekty)
```java
Zwierze[] zwierzeta = {
    new Pies("Rex", 3),
    new Kot("Mruczek", 5),
    new Krowa("Basia", 4)
};
for (Zwierze z : zwierzeta) {
    z.przedstawSie();   // kazdy wola SWOJ dzwiek() - to jest polimorfizm
}
```

**Czemu to dziala:** tablica jest typu `Zwierze[]`, ale trzyma psy/koty/krowy. W petli `z.dzwiek()` automatycznie wybiera wersje z wlasciwej podklasy. Jeden kod obsluguje wszystkie typy.

**3 najczestsze bledy:**
- konstruktor podklasy bez `super(...)` -> blad kompilacji
- metoda abstrakcyjna z cialem `{ }` -> ma byc sam srednik
- `new Zwierze(...)` -> NIE WOLNO, klasy abstrakcyjnej nie da sie stworzyc
