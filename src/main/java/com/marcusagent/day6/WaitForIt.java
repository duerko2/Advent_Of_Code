package com.marcusagent.day6;

public class WaitForIt {

    public static void main(String[] args) {
        long times = 35937366L;
        long distances = 212_206_012_011_044L;

        long sum = 0L;
        for (long j = 0L; j < times; j++) {
            if (j * times - j * j > distances) {
                if (sum == 0) {
                    System.out.println(j);
                }
                sum++;
            }
        }
        System.out.println(sum);
    }
}
