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

## 4. Comparable + compareTo (WZOR EGZAMINACYJNY - 20 pkt!)

Pojawia sie prawie na kazdym egzaminie. Dostajesz klase (Uczen/Student/Produkt) i piszesz:
`compareTo` + `equals` + `hashCode` + `toString`.

`Comparable<T>` to wbudowany interfejs Javy = "te obiekty mozna sortowac".
Musisz napisac `compareTo` ktory mowi JAK je porownac.

**compareTo zwraca int:**
- ujemny -> this jest PRZED other (mniejszy)
- zero    -> rowne
- dodatni -> this jest PO other (wiekszy)

```java
class Uczen implements Comparable<Uczen> {
    private String imie, nazwisko;
    private double srednia;

    // ... konstruktor, gettery ...

    @Override
    public int compareTo(Uczen other) {
        // alfabetycznie po nazwisku - String ma swoje compareTo:
        return this.nazwisko.compareTo(other.nazwisko);

        // po liczbie ROSNACO:  Double.compare(this.srednia, other.srednia)
        // po liczbie MALEJACO: Double.compare(other.srednia, this.srednia)  <- odwrotna kolejnosc!
    }
}
```

**Sortowanie:**
```java
Collections.sort(lista);   // uzywa compareTo (Comparable)

// LUB jednorazowo, bez ruszania klasy (Comparator jako lambda):
lista.sort((a, b) -> Double.compare(b.getSrednia(), a.getSrednia())); // malejaco po sredniej
```

**Comparable vs Comparator:**
- Comparable = jeden naturalny sposob WBUDOWANY w klase (`compareTo`)
- Comparator = dodatkowy sposob podany z zewnatrz przy sortowaniu (lambda)

**Pamietaj:** liczby porownujesz przez `Double.compare(a,b)` / `Integer.compare(a,b)`,
NIE przez odejmowanie. Stringi przez `.compareTo()`.

### Sortowanie malejaco przez lambde (Comparator)
```java
// ROSNACO (domyslnie): mniejsze pierwsze
lista.sort((a, b) -> Double.compare(a.getSrednia(), b.getSrednia()));

// MALEJACO: odwracasz kolejnosc argumentow (b, a zamiast a, b)
lista.sort((a, b) -> Double.compare(b.getSrednia(), a.getSrednia()));
```
Caly trik: zamieniasz miejscami `a` i `b` w `Double.compare`. Nic wiecej.

### Jak to dziala w srodku (mechanika lambdy + compare)

`Double.compare(x, y)` patrzy na znak roznicy x i y:
- x < y  -> UJEMNY
- x == y -> 0
- x > y  -> DODATNI
(mysl o tym jak "x - y" w sensie znaku)

Lambda `(s1, s2) -> ...` to przepis: "gdy dostaniesz pare s1, s2 - tak je porownaj".
`sort` wola ja WIELOKROTNIE dla roznych par z listy i patrzy TYLKO na znak wyniku:
- wynik UJEMNY  -> s1 idzie PRZED s2
- wynik DODATNI -> s1 idzie PO s2
- wynik ZERO    -> bez roznicy

Przyklad na sredniej s1=4.5, s2=4.9:
```
malejaco: Double.compare(s2, s1) = Double.compare(4.9, 4.5) = DODATNI
          dodatni -> s1(4.5) PO s2(4.9) -> wyzsza srednia na gorze = malejaco
```
Dlatego zamiana argumentow odwraca cale sortowanie - odwraca znak wyniku.

### WAZNE - po czym sortuje Collections.sort i dwa sortowania pod rzad
- `Collections.sort(a1)` (bez lambdy) uzywa `compareTo` z klasy. NIE ma zadnego
  ukrytego "domyslnie" - sortuje po tym co napiszesz w `compareTo`. Bez `compareTo`
  w wlasnej klasie -> kod sie NIE skompiluje.
- Dwa sortowania pod rzad na tej samej liscie = lista jest ukladana dwa razy.
  Drugie NADPISUJE kolejnosc pierwszego. Zostaje wynik ostatniego sortowania.
  (jak ukladanie talii kart najpierw po kolorze, potem po wartosci - zostaje to ostatnie)

## 5. Scanner - wczytywanie od uzytkownika

```java
import java.util.Scanner;   // MUSI byc na gorze pliku

Scanner scanner = new Scanner(System.in);

int n      = scanner.nextInt();      // wczytaj int
double d   = scanner.nextDouble();   // wczytaj double
String s   = scanner.next();         // wczytaj JEDNO slowo (do spacji)
String lin = scanner.nextLine();     // wczytaj CALA linie (ze spacjami)
boolean b  = scanner.nextBoolean();  // true/false

scanner.close();   // zamknij na koncu
```

**Roznica `next()` vs `nextLine()`:**
- `next()`     -> jedno slowo, konczy na spacji. "Ala ma kota" -> tylko "Ala"
- `nextLine()` -> cala linia az do entera. "Ala ma kota" -> "Ala ma kota"

**Najczestsza PULAPKA - nextInt() a potem nextLine():**
```java
int n = scanner.nextInt();      // wczytuje liczbe, ale ZOSTAWIA enter w buforze
String s = scanner.nextLine();  // ten od razu lapie ten zostawiony enter -> PUSTY string!
```
Rozwiazanie: dodatkowy `scanner.nextLine()` po `nextInt()` zeby "skonsumowac" enter:
```java
int n = scanner.nextInt();
scanner.nextLine();             // zjada enter
String s = scanner.nextLine();  // teraz dziala
```

**Petla wczytujaca N liczb:**
```java
for (int i = 0; i < 10; i++) {
    int x = scanner.nextInt();
    // zrob cos z x
}
```

## 6. Tablica vs ArrayList - INNA SKLADNIA! (czesta pulapka)

ArrayList to NIE tablica - nie uzywasz `[]` ani `.length`, tylko METOD.

| operacja        | tablica `int[]`      | ArrayList<Integer>     |
|-----------------|----------------------|------------------------|
| rozmiar         | `t.length`           | `lista.size()`         |
| odczyt elementu | `t[i]`               | `lista.get(i)`         |
| zapis elementu  | `t[i] = x`           | `lista.set(i, x)`      |
| dodanie         | (nie da sie, staly!) | `lista.add(x)`         |
| usuniecie       | (nie da sie)         | `lista.remove(i)`      |
| czy zawiera     | (petla recznie)      | `lista.contains(x)`    |

```java
// TABLICA - staly rozmiar, skladnia z []
int[] t = new int[10];
t[0] = 5;
System.out.println(t.length);   // BEZ nawiasow!
for (int i = 0; i < t.length; i++) System.out.println(t[i]);

// ARRAYLIST - rosnie sama, skladnia z metodami
ArrayList<Integer> lista = new ArrayList<>();
lista.add(5);
System.out.println(lista.size());   // Z nawiasami!
for (int i = 0; i < lista.size(); i++) System.out.println(lista.get(i));
```

**Najczestsze bledy (mieszanie skladni):**
- `lista.length` -> ZLE, ma byc `lista.size()`
- `lista[i]` -> ZLE, ma byc `lista.get(i)`
- `t.size()` -> ZLE (tablica), ma byc `t.length`

## 7. == vs .equals() - KIEDY CO (czesty blad!)

**STRINGI i OBIEKTY -> ZAWSZE `.equals()`, NIGDY `==`**
```java
String a = "kot", b = "kot";
a == b          // ZLE - porownuje adresy w pamieci, moze dac false!
a.equals(b)     // DOBRZE - porownuje TRESC -> true
```
`==` na obiektach pyta "czy to ten SAM obiekt w pamieci", a nie "czy maja te sama tresc".
Dlatego na Stringach prawie zawsze chcesz `.equals()`.

**LICZBY (int, double) -> `==` jest OK**
```java
int x = 5;
x == 5          // DOBRZE - prymitywy porownujesz przez ==
```

**ENUM -> `==` jest OK (i zalecane!)**
```java
kategoria == Kategoria.ELEKTRONIKA   // DOBRZE
```
Enum ma tylko jedna instancje kazdej wartosci, wiec `==` dziala i jest czytelniejsze.

**Sciaga:**
| typ              | porownanie     |
|------------------|----------------|
| int, double      | `==`           |
| String           | `.equals()`    |
| wlasne obiekty   | `.equals()`    |
| enum             | `==`           |

## 8. Kolekcje - ktora kiedy (HashMap vs HashSet vs ArrayList)

| chce...                                      | uzyj         |
|----------------------------------------------|--------------|
| przypisac X do Y (slowo -> licznik)          | `HashMap`    |
| trzymac UNIKALNE elementy (bez duplikatow)   | `HashSet`    |
| liste z kolejnoscia i duplikatami            | `ArrayList`  |

- **HashMap** = pary KLUCZ -> WARTOSC. Dwie informacje na element.
  `HashMap<String,Integer>` -> "ala" -> 2
- **HashSet** = zbior bez duplikatow. Jedna informacja na element.
  `HashSet<Punkt>` -> {Punkt(3,4), Punkt(1,2)}
- **ArrayList** = lista po kolei, moze miec duplikaty, ma indeksy.

**Kiedy HashSet a nie HashMap?**
Gdy zalezy Ci TYLKO na unikalnosci (czy element sie powtarza), a nie masz
zadnej wartosci do przypisania. Np. "czy te dwa punkty sa duplikatami" -> HashSet.
W HashMap musialbys wymyslac sztuczna wartosc - bez sensu.

Ciekawostka: HashSet w srodku JEST zbudowany na HashMap (trzyma elementy jako
klucze, wartosc ignoruje). To ta sama rodzina.

**HashSet wymaga equals + hashCode!** Bez nich nie rozpozna duplikatow wlasnych
obiektow (patrz sekcja 9).

## 9. equals + hashCode - SZABLON NA PAMIEC (fundament egzaminu!)

Domyslnie Java porownuje obiekty przez ADRES w pamieci. Dwa `Punkt(1,2)` sa
"rozne" mimo tych samych liczb. `equals` pozwala zdefiniowac wlasna rownosc.

**SZABLON equals - zawsze taki sam, zmieniasz tylko nazwe klasy i pola:**
```java
import java.util.Objects;

@Override
public boolean equals(Object o) {          // ZAWSZE Object (nie nazwa klasy!)
    if (this == o) return true;            // ten sam obiekt
    if (!(o instanceof Punkt)) return false; // <- tu nazwa Twojej klasy
    Punkt p = (Punkt) o;                   // rzutowanie
    return this.x == p.x && this.y == p.y; // <- tu Twoje pola
}

@Override
public int hashCode() {
    return Objects.hash(x, y);             // <- te same pola co w equals!
}
```

**ZASADY (czesto na egzaminie):**
- `equals` ZAWSZE bierze `Object o`, nie nazwe klasy. Inaczej nie nadpisuje
  prawdziwego equals (i `@Override` krzyczy bledem).
- `equals` i `hashCode` ZAWSZE razem i z TYCH SAMYCH pol. Jak equals porownuje
  x i y, to hashCode tez liczy z x i y.
- Stringi w equals porownuj przez `Objects.equals(a, b)` (bezpieczne na null),
  liczby przez `==`.
- `hashCode` to zawsze `Objects.hash(pole1, pole2, ...)`.

**Po co hashCode razem z equals?** HashSet/HashMap najpierw grupuja obiekty po
hashCode (szybko), potem potwierdzaja equals. Jak dwa obiekty sa rowne ale maja
rozny hashCode -> HashSet ich nie rozpozna jako duplikaty. Dlatego MUSZA pasowac.
