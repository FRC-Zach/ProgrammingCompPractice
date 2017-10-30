package com.practice.pratice_comp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResRating {

    public static void rec(int score, int count, int[] value, Set<List<Integer>> set){
        int[] copy = Arrays.copyOfRange(value, 0, value.length);
        IntStream.rangeClosed(0, score).forEach(value1 -> {
            copy[count - 1] = value1;
            if (count - 1 <= 0) {
                if (IntStream.of(copy).sum() <= score){
                    set.add(IntStream.of(copy).boxed().collect(Collectors.toList()));
                }
            }
            else {
                rec(score, count - 1, copy, set);
            }
        });
    }

    public static void calc(int[] ratings){
        int score = IntStream.of(ratings).sum();
        Set<List<Integer>> set = new HashSet<>();
        rec(score, ratings.length, new int[ratings.length], set);
        Set<List<Integer>> collect = set.parallelStream()
                .filter(integers -> {
                    int sum = integers.stream().mapToInt(Integer::intValue).sum();
                    if (sum == score){
                        for (int i = 0; i < ratings.length; i++) {
                            if (integers.get(i) == ratings[i]) continue;
                            return integers.get(i) < ratings[i];
                        }
                    }
                    return true;
                })
                .collect(Collectors.toSet());
        System.out.println(collect.size());
    }

    public static void main(String[] args) {
        calc(new int[]{ 4, 3, 2, 1, 4});
    }

}
