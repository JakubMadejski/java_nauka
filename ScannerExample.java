import java.util.Scanner; // 1. Importowanie narzędzia z biblioteki standardowej

public class ScannerExample {
    public static void main(String[] args) {
        // 2. Tworzenie obiektu (instancji) klasy Scanner
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj swoje imię: ");
        String name = scanner.nextLine(); // 3. Pobranie całej linijki tekstu

        System.out.print("Podaj swój wiek: ");
        int age = scanner.nextInt(); // 4. Pobranie liczby całkowitej (int)

        // 5. Łączenie tekstu ze zmiennymi (konkatenacja)
        System.out.println("Witaj " + name + "! Za rok będziesz mieć " + (age + 1) + " lat.");

        // 6. Dobre praktyki
        scanner.close(); 
    }
}