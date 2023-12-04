package com.marcusagent.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GearRatio2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/input3.txt");
        Scanner fileScanner = new Scanner(file);
        Scanner lineScanner;
        String[] lines = new String[140];

        while (fileScanner.hasNextLine()) {
            for (int i = 0; i < lines.length; i++) {
                lines[i] = fileScanner.nextLine();
            }
        }

        int sum = 0;

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            lineScanner = new Scanner(line);
            lineScanner.useDelimiter("");
            int index = 0;

            while (lineScanner.hasNext()) {
                if (lineScanner.hasNext("\\*")) {
                    System.out.println(lineScanner.next() + " lineNumber: " + i + " Index: " + ++index);
                    // check if the * symbol has exactly two numbers adjacent to it

                    int numbersAdjacent = 0;
                    // check right
                    if (lineScanner.hasNextInt()) {
                        StringBuilder number = new StringBuilder();
                        identifyNumber(lineScanner, number);
                        numbersAdjacent++;
                    }

                    // check left
                    if (isNumber(line.charAt(index - 1))) {
                        StringBuilder number = new StringBuilder();
                        number.append(line.charAt(index - 1));
                        if (isNumber(line.charAt(index - 2))) {
                            number.append(line.charAt(index - 2));
                            if (isNumber(line.charAt(index - 3))) {
                                number.append(line.charAt(index - 3));
                            }
                        }
                        numbersAdjacent++;
                        number.reverse();
                    }

                    // check up
                    String lineAbove;
                    try {
                        lineAbove = lines[i - 1];
                        // check if there is a number on lineAbove on index index-1..index+1


                    } catch (Exception ignored) {
                        lineAbove = "";
                    }
                } else {
                    lineScanner.next(); // Move scanner to the next token if it's not an *
                }
                index++;
            }


        }
    }

    private static void identifyNumberReverse(Scanner lineScanner, StringBuilder number) {

    }
    private static boolean isNumber(char character) {
        return (character=='1'|| character=='2'|| character=='3'|| character=='4'|| character=='5'|| character=='6'|| character=='7'|| character=='8'|| character=='9');
    }


    private static void identifyNumber(Scanner lineScanner, StringBuilder number) {
        // recursively call this method to build the number with nextInt
        number.append(lineScanner.nextInt());
        if(lineScanner.hasNextInt()){
            identifyNumber(lineScanner,number);
        }
    }

}
