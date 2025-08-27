package ControlFlow_Practices.Level2;

import java.util.Scanner;

public class quest6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter Amar's age: ");
        int amarAge = input.nextInt();
        System.out.print("Enter Amar's height: ");
        double amarHeight = input.nextDouble();
        
        System.out.print("Enter Akbar's age: ");
        int akbarAge = input.nextInt();
        System.out.print("Enter Akbar's height: ");
        double akbarHeight = input.nextDouble();
        
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = input.nextInt();
        System.out.print("Enter Anthony's height: ");
        double anthonyHeight = input.nextDouble();
        
        String youngest = "Amar";
        int minAge = amarAge;
        if (akbarAge < minAge) {
            youngest = "Akbar";
            minAge = akbarAge;
        }
        if (anthonyAge < minAge) {
            youngest = "Anthony";
        }
        
        String tallest = "Amar";
        double maxHeight = amarHeight;
        if (akbarHeight > maxHeight) {
            tallest = "Akbar";
            maxHeight = akbarHeight;
        }
        if (anthonyHeight > maxHeight) {
            tallest = "Anthony";
        }
        
        System.out.println("The youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);
        input.close();
    }
}
