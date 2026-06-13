package plan_nauki.tydzien_02.code_rozwiazania;

public class z2_4_rozwiazane {
    public static void main(String[] args) {
        int[] t = {5, 3, 8, 1, 9, 2, 7, 4};

        // wypisz wszystkie
        System.out.print("Tablica: ");
        for (int x : t) System.out.print(x + " ");
        System.out.println();

        // suma i srednia
        int suma = 0;
        for (int x : t) suma += x;
        System.out.println("Suma: " + suma);
        System.out.printf("Srednia: %.2f%n", (double) suma / t.length);

        // min i max - sposob 1: inicjalizacja pierwszym elementem
        int min = t[0], max = t[0];
        for (int x : t) {
            if (x < min) min = x;
            if (x > max) max = x;
        }
        System.out.println("Min: " + min + ", Max: " + max);

        // odwrotna kolejnosc - sposob 1: nowa tablica
        int[] odwrocona = new int[t.length];
        for (int k = 0; k < t.length; k++) {
            odwrocona[k] = t[t.length - 1 - k];
        }
        System.out.print("Odwrocona: ");
        for (int x : odwrocona) System.out.print(x + " ");
        System.out.println();

        // odwrotna kolejnosc - sposob 2: zamiana elementow w miejscu
        for (int lo = 0, hi = t.length - 1; lo < hi; lo++, hi--) {
            int tmp = t[lo];
            t[lo] = t[hi];
            t[hi] = tmp;
        }
        System.out.print("Odwrocona w miejscu: ");
        for (int x : t) System.out.print(x + " ");
        System.out.println();
    }
}
