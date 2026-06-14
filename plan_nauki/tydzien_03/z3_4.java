package plan_nauki.tydzien_03;

// Z3.4 - Rekurencja
// sumaCyfr(int n): suma cyfr liczby, np. 1234 -> 10
// odwroc(String s): odwraca string, np. "abc" -> "cba"

public class z3_4 {

    static int sumaCyfr(int n) {
        if (n ==0) {
            return 0;
        }
        return n % 10 + sumaCyfr(n/10);
    }   

    static String odwroc(String s) {
        if (s.isEmpty()) {
            return "";
        }
        return odwroc(s.substring(1)) + s.charAt(0); // TODO: pierwsza litera + odwrocona reszta
    }

    public static void main(String[] args) {
        System.out.println(sumaCyfr(1234));
        System.out.println(odwroc("abcdefghijklmn"));
    }
}