package plan_nauki.tydzien_03;

// Z3.2 - Kalkulator z metodami
// dodaj, odejmij, pomnoz, podziel(double, double) - uwazaj na dzielenie przez zero

public class z3_2 {

    static double dodaj(double a, double b) {
        return a+b;
    }

    static double odejmij(double a, double b) {
        return a-b; 
    }

    static double pomnoz(double a, double b) {
        return a*b; 
    }

    static double podziel(double a, double b) {
        if (b==0) {
            return 0;
        }
        return a/b; 
    }

    public static void main(String[] args) {
        System.out.println(dodaj(1,5));
        System.out.println(odejmij(1,9));
        System.out.println(pomnoz(5,5));
        System.out.println(podziel(10,2));
        System.out.println(podziel(10,3));
        System.out.println(podziel(10,0));
        System.out.println(podziel(0,2));
    }
}
