package kod;
import java.util.ArrayList;

public class SmartHomeTest {
    public static void main(String[] args) {
        // Tworzymy listę, której typem jest nasz INTERFEJS!
        // Dzięki temu możemy wrzucić tam cokolwiek, co implementuje SmartDevice.
        ArrayList<SmartDevice> homeDevices = new ArrayList<>();

        homeDevices.add(new SmartLight("Salon"));
        homeDevices.add(new SmartLight("Sypialnia"));
        homeDevices.add(new SmartSpeaker("Kino domowe"));

        System.out.println("--- WYCHODZĘ Z DOMU: WYŁĄCZAM WSZYSTKO ---");
        
        // Magia polimorfizmu z interfejsami:
        for (SmartDevice device : homeDevices) {
            // Java nie wnika, czy to żarówka czy głośnik. 
            // Wie, że każdy SmartDevice ma metodę turnOff(), więc ją wywołuje!
            device.turnOff(); 
        }

        System.out.println("\n--- STATUS URZĄDZEŃ ---");
        for (SmartDevice device : homeDevices) {
            System.out.println(device.getStatus());
        }
    }
}