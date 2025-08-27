package ControlFlow_Practices.Level2;

import java.util.Scanner;

public class quest10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        
        int greatestFactor = 1;
        int counter = number - 1;
        
        while (counter >= 1) {
            if (number % counter == 0) {
                greatestFactor = counter;
                break;
            }
            counter--;
        }
        
        System.out.println("Greatest factor of " + number + " (beside itself) is: " + greatestFactor);
        input.close();
    }
}
