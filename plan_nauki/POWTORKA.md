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
