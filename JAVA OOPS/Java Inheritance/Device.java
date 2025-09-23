class Device {
    String deviceId;
    String status;
}

class Thermostat extends Device {
    int temperatureSetting;
    void displayStatus() {
        System.out.println(deviceId+" "+status+" "+temperatureSetting);
    }
}

public class Main5 {
    public static void main(String[] args) {
        Thermostat t=new Thermostat();
        t.deviceId="D1"; t.status="On"; t.temperatureSetting=24;
        t.displayStatus();
    }
}
