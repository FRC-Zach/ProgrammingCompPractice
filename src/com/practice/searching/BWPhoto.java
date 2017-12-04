package com.practice.searching;

import java.awt.*;
import java.util.Arrays;

public class BWPhoto {


    private static Point find(int[][] target, int[][] input){
        for (int i = 0; i < input.length; i++) {

            for (int[] compare : target) {
                boolean found = true;

                for (int j = i; j < input.length; j++) {
                    int[] row = input[j];
                    for (int k = 0; k < row.length; k++) {
                        int[] ints = Arrays.copyOfRange(row, k, k + compare.length);
                        if (!Arrays.equals(ints, row)) {
                            found = false;
                            break;
                        }
                    }
                }

                if (found){
                    System.out.println("Found");
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {


        int[][] searchArray = new int[][]{
                {3, 3},
                {3, 3}
        };

        int[][] input = new int[][]{
                {0, 0, 0, 0, 3, 3, 0, 0},
                {0, 0, 0, 0, 3, 3, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
        };


        find(searchArray, input);
    }
}
