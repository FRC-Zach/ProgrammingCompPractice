package com.practice.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class ValleySort {

    public static void main(String[] args) {
        //20, 45, 30, 5, 15, 50, 10, 35
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();


        String[] input = line.split(", ");

        List<String> down = new ArrayList<>();
        List<String> up = new ArrayList<>();

        boolean flip = false;
        for (String num : input) {
            if (flip) up.add(num);
            else down.add(num);
            flip = !flip;
        }

        StringJoiner output = new StringJoiner("\n");
        up.forEach(output::add);
        down.forEach(output::add);

        System.out.print(output.toString());
    }
}
