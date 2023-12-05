package com.marcusagent.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Seeds {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner filescanner = new Scanner(new File("src/main/resources/input5.txt"));

        filescanner.next();
        String seedsString = filescanner.nextLine();
        seedsString = seedsString.substring(1,seedsString.length()-1);
        String[] seedsArrayString = seedsString.split(" ");
        long[] seeds = new long[seedsArrayString.length];
        for (int i = 0; i < seedsArrayString.length; i++) {
            seeds[i] = Long.parseLong(seedsArrayString[i]);
        }

        filescanner.nextLine();
        filescanner.nextLine();

        Map<Long, Integer> seed_to_soil_map = new HashMap<>();
        nextMapping(filescanner, seed_to_soil_map);

        filescanner.nextLine();

        Map<Long, Integer> fertilizer_to_water_map = new HashMap<>();
        nextMapping(filescanner, fertilizer_to_water_map);

        filescanner.nextLine();

        Map<Long, Integer> water_to_light_map = new HashMap<>();
        nextMapping(filescanner, water_to_light_map);

        filescanner.nextLine();

        Map<Long, Integer> light_to_temperature_map = new HashMap<>();
        nextMapping(filescanner, light_to_temperature_map);

        filescanner.nextLine();

        Map<Long, Integer> temperature_to_humidity_map = new HashMap<>();
        nextMapping(filescanner, temperature_to_humidity_map);

        filescanner.nextLine();

        Map<Long, Integer> humidity_to_location_map = new HashMap<>();
        nextMapping(filescanner, humidity_to_location_map);


    }

    private static void nextMapping(Scanner filescanner, Map<Long, Integer> map){
        while(filescanner.hasNextInt()){
            String mapping = filescanner.nextLine();
            String[] mapArray = mapping.split(" ");
            long[] mapArrayLong = new long[mapArray.length];
            for (int i = 0; i < mapArray.length; i++) {
                mapArrayLong[i] = Long.parseLong(mapArray[i]);
            }
            putInMap(mapArrayLong, map);
        }
    }


    private static void putInMap(long[] mapArrayLong, Map<Long, Integer> map) {

    }
}
