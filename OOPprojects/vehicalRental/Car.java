package VehicleRental;

public class Car extends Vehicle implements Insurable {
    public Car(String num, double rate) { super(num, "Car", rate); }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 1000; // flat example
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance - Flat 1000";
    }
}
