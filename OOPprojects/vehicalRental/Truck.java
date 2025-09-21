package VehicleRental;

public class Truck extends Vehicle implements Insurable {
    public Truck(String num, double rate) { super(num, "Truck", rate); }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.5; // higher
    }

    @Override
    public double calculateInsurance() {
        return 2500;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance - Flat 2500";
    }
}
