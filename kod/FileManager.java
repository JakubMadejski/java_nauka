package kod;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
    public static void main(String[] args) {
        String fileName = "paragon.txt";

        // 1. ZAPIS DO PLIKU
        try {
            // Drugi argument (false) nadpisuje plik. Użyj (true), aby dopisywać na końcu.
            FileWriter writer = new FileWriter(fileName, false);
            writer.write("--- PARAGON FISKALNY ---\n");
            writer.write("Chleb: 4.50 PLN\n");
            writer.write("Mleko: 3.20 PLN\n");
            writer.close(); // Zawsze pamiętaj o zamknięciu!
            
            System.out.println("Zapisano plik pomyślnie!\n");
            
        } catch (IOException e) {
            System.out.println("Błąd podczas zapisu: " + e.getMessage());
        }

        // 2. ODCZYT Z PLIKU
        try {
            File myFile = new File(fileName);
            // Używamy Scannera dokładnie tak, jak do czytania z klawiatury (System.in)
            Scanner scanner = new Scanner(myFile);
            
            System.out.println("--- ODCZYTYWANIE Z PLIKU ---");
            
            // Pętla działa, dopóki plik ma kolejną linijkę tekstu
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close(); // Sprzątamy
            
        } catch (IOException e) {
            System.out.println("Błąd podczas odczytu: " + e.getMessage());
        }
    }
}