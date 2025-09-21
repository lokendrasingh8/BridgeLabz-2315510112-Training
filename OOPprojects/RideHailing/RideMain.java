package RideHailing;
import java.util.*;

public class RideMain {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        Car c = new Car("RH001","Anil",15);
        c.updateLocation("MG Road");
        vehicles.add(c);
        vehicles.add(new Bike("RH002","Ramesh",8));
        vehicles.add(new Auto("RH003","Suresh",6));

        for (Vehicle v : vehicles) {
            System.out.println(v.getVehicleDetails());
            System.out.println("Fare for 10 km: " + v.calculateFare(10));
            if (v instanceof GPS) System.out.println("Location: " + ((GPS)v).getCurrentLocation());
            System.out.println("---");
        }
    }
}
