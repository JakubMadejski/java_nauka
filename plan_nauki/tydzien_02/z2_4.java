package plan_nauki.tydzien_02;

// Z2.4 - Operacje na tablicy
// Tablica 8 liczb: wypisz wszystkie, sume, srednia, min, max, odwrotna kolejnosc

public class z2_4 {
    public static void main(String[] args) {
        int[] tablica = {10,12,12,23,42,1,23,45};
        int suma = 0;
        int min = 1000000;
        int max = -100000;
        for (int i = 0; i < tablica.length; i++) {
            System.out.println(tablica[i]);
            suma += tablica[i];
            if (tablica[i] > max) {
                max = tablica[i];
            }
            if (tablica[i] < min){
                min = tablica[i];
            }
        }
        System.out.println("suma:" + suma);
        System.out.println("srednia:" + (double)suma / tablica.length);
        System.out.println("Min:" + min);
        System.out.println("Max:" + max);
        for (int i = 7; i >= 0; i--) {
            System.out.println(tablica[i]);
        }
        

}
}
