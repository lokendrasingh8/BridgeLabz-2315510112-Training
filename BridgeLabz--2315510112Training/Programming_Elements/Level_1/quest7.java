package Programing_elements.Level_1;

public class quest7 {
    public static void main(String[] args) {
        double radius = 6378; // radius in km
        double volumeKm = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        double radiusMiles = radius / 1.6; // convert km to miles
        double volumeMiles = (4.0 / 3.0) * Math.PI * Math.pow(radiusMiles, 3);
        System.out.println("The volume of earth in cubic kilometers is " + volumeKm + " and cubic miles is " + volumeMiles);
    }
}
