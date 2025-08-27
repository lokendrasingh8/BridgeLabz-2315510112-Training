package Programing_elements.Level_1;

import java.util.Scanner;

public class quest14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter distance in feet: ");
        double distanceInFeet = input.nextDouble();
        
        double distanceInYards = distanceInFeet / 3;
        double distanceInMiles = distanceInYards / 1760;
        
        System.out.println("The distance " + distanceInFeet + " feet is " + distanceInYards + " yards and " + distanceInMiles + " miles");
        input.close();
    }
}
