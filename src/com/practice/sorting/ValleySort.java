package com.practice.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class ValleySort {

    public static void main(String[] args) {
        int[] input = new int[]{20, 45, 30, 5, 15, 50, 10, 35};

        List<Integer> collect = Arrays.stream(input).sorted().boxed().collect(Collectors.toList());

        List<String> down = new ArrayList<>();
        List<String> up = new ArrayList<>();

        boolean flip = false;
        while (collect.size() > 0){
            ((flip = !flip) ? down : up).add("" + collect.remove(collect.size() - 1));
        }

        Collections.reverse(up);
        down.addAll(up);

        StringJoiner output = new StringJoiner("\n");
        output.add("" + down.size());
        down.forEach(output::add);

        System.out.print(output.toString());
    }

}
