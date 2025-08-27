package ControlFlow_Practices.Level1;

import java.util.Scanner;

public class quest1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        boolean isDivisible = (number % 5 == 0);
        
        System.out.println("Is the number " + number + " divisible by 5? " + isDivisible);
        input.close();
    }
}
