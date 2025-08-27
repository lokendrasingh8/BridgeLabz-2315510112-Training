package ControlFlow_Practices.Level1;

import java.util.Scanner;

public class quest8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter countdown value: ");
        int counter = input.nextInt();
        
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
        System.out.println("Launch!");
        input.close();
    }
}
