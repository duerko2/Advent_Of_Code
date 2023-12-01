package com.marcusagent.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/input1.txt");
        Scanner scanner = new Scanner(file);


        int sum = 0;
        int firstInteger = 0;
        int secondInteger = 0;
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            // Find first integer
            for(int i=0; i<line.length(); i++){
                if(containsInteger(line,i)) {
                    firstInteger = Character.getNumericValue(line.charAt(i));
                    break;
                }
            }

            // Find second integer
            for(int i=line.length()-1; i>=0; i--){
                if(containsInteger(line,i)) {
                    secondInteger = Character.getNumericValue(line.charAt(i));
                    break;
                }
            }

            // Combine integers to 2 digit number
            int twoDigitNumber = firstInteger*10 + secondInteger;

            // Add to sum
            sum += twoDigitNumber;
        }
        System.out.println(sum);

    }

    private static boolean containsInteger(String line, int i) {
        return (line.charAt(i) == '1' || line.charAt(i) == '2' || line.charAt(i) == '3' || line.charAt(i) == '4' || line.charAt(i) == '5' || line.charAt(i) == '6' || line.charAt(i) == '7' || line.charAt(i) == '8' || line.charAt(i) == '9');
            //secondInteger = Character.getNumericValue(line.charAt(i));
    }
}