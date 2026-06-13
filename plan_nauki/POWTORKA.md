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
