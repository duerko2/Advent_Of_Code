package com.marcusagent.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/input1.txt");
        Scanner scanner = new Scanner(file);

        // key value pair for each integer spelled out and its integer value
        // key = spelled out integer
        // value = integer value
        Map<String, Integer> spelledOutIntegers = new HashMap<>();
        String [] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        spelledOutIntegers.put("one", 1);
        spelledOutIntegers.put("two", 2);
        spelledOutIntegers.put("three", 3);
        spelledOutIntegers.put("four", 4);
        spelledOutIntegers.put("five", 5);
        spelledOutIntegers.put("six", 6);
        spelledOutIntegers.put("seven", 7);
        spelledOutIntegers.put("eight", 8);
        spelledOutIntegers.put("nine", 9);



        // Total sum
        int sum = 0;

        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            // First and second digits
            int firstDigit = 0;
            int secondDigit = 0;


            // Find first integer digit
            int firstIntegerValue = 0;
            int indexOfFirstInteger = Integer.MAX_VALUE;
            for(int i=0; i<line.length(); i++){
                if(containsInteger(line,i)) {
                    firstIntegerValue = Character.getNumericValue(line.charAt(i));
                    indexOfFirstInteger = i;
                    break;
                }
            }

            // Find first spelled digit in line
            String firstSpelledNumber = "";
            int indexOfFirstSpelledNumber = Integer.MAX_VALUE;
            for(String number : numbers){
                if(line.contains(number) && line.indexOf(number) < indexOfFirstSpelledNumber){
                    indexOfFirstSpelledNumber = line.indexOf(number);
                    firstSpelledNumber = number;
                }
            }

            // Now find last integer digit
            int secondIntegerValue = 0;
            int indexOfSecondInteger = Integer.MIN_VALUE;
            for(int i=line.length()-1; i>=0; i--){
                if(containsInteger(line,i)) {
                    secondIntegerValue = Character.getNumericValue(line.charAt(i));
                    indexOfSecondInteger = i;
                    break;
                }
            }

            // Find last digit spelled in line
            String lastSpelledNumber = "";
            int indexOfLastSpelledNumber = Integer.MIN_VALUE;
            for(String number : numbers){
                if(line.contains(number) && line.lastIndexOf(number) > indexOfLastSpelledNumber){
                    indexOfLastSpelledNumber = line.lastIndexOf(number);
                    lastSpelledNumber = number;
                }
            }



            // Decide whichever is first
            if(indexOfFirstInteger < indexOfFirstSpelledNumber){
                firstDigit = firstIntegerValue;
            } else {
                firstDigit = spelledOutIntegers.get(firstSpelledNumber);
            }

            // Decide whichever is last
            if(indexOfSecondInteger > indexOfLastSpelledNumber){
                secondDigit = secondIntegerValue;
            } else {
                secondDigit = spelledOutIntegers.get(lastSpelledNumber);
            }





            // Combine integers to 2 digit number
            int twoDigitNumber = firstDigit*10 + secondDigit;
            System.out.println(twoDigitNumber);

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