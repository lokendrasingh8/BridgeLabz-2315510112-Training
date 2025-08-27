package ControlFlow_Practices.Level2;

import java.util.Scanner;

public class quest12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int number = input.nextInt();
        
        System.out.print("Enter power: ");
        int power = input.nextInt();
        
        if (number > 0 && power >= 0) {
            int result = 1;
            
            for (int i = 1; i <= power; i++) {
                result *= number;
            }
            
            System.out.println(number + " raised to power " + power + " is: " + result);
        } else {
            System.out.println("Please enter positive integers");
        }
        input.close();
    }
}
