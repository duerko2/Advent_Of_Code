package com.marcusagent.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cube1 {


    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/input2.txt");
        Scanner fileScanner = new Scanner(file);
        Scanner lineScanner;

        Map<String, Integer> bag = new HashMap<>();
        bag.put("red", 12);
        bag.put("green", 13);
        bag.put("blue", 14);


        String indexString;
        int sum = 0;
        int index;
        String line;
        String [] bagPicks;
        int number;
        String color;
        boolean valid = true;

        while (fileScanner.hasNextLine()) {
            valid = true;
            fileScanner.next();
            indexString = fileScanner.next();
            index = Integer.parseInt(indexString.split(":")[0]);
            line = fileScanner.nextLine();

            bagPicks = line.split(";");
            for(String bagPick : bagPicks){
                lineScanner = new Scanner(bagPick);
                while(lineScanner.hasNext()){
                    number = lineScanner.nextInt();
                    color = lineScanner.next().split(",")[0];

                    if(bag.get(color)<number){
                        valid = false;
                    }
                }

            }
            if(valid) {
                sum += index;
            }
            else{
            }


        }
        System.out.println(sum);

    }
}
