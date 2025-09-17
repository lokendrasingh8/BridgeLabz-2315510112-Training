
// Single Inheritance - Problem 2: Smart Home Devices
class Device {
    String deviceId;
    String status;

    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
}

class Thermostat extends Device {
    int temperatureSetting;

    Thermostat(String deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId + ", Status: " + status + ", Temp: " + temperatureSetting);
    }
}

public class Main {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat("T001", "ON", 24);
        thermostat.displayStatus();
    }
}
