package com.marcusagent.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GearRatio25 {

    // Function to check if a given cell is valid and not a period '.'
    private static boolean isValid(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        return (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] != '.');
    }

    // Function to convert adjacent digits into a single number
    private static int getAdjacentNumber(char[][] grid, int row, int col) {
        int number = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (isValid(grid, newRow, newCol) && Character.isDigit(grid[newRow][newCol])) {
                    number = number * 10 + Character.getNumericValue(grid[newRow][newCol]);
                }
            }
        }

        return number;
    }

    // Function to calculate the sum of gear ratios
    private static int sumOfGearRatios(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '*') {
                    int adjacentPartNumbers = 0;
                    int product = 1;

                    for (int[] dir : directions) {
                        int newRow = i + dir[0];
                        int newCol = j + dir[1];

                        if (isValid(grid, newRow, newCol)) {
                            if (Character.isDigit(grid[newRow][newCol])) {
                                adjacentPartNumbers++;
                                product *= getAdjacentNumber(grid, newRow, newCol);
                            }
                        }
                    }

                    if (adjacentPartNumbers == 2) {
                        sum += product;
                    }
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        char[][] engineSchematic = new char[140][140];
        File file = new File("src/main/resources/input3.txt");
        Scanner fileScanner = new Scanner(file);

        int row = 0;
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                engineSchematic[row][i] = line.charAt(i);
            }
            row++;
        }



        int sumOfRatios = sumOfGearRatios(engineSchematic);
        System.out.println("Sum of gear ratios: " + sumOfRatios);
    }
}
