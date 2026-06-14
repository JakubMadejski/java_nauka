package plan_nauki.tydzien_03;

// Z3.1 - Podstawowe metody (static)
// czyParzysta(int n), max(int a, int b, int c), powtorz(String s, int n), czyPierwsza(int n)

public class z3_1 {

    static boolean czyParzysta(int n) {
        if (n % 2 == 0 ) {
            return true;
        } else {
            return false;
        }
    }

    static int max(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;

    }

    static String powtorz(String s, int n) {
        if (n <= 0){
            return "";
        }
        return s + powtorz(s, n-1);
    }

    static boolean czyPierwsza(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(czyParzysta(4));       // true
        System.out.println(czyParzysta(7));       // false
        System.out.println(max(3, 7, 5));         // 7
        System.out.println(powtorz("abc", 3));    // abcabcabc
        System.out.println(powtorz("abc", 0));    // (pusty)
        System.out.println(czyPierwsza(17));      // true
        System.out.println(czyPierwsza(15));      // false
        System.out.println(czyPierwsza(1));       // false
    }
}
