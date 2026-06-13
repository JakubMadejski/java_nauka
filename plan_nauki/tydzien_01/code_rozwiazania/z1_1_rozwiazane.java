package plan_nauki.tydzien_01.code_rozwiazania;

public class z1_1_rozwiazane {
    public static void main(String[] args) {
        String imie = "Jan";
        String nazwisko = "Kowalski";
        int wiek = 22;
        int wzrost = 183;
        double srednia = 4.5;

        // Sposob 1: konkatenacja stringow
        System.out.println("Nazywam sie " + imie + " " + nazwisko
                + ", mam " + wiek + " lat, wzrost " + wzrost + "cm, srednia " + srednia);

        // Sposob 2: printf - czytelniejszy przy wielu zmiennych
        System.out.printf("Nazywam sie %s %s, mam %d lat, wzrost %dcm, srednia %.1f%n",
                imie, nazwisko, wiek, wzrost, srednia);

        System.out.println("Wzrost powyzej 170cm: " + (wzrost > 170));
    }
}
