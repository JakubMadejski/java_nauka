package kod;
import java.util.HashMap; 

public class MapExample {
    public static void main(String[] args) {
        // 1. Tworzymy HashMapę: <Typ_Klucza, Typ_Wartosci>
        // Chcemy, aby kluczem był String (np. "pies") i wartością też String (np. "dog")
        HashMap<String, String> dictionary = new HashMap<>();

        // 2. Dodawanie elementów - w Javie używamy metody .put()
        // Python: dictionary["pies"] = "dog"
        dictionary.put("pies", "dog");
        dictionary.put("kot", "cat");
        dictionary.put("samochód", "car");
        dictionary.put("komputer", "computer");

        // 3. Pobieranie elementów - używamy metody .get()
        // Python: print(dictionary["kot"])
        String translation = dictionary.get("kot");
        System.out.println("Tłumaczenie słowa 'kot' to: " + translation);

        // Wyciągnięcie czegoś, czego nie ma, zwraca 'null' (odpowiednik None z Pythona)
        System.out.println("Tłumaczenie słowa 'ptak': " + dictionary.get("ptak"));

        // 4. Sprawdzanie, czy klucz istnieje
        if (dictionary.containsKey("samochód")) {
            System.out.println("Mamy słowo 'samochód' w bazie!");
        }

        System.out.println("\n--- PRZEGLĄDANIE CAŁEGO SŁOWNIKA ---");

        // 5. Pętla po słowniku (for-each)
        // dictionary.keySet() zwraca nam zestaw wszystkich kluczy (pies, kot, itd.)
        for (String key : dictionary.keySet()) {
            System.out.println(key + " po angielsku to: " + dictionary.get(key));
        }
    }
}
