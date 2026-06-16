package plan_nauki.tydzien_06;
import java.util.ArrayList;

// Z6.1 - Interfejs Ksztalt
// interface Ksztalt { double pole(); double obwod(); }
// Implementacje: Kolo(r), Prostokat(a, b), Trojkat(a, b, c)
// Stworz List<Ksztalt> i wypisz te o polu > 10

public class z6_1 {
    public static void main(String[] args) {
        ArrayList<Ksztalt> a1 = new ArrayList<>();
        a1.add(new Kolo(4));            // pole ~50
        a1.add(new Prostokat(2, 3));    // pole 6
        a1.add(new Trojkat(6, 8, 10));  // pole 24
        a1.add(new Prostokat(5, 5));    // pole 25
        a1.add(new Kolo(1));            // pole ~3

        System.out.println("Ksztalty o polu > 10:");
        for (Ksztalt k : a1) {
            if (k.pole() > 10) {
                System.out.printf("  pole=%.2f, obwod=%.2f%n", k.pole(), k.obwod());
            }
        }
    }
}

interface Ksztalt {
    double pole();
    double obwod();
}

class Kolo implements Ksztalt {
    private double r;
    public Kolo(double r) {
        this.r = r;
    }
    public double pole()   { 
        return 3.14*r*r; /* TODO */ 
    }
    public double obwod()  { 
        return 2*3.14*r; /* TODO */ 
    }
}

class Prostokat implements Ksztalt {
    private double a;
    private double b;
    public Prostokat(double a, double b){
        this.a = a;
        this.b = b;
    }
    public double pole()   { 
        return a*b; /* TODO */ 
    }
    public double obwod()  { 
        return 2*(a+b); /* TODO */ 
    }
}

class Trojkat implements Ksztalt {
    private double a;
    private double b;
    private double c;
    public Trojkat(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double pole()   {
        double s = (a + b + c) / 2;          // polowa obwodu
        return Math.sqrt(s*(s-a)*(s-b)*(s-c)); // wzor Herona
    }
    public double obwod()  {
        return a+b+c;
    }
}
