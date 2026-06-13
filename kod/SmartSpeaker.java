package kod;
public class SmartSpeaker implements SmartDevice {
    private String name;
    private boolean isPlaying;

    public SmartSpeaker(String name) {
        this.name = name;
        this.isPlaying = false;
    }

    @Override
    public void turnOn() {
        isPlaying = true;
        System.out.println("Głośnik (" + name + ") gra muzykę. Głośność: 50%");
    }

    @Override
    public void turnOff() {
        isPlaying = false;
        System.out.println("Głośnik (" + name + ") wyciszony.");
    }

    @Override
    public String getStatus() {
        return "Głośnik [" + name + "] - " + (isPlaying ? "GRA" : "CISZA");
    }
}