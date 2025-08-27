package Programing_elements.Level_1;

import java.util.Scanner;

public class quest12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter base: ");
        double base = input.nextDouble();
        
        System.out.print("Enter height: ");
        double height = input.nextDouble();
        
        double areaSquareInches = 0.5 * base * height;
        double areaSquareCm = areaSquareInches * 6.4516; // 1 square inch = 6.4516 square cm
        
        System.out.println("The area of triangle with base " + base + " and height " + height + " is " + areaSquareInches + " square inches and " + areaSquareCm + " square centimeters");
        input.close();
    }
}
