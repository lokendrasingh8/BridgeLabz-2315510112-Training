package ControlFlow_Practices.Level1;

import java.util.Scanner;

public class quest7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter month: ");
        int month = input.nextInt();
        
        System.out.print("Enter day: ");
        int day = input.nextInt();
        
        if ((month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20)) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
        input.close();
    }
}
