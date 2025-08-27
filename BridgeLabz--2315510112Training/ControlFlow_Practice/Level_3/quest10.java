package ControlFlow_Practices.Level3;

import java.util.Scanner;

public class quest10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double first = input.nextDouble();
        
        System.out.print("Enter second number: ");
        double second = input.nextDouble();
        
        System.out.print("Enter operator (+, -, *, /): ");
        String op = input.next();
        
        switch (op) {
            case "+":
                System.out.println("Result: " + (first + second));
                break;
            case "-":
                System.out.println("Result: " + (first - second));
                break;
            case "*":
                System.out.println("Result: " + (first * second));
                break;
            case "/":
                if (second != 0) {
                    System.out.println("Result: " + (first / second));
                } else {
                    System.out.println("Error: Division by zero");
                }
                break;
            default:
                System.out.println("Invalid Operator");
        }
        input.close();
    }
}
