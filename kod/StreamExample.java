package kod;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Matrix", 1999));
        movies.add(new Movie("Incepcja", 2010));
        movies.add(new Movie("Terminator", 1984));
        movies.add(new Movie("Interstellar", 2014));

        // 1. STARY SPOSÓB (Tradycyjna pętla)
        System.out.println("--- STARY SPOSÓB (Pętla for) ---");
        List<String> modernMoviesClassic = new ArrayList<>();
        
        for (Movie m : movies) {
            if (m.getReleaseYear() > 2000) {
                modernMoviesClassic.add(m.getTitle());
            }
        }
        
        for (String title : modernMoviesClassic) {
            System.out.println(title);
        }

        // 2. NOWY SPOSÓB (Stream + Lambdy)
        System.out.println("\n--- NOWY SPOSÓB (Stream API) ---");
        
        movies.stream()                                   // 1. Wrzucamy listę na taśmociąg
              .filter(m -> m.getReleaseYear() > 2000)     // 2. LAMBDA: Przepuść tylko te po 2000
              .map(m -> m.getTitle())                     // 3. LAMBDA: Zamień obiekt Movie na sam String (tytuł)
              .forEach(title -> System.out.println(title)); // 4. LAMBDA: Wypisz każdy element, który przetrwał
    }
}