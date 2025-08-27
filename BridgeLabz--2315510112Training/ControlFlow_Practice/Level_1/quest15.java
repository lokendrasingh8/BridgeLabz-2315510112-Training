package ControlFlow_Practices.Level1;

import java.util.Scanner;

public class quest15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        
        if (number > 0) {
            long factorial = 1;
            
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            
            System.out.println("Factorial of " + number + " is " + factorial);
        } else {
            System.out.println("Please enter a positive integer");
        }
        input.close();
    }
}
