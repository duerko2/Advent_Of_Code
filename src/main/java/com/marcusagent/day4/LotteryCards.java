package com.marcusagent.day4;

import java.io.File;
import java.util.Scanner;

public class LotteryCards {
    public static void main(String[] args) throws Exception {
        File file = new File("src/main/resources/input4.txt");
        Scanner fileScanner = new Scanner(file);

        double sum = 0;
        double partialSum = 0;
        int amountOfWinners;
        while (fileScanner.hasNext()) {
            fileScanner.next();                                   // Skips "Card"
            fileScanner.next();// Get the index, but has :

            amountOfWinners = 0;
            int[] winingNumbers = new int[10];
            int [] myNumbers = new int[25];
            for (int i = 0; i < 10; i++) {
                winingNumbers[i] = fileScanner.nextInt();
            }
            fileScanner.next();                                   // Skips "|"
            for (int i = 0; i < 25; i++) {
                myNumbers[i] = fileScanner.nextInt();
                for(int j = 0; j < 10; j++){
                    if(myNumbers[i] == winingNumbers[j]){
                        partialSum = Math.pow(2,amountOfWinners);
                        amountOfWinners++;
                    }
                }
            }
            sum+=partialSum;
            partialSum = 0;
        }
        System.out.println(sum);






    }
}
