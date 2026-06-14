package plan_nauki.tydzien_03;

// Z3.3 - Przeciazanie: metoda pole()
// pole(double r)           -> kolo: PI * r * r
// pole(double a, double b) -> prostokat: a * b
// pole(double a, double b, double c) -> trojkat wzorem Herona

public class z3_3 {

    static double pole(double r) {
        return (3.14)*r*r;
    }

    static double pole(double a, double b) {
        return a*b; 
    }

    static double pole(double a, double b, double c) {
        double s = (a+b+c)/2;
        System.out.println(s);
        return Math.sqrt(s*(s-a)*(s-b)*(s-c)); // TODO wzor Herona: s=(a+b+c)/2, pole=sqrt(s*(s-a)*(s-b)*(s-c))
    }

    public static void main(String[] args) {
        System.out.println(pole(10,2));
        System.out.println(pole(10));
        System.out.println(pole(4,5,6));
    }
}
