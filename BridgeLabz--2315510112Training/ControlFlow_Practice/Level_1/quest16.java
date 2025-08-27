package ControlFlow_Practices.Level1;

import java.util.Scanner;

public class quest16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();
        
        if (number > 0) {
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is even number");
                } else {
                    System.out.println(i + " is odd number");
                }
            }
        } else {
            System.out.println("Please enter a natural number");
        }
        input.close();
    }
}
