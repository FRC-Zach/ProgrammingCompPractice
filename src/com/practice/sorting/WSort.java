package com.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WSort {

    public static void main(String[] args) {
        List<Integer> luckyValues = IntStream.range(0, 124).boxed().collect(Collectors.toList());

        List<ArrayList<Integer>> legs = Arrays.asList(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        out:for (;;){
            for (ArrayList<Integer> leg : legs) {
                leg.add(luckyValues.remove(0));
                if (luckyValues.isEmpty()) break out;
            }
        }

        List<Integer> completeSort = new ArrayList<>();
        completeSort.addAll(legs.get(0));
        completeSort.addAll(legs.get(2));
        completeSort.addAll(legs.get(3));
        completeSort.addAll(legs.get(1));

        StringJoiner stringJoiner = new StringJoiner("\n");
        for (int i = 1; i <= 31; i++) {
            stringJoiner.add(i + ": " + completeSort.remove(0) + " " + completeSort.remove(0) + " " + completeSort.remove(0) + " " + completeSort.remove(0));
        }

        System.out.print(stringJoiner.toString());
    }
}
