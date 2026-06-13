package plan_nauki.tydzien_02;

// Z2.2 - FizzBuzz
// Liczby 1-100: wielokrotnosc 3 -> "Fizz", 5 -> "Buzz", obu -> "FizzBuzz"

public class z2_2 {
    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else{
                System.out.println(i);
            }
        }
    }
}
