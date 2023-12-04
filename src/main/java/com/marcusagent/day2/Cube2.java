package com.marcusagent.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cube2 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/input2.txt");
        Scanner fileScanner = new Scanner(file);
        Scanner lineScanner;

        Map<String, Integer> bag = new HashMap<>();
        bag.put("red", 0);
        bag.put("green", 0);
        bag.put("blue", 0);


        String indexString;
        int sum = 0;
        String line;
        String [] bagPicks;
        int number;
        String color;

        while (fileScanner.hasNextLine()) {
            fileScanner.next();                                   // Skips "Game"
            indexString = fileScanner.next();                     // Get the index, but has ":" after it
            Integer.parseInt(indexString.split(":")[0]);    // Removes the ":" and parses to int
            line = fileScanner.nextLine();                        // Get the rest of the line

            bagPicks = line.split(";");                     // Split the line into the different bag picks
            for(String bagPick : bagPicks){
                lineScanner = new Scanner(bagPick);
                while(lineScanner.hasNext()){
                    number = lineScanner.nextInt();
                    color = lineScanner.next().split(",")[0];

                    if(bag.get(color) < number){
                        bag.put(color,number);
                    }

                }

            }

            sum += bag.get("red")*bag.get("green")*bag.get("blue");

            bag.put("red", 0);
            bag.put("green", 0);
            bag.put("blue", 0);

        }
        System.out.println(sum);

    }

}
