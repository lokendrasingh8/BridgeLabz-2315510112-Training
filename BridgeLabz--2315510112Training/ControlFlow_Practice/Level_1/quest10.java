package ControlFlow_Practices.Level1;

import java.util.Scanner;

public class quest10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double total = 0.0;
        double number;
        
        System.out.print("Enter a number (0 to stop): ");
        number = input.nextDouble();
        
        while (number != 0) {
            total += number;
            System.out.print("Enter a number (0 to stop): ");
            number = input.nextDouble();
        }
        
        System.out.println("Total sum: " + total);
        input.close();
    }
}
