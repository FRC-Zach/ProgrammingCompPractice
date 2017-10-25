package com.practice.pratice_comp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResRating {

    public static void main(String[] args) {


        int critics = 2;
        int score = 7;

        Set<List<Integer>> checked = new HashSet<>();

        for (int i = 0; i <= score; i++) {
            for (int j = 0; j <= score; j++) {

                if (i + j <= score){
                    List<Integer> objects = new ArrayList<>();
                    objects.add(i);
                    objects.add(j);
                    checked.add(objects);
                }
            }
        }

        System.out.println(checked.size());
    }

}
