package ControlFlow_Practices.Level3;

import java.util.Scanner;

public class quest8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        int sum = 0;
        int originalNumber = number;
        
        while (originalNumber != 0) {
            sum += originalNumber % 10;
            originalNumber = originalNumber / 10;
        }
        
        if (number % sum == 0) {
            System.out.println(number + " is a Harshad Number");
        } else {
            System.out.println(number + " is not a Harshad Number");
        }
        input.close();
    }
}
