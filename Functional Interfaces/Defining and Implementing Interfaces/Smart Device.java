
interface SmartDevice {
    void turnOn();
    void turnOff();
}

class Light implements SmartDevice {
    public void turnOn() { System.out.println("Light On"); }
    public void turnOff() { System.out.println("Light Off"); }
}

class AC implements SmartDevice {
    public void turnOn() { System.out.println("AC On"); }
    public void turnOff() { System.out.println("AC Off"); }
}

public class DeviceDemo {
    public static void main(String[] args) {
        SmartDevice d1 = new Light();
        SmartDevice d2 = new AC();
        d1.turnOn(); d1.turnOff();
        d2.turnOn(); d2.turnOff();
    }
}
