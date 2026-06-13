# Tydzien 4: OOP czesc 1 - Klasy, obiekty, hermetyzacja

## Po co OOP?

Do tej pory pisales wszystko w jednej klasie ze statycznymi metodami.
OOP pozwala grupowac dane i metody w jeden obiekt - model rzeczywistosci.

Zamiast: 5 oddzielnych zmiennych opisujacych samochod
OOP: jeden obiekt `Auto` ktory ma swoje dane i metody

---

## 1. Klasa i obiekt

```java
// Definicja klasy - szablon
public class Auto {
    // POLA (cechy obiektu)
    String marka;
    int rokProdukcji;
    double przebieg;

    // METODY (zachowania obiektu)
    void jedz(double km) {
        przebieg += km;
        System.out.println("Jade " + km + "km. Przebieg: " + przebieg);
    }

    void wypisz() {
        System.out.println(marka + " (" + rokProdukcji + "), przebieg: " + przebieg);
    }
}

// Tworzenie obiektow (instancji klasy)
public class Main {
    public static void main(String[] args) {
        Auto a1 = new Auto();      // new tworzy obiekt
        a1.marka = "Toyota";
        a1.rokProdukcji = 2020;
        a1.przebieg = 15000;

        Auto a2 = new Auto();      // drugi, niezalezny obiekt
        a2.marka = "BMW";
        a2.rokProdukcji = 2018;

        a1.jedz(200);              // wywolanie metody na konkretnym obiekcie
        a1.wypisz();
        a2.wypisz();
    }
}
```

---

## 2. Konstruktor

Konstruktor to specjalna metoda wywolywana przy `new`. Inicjalizuje obiekt.

```java
public class Auto {
    String marka;
    int rokProdukcji;
    double przebieg;

    // Konstruktor - ta sama nazwa co klasa, brak zwracanego typu
    public Auto(String marka, int rokProdukcji) {
        this.marka = marka;               // this = "ten konkretny obiekt"
        this.rokProdukcji = rokProdukcji;
        this.przebieg = 0;                // domyslny przebieg
    }

    // Mozna miec kilka konstruktorow (rozne parametry)
    public Auto(String marka) {
        this(marka, 2024);  // wywoluje powyzszy konstruktor
    }
}

// Teraz tworzenie wyglaada tak:
Auto a = new Auto("Honda", 2019);    // OK
Auto b = new Auto("Fiat");           // OK - rok bedzie 2024
// Auto c = new Auto();              // BLAD - nie ma konstruktora bez parametrow!
```

---

## 3. Hermetyzacja (private + gettery/settery)

Problem z publicznymi polami: ktos moze wpisac bzdury (`a.przebieg = -500`).
Rozwiazanie: ukryj pola za `private`, udostepnij je przez metody.

```java
public class BankAccount {

    private String owner;    // private = nikt spoza klasy nie dotknie bezposrednio
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        // Sprawdzamy juz w konstruktorze
        if (initialBalance < 0) throw new IllegalArgumentException("Saldo nie moze byc ujemne");
        this.balance = initialBalance;
    }

    // Getter - tylko do odczytu
    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    // Metody biznesowe zamiast settera - zawieraja logike
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Kwota musi byc dodatnia");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Kwota musi byc dodatnia");
        if (amount > balance) throw new IllegalStateException("Brak srodkow");
        balance -= amount;
    }
}

// Uzycie:
BankAccount konto = new BankAccount("Kuba", 1000);
konto.deposit(500);
konto.withdraw(200);
System.out.println(konto.getBalance());    // 1300

// konto.balance = -9999;   // BLAD KOMPILACJI - private!
```

---

## 4. Metoda toString()

Kazda klasa moze przeslonic `toString()` - to co zwroci uzyje sie przy `println`.

```java
public class Auto {
    private String marka;
    private int rok;

    public Auto(String marka, int rok) {
        this.marka = marka;
        this.rok = rok;
    }

    @Override
    public String toString() {
        return marka + " (" + rok + ")";
    }
}

Auto a = new Auto("Honda", 2019);
System.out.println(a);              // "Honda (2019)" - java wywola toString() automatycznie
String s = "Moje auto: " + a;      // tez wywola toString()
```

---

## 5. Pole statyczne vs instancyjne

```java
public class Player {
    private String name;           // instancyjne - kazdy gracz ma swoje
    private static int count = 0;  // statyczne - wspolne dla wszystkich graczy

    public Player(String name) {
        this.name = name;
        count++;    // przy kazdym new Player()
    }

    public String getName() { return name; }
    public static int getCount() { return count; }
}

Player p1 = new Player("Kuba");
Player p2 = new Player("Anna");
System.out.println(Player.getCount());  // 2 - wywolujemy na klasie, nie obiekcie
System.out.println(p1.getName());       // "Kuba" - wywolujemy na obiekcie
```

---

## ZADANIA

Zadania sa w [zadania.md](zadania.md).
