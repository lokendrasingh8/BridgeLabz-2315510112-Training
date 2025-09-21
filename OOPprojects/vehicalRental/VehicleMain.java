package VehicleRental;
import java.util.*;

public class VehicleMain {
    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("KA01AB1234", 2000));
        fleet.add(new Bike("KA02XY9876", 500));
        fleet.add(new Truck("KA03TR0001", 5000));

        for (Vehicle v : fleet) {
            System.out.println(v);
            System.out.println("Rental (3 days): " + v.calculateRentalCost(3));
            if (v instanceof Insurable) {
                Insurable ins = (Insurable)v;
                System.out.println("Insurance: " + ins.calculateInsurance() + " (" + ins.getInsuranceDetails() + ")");
            }
            System.out.println("---");
        }
    }
}
