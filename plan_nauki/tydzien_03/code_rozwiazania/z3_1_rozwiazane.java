package plan_nauki.tydzien_03.code_rozwiazania;

public class z3_1_rozwiazane {

    static boolean czyParzysta(int n) {
        return n % 2 == 0;
    }

    // Sposob 1: lancuch if/else
    static int max(int a, int b, int c) {
        if (a >= b && a >= c) return a;
        if (b >= c) return b;
        return c;
    }

    // Sposob 2: zagniezdzone Math.max (krotszy)
    static int maxV2(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    static String powtorz(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(s);
        return sb.toString();
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
        System.out.println(maxV2(3, 7, 5));       // 7
        System.out.println(powtorz("abc", 3));    // abcabcabc
        System.out.println(czyPierwsza(17));      // true
        System.out.println(czyPierwsza(15));      // false
    }
}
