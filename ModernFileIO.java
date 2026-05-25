import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class ModernFileIO {
    public static void main(String[] args) {
        // Określamy ścieżkę do pliku
        Path filePath = Path.of("nowy_paragon.txt");
        String content = "--- NOWY PARAGON ---\nKawa: 12.00 PLN\nCiastko: 8.00 PLN\n";

        try {
            // 1. ZAPIS DO PLIKU (nadpisuje istniejący)
            Files.writeString(filePath, content);
            System.out.println("Zapisano plik pomyślnie!");

            // 2. ODCZYT Z PLIKU (wczytuje cały tekst naraz do jednego Stringa)
            String readContent = Files.readString(filePath);
            
            System.out.println("\n--- ODCZYTANA ZAWARTOŚĆ ---");
            System.out.println(readContent);

        } catch (IOException e) {
            System.out.println("Wystąpił błąd: " + e.getMessage());
        }
    }
}