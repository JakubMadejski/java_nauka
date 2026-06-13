package kod;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeFileReader {
    public static void main(String[] args) {
        // Zakładamy, że ten plik utworzyliśmy w poprzednim kroku
        String fileName = "nowy_paragon.txt"; 

        // Blok try-with-resources. Plik zamknie się sam!
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            
            String line;
            System.out.println("--- CZYTAM PLIK LINIJKA PO LINIJCE ---");
            
            // Czytamy jedną linię z dysku, zapisujemy do zmiennej i sprawdzamy czy nie jest pusta (null)
            while ((line = reader.readLine()) != null) {
                // Tutaj w RAM-ie jest tylko ta jedna, aktualna linijka!
                System.out.println("Przeczytano: " + line);
            }
            
        } catch (IOException e) {
            System.out.println("Błąd odczytu: " + e.getMessage());
        }
    }
}