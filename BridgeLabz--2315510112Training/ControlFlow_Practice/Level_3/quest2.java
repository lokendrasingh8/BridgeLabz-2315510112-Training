package ControlFlow_Practices.Level3;

import java.util.Scanner;

public class quest2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a year: ");
        int year = input.nextInt();
        
        if (year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            System.out.println(year + " is a Leap Year");
        } else if (year < 1582) {
            System.out.println("Year must be >= 1582 for Gregorian calendar");
        } else {
            System.out.println(year + " is not a Leap Year");
        }
        input.close();
    }
}
