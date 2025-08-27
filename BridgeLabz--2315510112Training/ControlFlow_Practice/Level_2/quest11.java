package ControlFlow_Practices.Level2;

import java.util.Scanner;

public class quest11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer less than 100: ");
        int number = input.nextInt();
        
        if (number > 0 && number < 100) {
            System.out.println("Multiples of " + number + " below 100 are:");
            for (int i = number; i < 100; i += number) {
                System.out.println(i);
            }
        } else {
            System.out.println("Please enter a positive integer less than 100");
        }
        input.close();
    }
}
