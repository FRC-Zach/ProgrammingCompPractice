package com.practice.mock_competitons.UVA.comp1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sticks {


    public static void main(String[] args) {
        String in = "5 2 1 3 3 3 4 2 2 3";

        List<Integer> nums = Arrays.stream(in.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        int num = nums.size() / 2;
        while (num >= 2 ){
            double v = (double) sum / (double) num;
            if (v == (int) v){
                System.out.println(v);
                break;
            }
            num--;
        }
    }
}
