package ControlFlow_Practices.Level1;

import java.util.Scanner;

public class quest17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter salary: ");
        double salary = input.nextDouble();
        
        System.out.print("Enter years of service: ");
        int yearsOfService = input.nextInt();
        
        if (yearsOfService > 5) {
            double bonus = salary * 0.05;
            System.out.println("Bonus amount: " + bonus);
        } else {
            System.out.println("No bonus applicable");
        }
        input.close();
    }
}
