package kod;
public interface SmartDevice {
    // To są obietnice. 
    // Każda klasa, która dopisze "implements SmartDevice", MUSI napisać te 3 metody.
    void turnOn();
    void turnOff();
    String getStatus();
}