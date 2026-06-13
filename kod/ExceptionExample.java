package kod;
import java.util.InputMismatchException; // Importujemy konkretny typ błędu
import java.util.Scanner;

public class ExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj swój wiek (tylko cyfry!): ");

        // 1. Blok TRY - tutaj wrzucamy kod, który jest "ryzykowny"
        try {
            int age = scanner.nextInt(); 
            // Jeśli użytkownik wpisze tekst, program natychmiast przeskoczy do bloku CATCH, 
            // pomijając poniższą linijkę.
            System.out.println("Za 10 lat będziesz mieć: " + (age + 10) + " lat.");
            
        } 
        // 2. Blok CATCH - łapiemy konkretny błąd (odpowiednik 'except' w Pythonie)
        catch (InputMismatchException e) {
            System.out.println("[BŁĄD] Prosiłem o cyfry! Wpisałeś tekst.");
        } 
        // 3. Drugi CATCH - możemy łapać wiele różnych błędów po kolei
        catch (Exception e) {
            // 'Exception' to główna klasa-rodzic wszystkich błędów. 
            // Wyłapie wszystko to, czego nie złapał InputMismatchException.
            System.out.println("[NIEZNANY BŁĄD] Coś poszło nie tak: " + e.getMessage());
        } 
        // 4. Blok FINALLY - opcjonalny, ale bardzo ważny
        finally {
            // Ten kod wykona się ZAWSZE – niezależnie od tego, czy był błąd, czy go nie było.
            // Idealne miejsce na zamykanie plików, połączeń z bazą danych czy Scannera (jak w C `free()`).
            System.out.println("Sprzątanie... zamykam Scanner.");
            scanner.close();
        }

        // Program działa dalej! Nie scrashował się.
        System.out.println("Koniec programu. Działam dalej bez problemu!");
    }
}