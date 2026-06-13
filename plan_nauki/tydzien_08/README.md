# Tydzien 8: Wlasne kolekcje + Iterable<T>

## Dlaczego to jest najwazniejszy tydzien?

**To jest najczestsze zadanie na egzaminie JiMP2 - pojawia sie CO ROKU, warte 20-25 pkt.**
Lista<Osoba>, SparseVector, SparseColumn, SList, Koszyk - rozne nazwy, ten sam schemat.
Naucz sie go na pamiec.

---

## 1. Co to jest Iterable i po co?

Petla for-each dziala tylko na obiektach ktore implementuja `Iterable<T>`:

```java
for (String s : lista) { ... }
// Java tlumaczy to wewnatrz na:
Iterator<String> it = lista.iterator();
while (it.hasNext()) {
    String s = it.next();
    ...
}
```

Zeby Twoja kolekcja dzialala w for-each - musi implementowac `Iterable<T>`.

---

## 2. Dwa interfejsy do opanowania

```java
// Iterable - Twoja klasa implementuje to
public interface Iterable<T> {
    Iterator<T> iterator();  // zwroc iterator
}

// Iterator - obiekt ktory "chodzi" po kolekcji
public interface Iterator<T> {
    boolean hasNext();  // czy sa jeszcze elementy?
    T next();           // zwroc nastepny i przesun sie
}
```

---

## 3. SCHEMAT DO ZAPAMIECIA - wlasna kolekcja egzaminowa

Zawsze uzywaj wewnetrznej tablicy. Szybka i prosta.

```java
import java.util.Iterator;
import java.util.Objects;

public class MojaLista<T> implements Iterable<T> {

    private Object[] dane;     // tablica wewnetrzna
    private int rozmiar;
    private static final int MAX = 100;

    public MojaLista() {
        dane = new Object[MAX];
        rozmiar = 0;
    }

    // Dodaj element
    public void dodaj(T x) {
        if (x == null) throw new IllegalArgumentException("null nie dozwolony");
        dane[rozmiar++] = x;
    }

    // Usun element (pierwszy znaleziony)
    public void usun(T x) {
        for (int i = 0; i < rozmiar; i++) {
            if (dane[i].equals(x)) {
                System.arraycopy(dane, i + 1, dane, i, rozmiar - i - 1);
                rozmiar--;
                return;
            }
        }
    }

    public int rozmiar() { return rozmiar; }

    // KLUCZ: Iterator jako anonimowa klasa wewnatrz iterator()
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int idx = 0;

            @Override
            public boolean hasNext() {
                return idx < rozmiar;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                return (T) dane[idx++];
            }
        };
    }

    // toString przez Iterable (wazne - tak wymaga egzamin!)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (T elem : this) {   // uzywa wlasnego iteratora przez for-each
            sb.append(elem).append(", ");
        }
        if (rozmiar > 0) sb.setLength(sb.length() - 2);  // usun ostatni ", "
        sb.append("]");
        return sb.toString();
    }
}
```

---

## 4. Unikalna kolekcja (bez duplikatow - CZESTO NA EGZAMINIE)

Zmien tylko metode `dodaj()`:

```java
public void dodaj(T x) {
    if (x == null) throw new IllegalArgumentException("null nie dozwolony");
    for (int i = 0; i < rozmiar; i++) {
        if (dane[i].equals(x)) return;  // juz jest - ignoruj
    }
    dane[rozmiar++] = x;
}
```

Przyklady z egzaminow: SparseVector, SparseColumn, Koszyk - wszystkie bez duplikatow.

---

## 5. equals() dla kolekcji iterowanej (trudne - z egzaminow 2023/2024/2025)

Pytanie: "metoda equals zwracajaca true jesli argument jest Iterable z identycznym zestawem obiektow"

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Iterable)) return false;

    // Zbierz elementy z o
    java.util.Set<Object> inny = new java.util.HashSet<>();
    for (Object elem : (Iterable<?>) o) {
        inny.add(elem);
    }

    // Porownaj
    if (inny.size() != rozmiar) return false;
    for (int i = 0; i < rozmiar; i++) {
        if (!inny.contains(dane[i])) return false;
    }
    return true;
}

@Override
public int hashCode() {
    int hash = 0;
    for (int i = 0; i < rozmiar; i++) {
        hash += dane[i].hashCode();  // suma - kolejnosc nie ma znaczenia
    }
    return hash;
}
```

---

## 6. Pelny przyklad z egzaminu 2021: Lista<Osoba>

```java
public class Lista implements Iterable<Osoba> {

    private Object[] dane = new Object[100];
    private int rozmiar = 0;

    public void dodaj(Osoba x) {
        if (x == null) throw new IllegalArgumentException();
        dane[rozmiar++] = x;
    }

    public void usun(Osoba x) {
        for (int i = 0; i < rozmiar; i++) {
            if (dane[i].equals(x)) {
                System.arraycopy(dane, i + 1, dane, i, rozmiar - i - 1);
                rozmiar--;
                return;
            }
        }
    }

    public int liczbOsob() { return rozmiar; }

    @Override
    public Iterator<Osoba> iterator() {
        return new Iterator<Osoba>() {
            int idx = 0;
            public boolean hasNext() { return idx < rozmiar; }
            public Osoba next() { return (Osoba) dane[idx++]; }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Osoba o : this) {    // uzywa iteratora - tak chce egzamin!
            sb.append(o).append("\n");
        }
        return sb.toString();
    }
}
```

---

## ZADANIA

Zadania sa w [zadania.md](zadania.md).
