# Tydzien 10: Wzorzec projektowy State (Stan)

## Pojawia sie na egzaminie 2021 i 2025 - DOKLADNIE ta sama Figura!

---

## 1. Problem - switch i jego wady

```java
public class Figura {
    public static final int KOLO = 1;
    public static final int TROJKAT = 2;
    public static final int KWADRAT = 3;

    private final String nazwa;
    private final double wielkosc;
    private final int rodzaj;

    public double obwod() {
        switch (rodzaj) {               // PROBLEM: przy nowym ksztalcie
            case KOLO: return 2 * Math.PI * wielkosc;  // musisz modyfikowac
            case TROJKAT: return 3 * wielkosc;          // ta klase!
            case KWADRAT: return 4 * wielkosc;
            default: throw new IllegalStateException("nieznana figura");
        }
    }
}
```

Wada: dodanie nowego ksztaltu wymaga modyfikacji klasy `Figura` (naruszenie OCP).

---

## 2. Rozwiazanie: wzorzec State

**Krok 1** - Stworz interfejs reprezentujacy stan (ksztalt):

```java
public interface KsztaltFigury {
    double obliczObwod(double wielkosc);
}
```

**Krok 2** - Stworz klasy dla kazdego stanu:

```java
public class Kolo implements KsztaltFigury {
    @Override
    public double obliczObwod(double wielkosc) {
        return 2 * Math.PI * wielkosc;
    }
}

public class Trojkat implements KsztaltFigury {
    @Override
    public double obliczObwod(double wielkosc) {
        return 3 * wielkosc;
    }
}

public class Kwadrat implements KsztaltFigury {
    @Override
    public double obliczObwod(double wielkosc) {
        return 4 * wielkosc;
    }
}
```

**Krok 3** - Klasa Figura trzyma referencje do interfejsu:

```java
public class Figura {
    private final String nazwa;
    private final double wielkosc;
    private KsztaltFigury rodzaj;    // <-- referencja do stanu

    public Figura(String nazwa, KsztaltFigury rodzaj, double wielkosc) {
        this.nazwa = nazwa;
        this.rodzaj = rodzaj;
        this.wielkosc = wielkosc;
    }

    // Zadnego switch! Delegujemy do stanu
    public double obwod() {
        return rodzaj.obliczObwod(wielkosc);
    }

    // Stan moze sie zmieniac
    public void zmienRodzaj(KsztaltFigury nowyRodzaj) {
        this.rodzaj = nowyRodzaj;
    }
}
```

**Uzycie:**

```java
Figura f1 = new Figura("kolo", new Kolo(), 5.0);
Figura f2 = new Figura("kwadrat", new Kwadrat(), 4.0);

System.out.println(f1.obwod());   // 31.41...
System.out.println(f2.obwod());   // 16.0

// Nowy ksztalt - BEZ modyfikacji Figura!
public class Prostokat implements KsztaltFigury {
    public double obliczObwod(double wielkosc) { return 4 * wielkosc; }
}
```

---

## 3. Wzorzec State dla Gracza (egzamin 2021 Grp A)

```java
// Interfejs stanu
public interface StatusGracza {
    void ruch(Gracz gracz);
    void skok(Gracz gracz);
    void cios(Gracz gracz);
}

// Konkretny stan
public class Aktywny implements StatusGracza {
    @Override
    public void ruch(Gracz gracz) {
        System.out.println("Biega szybko");
    }
    @Override
    public void skok(Gracz gracz) {
        System.out.println("Skacze wysoko");
    }
    @Override
    public void cios(Gracz gracz) {
        System.out.println("Pelny cios!");
        gracz.setStatus(new Ranny());  // zmiana stanu od wewnatrz
    }
}

public class Ranny implements StatusGracza {
    @Override
    public void ruch(Gracz gracz) {
        System.out.println("Kuleje, porusza sie wolno");
    }
    @Override
    public void skok(Gracz gracz) {
        System.out.println("Nie moze skoczyc");
    }
    @Override
    public void cios(Gracz gracz) {
        System.out.println("Slaby cios");
    }
}

// Klasa glowna
public class Gracz {
    private String imie;
    private StatusGracza status;

    public Gracz(String imie) {
        this.imie = imie;
        this.status = new Aktywny();  // stan poczatkowy
    }

    // Metody deleguja do stanu
    public void ruch() { status.ruch(this); }
    public void skok() { status.skok(this); }
    public void cios() { status.cios(this); }

    // Zmiana stanu
    public void setStatus(StatusGracza nowyStatus) {
        this.status = nowyStatus;
    }
}
```

---

## 4. Teoria: co to jest wzorzec projektowy?

Wzorzec projektowy to sprawdzone rozwiazanie czesto wystepujacego problemu projektowego.

**3 kategorie:**
- **Kreacyjne**: jak tworzyc obiekty (Singleton, Factory)
- **Strukturalne**: jak laczyc klasy (Adapter, Decorator)
- **Behawioralne**: jak obiekty wspolpracuja (State, Observer, Command)

**State (Stan)** - behawioralny:
Zachowanie obiektu zalezne od jego stanu, ktory moze sie zmieniac.
Zamiast if/switch - kazdy stan to oddzielna klasa implementujaca interfejs.

---

## ZADANIA

Zadania sa w [zadania.md](zadania.md).
