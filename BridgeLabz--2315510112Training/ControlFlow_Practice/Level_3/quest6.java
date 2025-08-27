package ControlFlow_Practices.Level3;

import java.util.Scanner;

public class quest6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        int count = 0;
        int originalNumber = Math.abs(number);
        
        if (originalNumber == 0) {
            count = 1;
        } else {
            while (originalNumber != 0) {
                originalNumber = originalNumber / 10;
                count++;
            }
        }
        
        System.out.println("Number of digits in " + number + " is: " + count);
        input.close();
    }
}
