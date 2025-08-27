package ControlFlow_Practices.Level1;

import java.util.Scanner;

public class quest9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter countdown value: ");
        int counter = input.nextInt();
        
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
        System.out.println("Launch!");
        input.close();
    }
}
