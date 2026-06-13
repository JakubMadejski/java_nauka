# Tydzien 2: Warunki, petle, tablice

## 1. Instrukcja if/else

```java
int wiek = 20;

if (wiek >= 18) {
    System.out.println("Pelnoletni");
} else if (wiek >= 13) {
    System.out.println("Nastolatek");
} else {
    System.out.println("Dziecko");
}

// Operator logiczny AND (i), OR (lub), NOT (nie)
boolean czyDeszcz = true;
boolean czyWiatr = false;

if (czyDeszcz && czyWiatr) {
    System.out.println("Burza");
} else if (czyDeszcz || czyWiatr) {
    System.out.println("Zla pogoda");
} else {
    System.out.println("Ladna pogoda");
}
```

---

## 2. Switch

```java
int dzien = 3;

switch (dzien) {
    case 1:
        System.out.println("Poniedzialek");
        break;   // WAZNE: bez break przejdzie do nastepnego case!
    case 2:
        System.out.println("Wtorek");
        break;
    case 3:
        System.out.println("Sroda");
        break;
    default:
        System.out.println("Inny dzien");
}
```

---

## 3. Petla for

```java
// Klasyczna petla for
for (int i = 0; i < 5; i++) {
    System.out.println("Iteracja: " + i);  // 0, 1, 2, 3, 4
}

// Odliczanie wstecz
for (int i = 10; i > 0; i--) {
    System.out.print(i + " ");  // 10 9 8 7 6 5 4 3 2 1
}

// Petla z krokiem 2
for (int i = 0; i <= 20; i += 2) {
    System.out.print(i + " ");  // 0 2 4 6 8 10 12 14 16 18 20
}
```

---

## 4. Petla while i do-while

```java
// while - sprawdza warunek PRZED kazdym obiegiem
int n = 1;
while (n <= 5) {
    System.out.println(n);
    n++;
}

// do-while - wykonuje sie PRZYNAJMNIEJ raz
int x;
do {
    System.out.print("Podaj liczbe > 0: ");
    x = scanner.nextInt();
} while (x <= 0);  // powtarzaj dopoki podaja zle dane
System.out.println("Podales: " + x);
```

---

## 5. break i continue

```java
// break - przerywa petle
for (int i = 0; i < 100; i++) {
    if (i == 5) break;  // zatrzymaj sie na 5
    System.out.print(i + " ");  // 0 1 2 3 4
}

// continue - pomija biezaca iteracje, idzie do nastepnej
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) continue;  // pom par
    System.out.print(i + " ");  // 1 3 5 7 9
}
```

---

## 6. Tablice (Arrays)

```java
// Deklaracja i inicjalizacja
int[] liczby = new int[5];        // tablica 5 intow, wszystkie = 0
liczby[0] = 10;
liczby[1] = 20;
liczby[2] = 30;
// liczby[3] i liczby[4] nadal = 0

// Inicjalizacja od razu
int[] oceny = {5, 4, 3, 5, 4, 2};

// Dlugosc tablicy
System.out.println(oceny.length);   // 6

// Petla po tablicy
for (int i = 0; i < oceny.length; i++) {
    System.out.println("oceny[" + i + "] = " + oceny[i]);
}

// Petla for-each (prostrza, jesli nie potrzebujesz indeksu)
for (int o : oceny) {
    System.out.print(o + " ");
}

// Tablica stringow
String[] imiona = {"Anna", "Piotr", "Zofia"};
for (String imie : imiona) {
    System.out.println(imie);
}
```

---

## 7. Tablice - czeste operacje

```java
int[] t = {5, 2, 8, 1, 9, 3};

// Szukanie maksimum
int max = t[0];
for (int x : t) {
    if (x > max) max = x;
}
System.out.println("Max: " + max);  // 9

// Suma elementow
int suma = 0;
for (int x : t) {
    suma += x;
}
System.out.println("Suma: " + suma);

// Sortowanie (biblioteczna metoda)
import java.util.Arrays;
Arrays.sort(t);
System.out.println(Arrays.toString(t));  // [1, 2, 3, 5, 8, 9]
```

---

## ZADANIA

Zadania sa w [zadania.md](zadania.md).
