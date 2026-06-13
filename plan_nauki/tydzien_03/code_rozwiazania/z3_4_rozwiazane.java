package plan_nauki.tydzien_03.code_rozwiazania;

public class z3_4_rozwiazane {

    // Sposob 1: rekurencja
    static int sumaCyfr(int n) {
        n = Math.abs(n); // ujemne tez dzialaja
        if (n < 10) return n;
        return n % 10 + sumaCyfr(n / 10);
    }

    // Sposob 2: iteracja (petla while)
    static int sumaCyfrIteracyjnie(int n) {
        n = Math.abs(n);
        int suma = 0;
        while (n > 0) {
            suma += n % 10;
            n /= 10;
        }
        return suma;
    }

    // Sposob 1: rekurencja
    static String odwroc(String s) {
        if (s.isEmpty()) return "";
        return odwroc(s.substring(1)) + s.charAt(0);
    }

    // Sposob 2: StringBuilder (efektywniejszy, bez rekurencji)
    static String odwrocIteracyjnie(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(sumaCyfr(1234));              // 10
        System.out.println(sumaCyfrIteracyjnie(1234));   // 10
        System.out.println(odwroc("abcde"));             // edcba
        System.out.println(odwrocIteracyjnie("abcde"));  // edcba
    }
}
