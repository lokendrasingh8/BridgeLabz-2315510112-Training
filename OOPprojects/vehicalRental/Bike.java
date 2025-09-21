package VehicleRental;

public class Bike extends Vehicle implements Insurable {
    public Bike(String num, double rate) { super(num, "Bike", rate); }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.6; // cheaper
    }

    @Override
    public double calculateInsurance() {
        return 300;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance - Flat 300";
    }
}
