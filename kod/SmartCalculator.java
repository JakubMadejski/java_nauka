package kod;
public class SmartCalculator {
    // 1. Pola prywatne (Hermetyzacja)
    // Tylko ta klasa może zmieniać 'result'. Nikt z zewnątrz nie popsuje wyniku.
    private double result;

    // 2. Metoda zwracająca wartość (jak w C i Pythonie)
    public double getResult() {
        return result;
    }

    // 3. Metoda typu void (nic nie zwraca, tylko wykonuje akcję)
    public void add(double value) {
        result += value;
        log("Dodano: " + value);
    }

    public void multiply(double value) {
        result *= value;
        log("Pomnożono przez: " + value);
    }

    // 4. Metoda PRYWATNA - pomocnicza, niewidoczna na zewnątrz
    private void log(String message) {
        System.out.println("[LOG]: " + message + " | Aktualny stan: " + result);
    }

    // 5. Metoda MAIN do przetestowania całości
    public static void main(String[] args) {
        SmartCalculator calc = new SmartCalculator();
        
        calc.add(10.5);
        calc.multiply(2);
        
        System.out.println("Wynik końcowy: " + calc.getResult());
        
        // calc.result = 999; // BŁĄD! Nie zadziała, bo pole jest private.
        // calc.log("test");  // BŁĄD! Nie zadziała, bo metoda jest private.
    }
}