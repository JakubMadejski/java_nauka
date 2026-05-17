public class SmartLight implements SmartDevice {
    private String room;
    private boolean isOn;

    public SmartLight(String room) {
        this.room = room;
        this.isOn = false;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Żarówka w (" + room + ") włączona. Jasność: 100%");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Żarówka w (" + room + ") wyłączona.");
    }

    @Override
    public String getStatus() {
        return "Światło [" + room + "] - " + (isOn ? "WŁ" : "WYŁ"); // Krótki if (operator trójargumentowy z C)
    }
}