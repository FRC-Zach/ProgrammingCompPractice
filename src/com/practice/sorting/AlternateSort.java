package com.practice.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlternateSort {

    public static void main(String[] args) {
        int[] input = new int[]{20, 45, 30, 5, 15, 50, 10, 30};
        List<Integer> collect = Arrays.stream(input).sorted().boxed().collect(Collectors.toList());

        boolean flip = false;
        while (collect.size() > 0){
            System.out.println(collect.remove((flip = !flip) ? 0 : collect.size() - 1));
        }
    }
}
