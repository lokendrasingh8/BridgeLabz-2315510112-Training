package ControlFlow_Practices.Level1;

import java.util.Scanner;

public class quest11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double total = 0.0;
        
        while (true) {
            System.out.print("Enter a number: ");
            double number = input.nextDouble();
            
            if (number <= 0) {
                break;
            }
            
            total += number;
        }
        
        System.out.println("Total sum: " + total);
        input.close();
    }
}
