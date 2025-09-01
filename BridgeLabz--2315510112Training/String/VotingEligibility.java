package Level_2_Strings_Practice_Problems;

import java.util.Scanner;

public class VotingEligibility {

    static int[] generateRandomAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = (int)(Math.random() * 100);
        }
        return ages;
    }

    static String[][] canVoteStatus(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }

    static void displayVoteTable(String[][] data) {
        System.out.printf("%-10s %-15s%n", "Age", "Can Vote");
        for (String[] row : data) {
            System.out.printf("%-10s %-15s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        int[] ages = generateRandomAges(10);
        String[][] results = canVoteStatus(ages);
        displayVoteTable(results);
    }
}
