package Programing_elements.Level_1;

import java.util.Scanner;

public class quest16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numberOfStudents = input.nextInt();
        
        int combination = (numberOfStudents * (numberOfStudents - 1)) / 2;
        
        System.out.println("The maximum number of handshakes among " + numberOfStudents + " students is " + combination);
        input.close();
    }
}
