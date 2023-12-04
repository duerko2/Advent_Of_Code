package com.marcusagent.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GearRatios {
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

        int sum=0;

        for (int i=0; i<lines.length; i++) {
            String line = lines[i];
            lineScanner = new Scanner(line);
            lineScanner.useDelimiter("");
            int index = 0;

            while (lineScanner.hasNext()) {

                if(lineScanner.hasNextInt()){
                    StringBuilder number = new StringBuilder();
                    identifyNumber(lineScanner,number);
                    if(checkForSymbol(lines,number, index,i)){
                        sum+=Integer.parseInt(number.toString());
                    }
                    index += number.length();
                } else {
                    lineScanner.next(); // Move scanner to the next token if it's not an int
                    index++;
                }
            }
        }
        System.out.println(sum);
    }

    private static boolean checkForSymbol(String[] lines,StringBuilder number, int numberIndex, int lineIndex) {
        // Check right and left of the number
        String lineAbove;
        try{
            lineAbove = lines[lineIndex-1];
        } catch (Exception ignored){
            lineAbove = "";
        }
        String line = lines[lineIndex];
        String lineBelow;
        try{
            lineBelow = lines[lineIndex+1];
        } catch (Exception ignored){
            lineBelow = "";
        }

        // Check left
        try{
            if(isSymbol(line.charAt(numberIndex-1))){
                return true;
            }
        } catch (Exception ignored){}

        // check right
        try{
            if(isSymbol(line.charAt(numberIndex+number.length()))){
                return true;
            }
        } catch (Exception ignored){}


        // check above and below
        for(int i=numberIndex-1; i<=numberIndex+number.length(); i++){
            try{
                if(isSymbol(lineAbove.charAt(i))){
                    return true;
                }
            } catch (Exception ignored){}
            try{
                if(isSymbol(lineBelow.charAt(i))){
                    return true;
                }
            } catch (Exception ignored){}
        }


        return false;

    }

    private static void identifyNumber(Scanner lineScanner, StringBuilder number) {
        // recursively call this method to build the number with nextInt
        number.append(lineScanner.nextInt());
        if(lineScanner.hasNextInt()){
            identifyNumber(lineScanner,number);
        }
    }

    private static boolean isSymbol(char character) {
        return (character != '.' && character != '1' && character != '2' && character != '3' && character != '4' && character != '5' && character != '6' && character != '7' && character != '8' && character != '9');
    }

    private static boolean isPartNumber(char[][] schematic, int i, int j) {
        return (schematic[i][j] == '1' || schematic[i][j] == '2' || schematic[i][j] == '3' || schematic[i][j] == '4' || schematic[i][j] == '5' || schematic[i][j] == '6' || schematic[i][j] == '7' || schematic[i][j] == '8' || schematic[i][j] == '9');
    }
}
