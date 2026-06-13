# Tydzien 7: equals(), hashCode(), toString(), Comparable<T>

## Dlaczego to jest kluczowe dla egzaminu?

Te metody sa wymagane w KAZDYM zadaniu z wlasna klasa.
Bez poprawnego equals/hashCode - HashMap i HashSet nie dzialaja.
Bez Comparable - sortowanie nie dziala.
**Na kazdym egzaminie JiMP2 jest klasa ktora musi to miec.**

---

## 1. toString() - wyswietlanie obiektu

```java
public class Student {
    private String imie;
    private String nazwisko;
    private double srednia;

    @Override
    public String toString() {
        return nazwisko + " " + imie + " (srednia: " + srednia + ")";
    }
}

Student s = new Student("Anna", "Kowalska", 4.5);
System.out.println(s);           // Kowalska Anna (srednia: 4.5)
System.out.println("Student: " + s);  // tez wywola toString()
```

---

## 2. equals() - rownowaznosc obiektow

Domyslne `==` porownuje ADRESY w pamieci (czy to ten sam obiekt).
`equals()` powinno porownywac ZAWARTOSC (czy maja te same dane).

**5 regul ktore musisz spelniac:**
1. Zwrotnosc: `x.equals(x)` zawsze `true`
2. Symetria: `x.equals(y)` == `y.equals(x)`
3. Przechodnosc: x==y i y==z to x==z
4. Spojnosc: wielokrotne wywolania zwracaja ten sam wynik
5. Null: `x.equals(null)` zawsze `false`

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;              // 1. ten sam obiekt w pamieci
    if (!(o instanceof Student)) return false; // 2. inny typ lub null
    Student s = (Student) o;               // 3. rzutowanie
    return Double.compare(s.srednia, srednia) == 0  // 4. porownaj pola
        && imie.equals(s.imie)             // String porownuj przez .equals(), NIE ==
        && nazwisko.equals(s.nazwisko);
}
```

---

## 3. hashCode() - ZLOTA ZASADA

**Jesli przeslaniasz equals() - MUSISZ przeslonic hashCode().**

Zasada: jezeli `a.equals(b)` to `a.hashCode() == b.hashCode()`.

```java
import java.util.Objects;

@Override
public int hashCode() {
    return Objects.hash(imie, nazwisko, srednia);
}
```

Dlaczego? `HashMap` i `HashSet` uzywa hashCode() do szukania obiektu.
Bez poprawnego hashCode - obiekt wrzucony do HashSet "ginie":

```java
HashSet<Student> set = new HashSet<>();
Student s1 = new Student("Anna", "Kowalska", 4.5);
set.add(s1);

Student s2 = new Student("Anna", "Kowalska", 4.5);  // ten sam student
System.out.println(set.contains(s2));
// Bez hashCode -> false (ZLE)
// Z hashCode    -> true  (DOBRZE)
```

---

## 4. Comparable<T> - naturalne sortowanie

Interfejs z jedna metoda: `int compareTo(T other)`
- Zwraca ujemne gdy `this < other`
- Zwraca 0 gdy `this == other`
- Zwraca dodatnie gdy `this > other`

```java
public class Student implements Comparable<Student> {

    @Override
    public int compareTo(Student other) {
        // Sortowanie od najwyzszej sredniej do najnizszej (malejaco)
        return Double.compare(other.srednia, this.srednia);
        //                    ^^^^^          ^^^^
        //                    odwrocona kolejnosc = malejaco
    }
}

// Po implementacji Comparable:
List<Student> lista = new ArrayList<>();
lista.add(new Student("Anna", "K", 4.5));
lista.add(new Student("Piotr", "N", 3.8));
lista.add(new Student("Maria", "W", 5.0));

Collections.sort(lista);   // uzyje compareTo()
// Wynik: Maria(5.0), Anna(4.5), Piotr(3.8)
```

---

## 5. Pelny przyklad - klasa Uczen z egzaminu 2021

```java
import java.util.Objects;

public class Uczen implements Comparable<Uczen> {
    private final String imie;
    private final String nazwisko;
    private final double sredniaOcen;

    public Uczen(String imie, String nazwisko, double sredniaOcen) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.sredniaOcen = sredniaOcen;
    }

    public String getImie() { return imie; }
    public String getNazwisko() { return nazwisko; }
    public double getSredniaOcen() { return sredniaOcen; }

    @Override
    public int compareTo(Uczen other) {
        return Double.compare(other.sredniaOcen, this.sredniaOcen); // malejaco
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Uczen)) return false;
        Uczen u = (Uczen) o;
        return Double.compare(u.sredniaOcen, sredniaOcen) == 0
            && imie.equals(u.imie)
            && nazwisko.equals(u.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, sredniaOcen);
    }

    @Override
    public String toString() {
        return nazwisko + " " + imie + " (srednia: " + sredniaOcen + ")";
    }
}
```

---

## ZADANIA

Zadania sa w [zadania.md](zadania.md).
