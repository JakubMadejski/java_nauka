package kod;
public class Player {
    // 1. Zmienna INSTANCYJNA (Zwykła)
    // Każdy gracz ma swoje własne, unikalne imię.
    private String name;

    // 2. Zmienna STATYCZNA (Globalna dla tej klasy)
    // Jest tylko JEDNA taka zmienna współdzielona przez wszystkich graczy.
    private static int playerCount = 0;

    public Player(String name) {
        this.name = name;
        playerCount++; // Za każdym razem, gdy robimy "new Player", zwiększamy wspólny licznik
    }

    // Zwykła metoda - wyciąga imię KONKRETNEGO gracza
    public String getName() {
        return name;
    }

    // 3. Metoda STATYCZNA
    // Można ją wywołać pytając ogólnie "Klasę", a nie konkretnego gracza.
    public static int getPlayerCount() {
        // Uwaga: w metodzie statycznej NIE MOŻESZ użyć zmiennej "name" ani słówka "this", 
        // bo metoda statyczna nie wie, o jakiego gracza chodzi!
        return playerCount;
    }

    // --- TESTOWANIE ---
    public static void main(String[] args) {
        // Zobacz: Wywołujemy metodę podając NAZWĘ KLASY, bez słowa "new"!
        System.out.println("Graczy na serwerze (start): " + Player.getPlayerCount());

        Player p1 = new Player("Kuba");
        Player p2 = new Player("Ania");
        Player p3 = new Player("Marek");

        // Wywołujemy metody na konkretnych obiektach (z małej litery)
        System.out.println("Gracz 1: " + p1.getName());
        
        // Wywołujemy metodę na Klasie (z wielkiej litery)
        System.out.println("Graczy na serwerze (koniec): " + Player.getPlayerCount());
        
        // System.out.println(Player.getName()); // <- To by wyrzuciło BŁĄD.
        // Klasa Player sama w sobie nie ma imienia. Imię ma tylko konkretny obiekt (p1, p2...).
    }
}