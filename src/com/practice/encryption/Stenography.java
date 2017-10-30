package com.practice.encryption;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Zach on 10/10/2017.
 */
public class Stenography {

    private static String ALPHABET = " " + IntStream.rangeClosed('A', 'Z').mapToObj(value -> "" + (char) value).collect(Collectors.joining("")) + ".?\n";

    public static void main(String[] args) {
        int[] inputs = new int[]{31, 0, 33, 61, 62, 117, 30, 93, 121, 14, 29, 39, 50, 30, 2, 65, 88, 59};

        String test = "asdasdasdasdasdasd";


        StringBuilder sb = new StringBuilder(test);


        for (int input : inputs) {
            System.out.print(ALPHABET.charAt(input % 30));
        }
    }
}
