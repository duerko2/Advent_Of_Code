package com.marcusagent.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class LotteryTest {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/test4.txt");
        Scanner fileScanner = new Scanner(file);


        long [] amountOfCards = new long[6];
        // initialize to 1 on each entry
        Arrays.fill(amountOfCards, 1);



        int amountOfWinnersInLine;
        int index=0;
        while(fileScanner.hasNext()){
            String line = fileScanner.nextLine();

            amountOfWinnersInLine = amountOfMatchesInLine(line);
            System.out.println(amountOfWinnersInLine);
            for(int j=0;j<amountOfWinnersInLine;j++){
                try {
                    amountOfCards[index + 1 + j] = amountOfCards[index + 1 + j] + amountOfCards[index];
                }catch (ArrayIndexOutOfBoundsException e){
                }
            }

            for(int i = 0; i<amountOfCards.length;i++){
                System.out.print(amountOfCards[i] + ", ");
            }
            System.out.println("");
            index++;
        }

        int sum = 0;
        for(int i = 0; i<amountOfCards.length;i++){
            sum += amountOfCards[i];
            System.out.println(sum);
        }
        System.out.println(sum);
    }

    private static int amountOfMatchesInLine(String line){
        int amountOfWinners = 0;
        Scanner lineScanner = new Scanner(line);
        lineScanner.next();                                   // Skips "Card"
        lineScanner.next();// Get the index, but has :

        int[] winingNumbers = new int[5];
        int [] myNumbers = new int[8];
        for (int i = 0; i < 5; i++) {
            winingNumbers[i] = lineScanner.nextInt();
        }
        lineScanner.next();                                   // Skips "|"
        for (int i = 0; i < 8; i++) {
            myNumbers[i] = lineScanner.nextInt();
            for(int j = 0; j < 5; j++){
                if(myNumbers[i] == winingNumbers[j]){
                    amountOfWinners++;
                }
            }
        }
        return amountOfWinners;
    }
}
