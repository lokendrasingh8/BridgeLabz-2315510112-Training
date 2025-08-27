package ControlFlow_Practices.Level1;

import java.util.Scanner;

public class quest13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();
        
        if (number > 0) {
            int formulaSum = number * (number + 1) / 2;
            
            int loopSum = 0;
            for (int i = 1; i <= number; i++) {
                loopSum += i;
            }
            
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using for loop: " + loopSum);
            System.out.println("Both results are equal: " + (formulaSum == loopSum));
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
        input.close();
    }
}
