package com.practice.sorting;

import java.util.*;

public class MountainSort {

    /*
    Inputs:
    8
    20
    45
    30
    5
    15
    50
    10
    30
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = scanner.nextInt();

        List<Integer> inputs = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            inputs.add(scanner.nextInt());
        }

        Collections.sort(inputs);

        List<Integer> up = new ArrayList<>();
        List<Integer> down = new ArrayList<>();
        boolean flip = true;

        for (Integer number : inputs) {
            if (flip) up.add(number);
            else down.add(number);

            flip = !flip;
        }

        Collections.reverse(down);
        up.addAll(down);

        StringJoiner stringJoiner = new StringJoiner("\n");

        stringJoiner.add(String.valueOf(lines));

        for (Integer integer : up) {
            stringJoiner.add(String.valueOf(integer));
        }

        System.out.print(stringJoiner.toString());
    }
}
