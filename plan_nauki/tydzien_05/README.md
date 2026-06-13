# Tydzien 5: OOP czesc 2 - Dziedziczenie i polimorfizm

## 1. Dziedziczenie (extends)

Klasa pochodna przejmuje (dziedziczy) pola i metody klasy bazowej.
Sluzy do wyrazania relacji "jest" (Kot jest Zwierzetm).

```java
// Klasa bazowa (rodzic)
public class Pojazd {
    protected String marka;    // protected = widoczne w podklasach
    protected int rokProdukcji;

    public Pojazd(String marka, int rok) {
        this.marka = marka;
        this.rokProdukcji = rok;
    }

    public void jedz() {
        System.out.println(marka + " jedzie");
    }

    @Override
    public String toString() {
        return marka + " (" + rokProdukcji + ")";
    }
}

// Klasa pochodna (dziecko) - DZIEDZICZY wszystko z Pojazd
public class Samochod extends Pojazd {
    private int liczbaDrzwi;

    public Samochod(String marka, int rok, int drzwi) {
        super(marka, rok);    // super() wywoluje konstruktor rodzica - MUSI byc pierwsza linia
        this.liczbaDrzwi = drzwi;
    }

    // Nowa metoda specyficzna dla Samochod
    public void otworzBagaznik() {
        System.out.println("Otwieram bagaz " + marka);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + liczbaDrzwi + " drzwi";
    }
}

// Uzycie:
Samochod s = new Samochod("Toyota", 2020, 4);
s.jedz();              // odziedziczone z Pojazd
s.otworzBagaznik();    // wlasne
System.out.println(s); // "Toyota (2020), 4 drzwi"
```

---

## 2. Przeslanianie metod (@Override)

Podklasa moze przedefiniowac metode rodzica:

```java
public class Motocykl extends Pojazd {
    public Motocykl(String marka, int rok) {
        super(marka, rok);
    }

    @Override
    public void jedz() {
        System.out.println(marka + " jedzie z rykiem silnika!");
    }
}

Pojazd p = new Motocykl("Harley", 2021);
p.jedz();    // wywola Motocykl.jedz() - nie Pojazd.jedz()!
```

Adnotacja `@Override` jest opcjonalna ale bardzo wskazana - kompilator sprawdzi czy naprawde przeslaniasz.

---

## 3. Polimorfizm

Kluczowa idea OOP: zmienna typu `Pojazd` moze trzymac obiekt dowolnej podklasy.
Wywolywana metoda zalezy od RZECZYWISTEGO typu obiektu, nie od typu zmiennej.

```java
Pojazd[] flota = {
    new Samochod("Toyota", 2020, 4),
    new Motocykl("Harley", 2021),
    new Samochod("BMW", 2019, 2)
};

for (Pojazd p : flota) {
    p.jedz();   // kazdy inaczej! Toyota jedzie, Harley z rykiem...
}
```

---

## 4. Klasa abstrakcyjna

Klasa abstrakcyjna nie moze byc bezposrednio stworzona (`new Figura()` to blad).
Sluzy jako szablon dla podklas. Moze miec metody abstrakcyjne - BEZ implementacji.

```java
public abstract class Figura {
    private String nazwa;

    public Figura(String nazwa) {
        this.nazwa = nazwa;
    }

    // Metoda abstrakcyjna - podklasa MUSI ja zaimplementowac
    public abstract double pole();
    public abstract double obwod();

    // Zwykla metoda - dziedziczona jak normalnie
    public String getNazwa() { return nazwa; }

    @Override
    public String toString() {
        return nazwa + ": pole=" + pole() + ", obwod=" + obwod();
    }
}

public class Kolo extends Figura {
    private double promien;

    public Kolo(double promien) {
        super("Kolo");
        this.promien = promien;
    }

    @Override
    public double pole() { return Math.PI * promien * promien; }

    @Override
    public double obwod() { return 2 * Math.PI * promien; }
}

public class Kwadrat extends Figura {
    private double bok;

    public Kwadrat(double bok) {
        super("Kwadrat");
        this.bok = bok;
    }

    @Override
    public double pole() { return bok * bok; }

    @Override
    public double obwod() { return 4 * bok; }
}

// Uzycie - polimorfizm!
Figura[] figury = {new Kolo(5), new Kwadrat(4), new Kolo(3)};
for (Figura f : figury) {
    System.out.println(f);   // kazda inaczej liczy pole i obwod
}
```

---

## 5. instanceof - sprawdzanie typu

```java
Pojazd p = new Samochod("Ford", 2020, 4);

if (p instanceof Samochod) {
    Samochod s = (Samochod) p;  // rzutowanie w dol
    s.otworzBagaznik();
}
```

---

## ZADANIA

Zadania sa w [zadania.md](zadania.md).
