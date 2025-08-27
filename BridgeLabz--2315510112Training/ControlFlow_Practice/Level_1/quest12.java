package ControlFlow_Practices.Level1;

import java.util.Scanner;

public class quest12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();
        
        if (number > 0) {
            int formulaSum = number * (number + 1) / 2;
            
            int loopSum = 0;
            int i = 1;
            while (i <= number) {
                loopSum += i;
                i++;
            }
            
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using while loop: " + loopSum);
            System.out.println("Both results are equal: " + (formulaSum == loopSum));
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
        input.close();
    }
}
