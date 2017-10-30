package com.practice.searching;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Zachary Herridge on 10/30/2017.
 */
public class HappyHunting {

    public static int loc = 50;
    private static List<Integer> locations = new ArrayList<>(Arrays.asList(56, 3, 8, 82, 203));

    public static void main(String[] args) {
        StringJoiner result = new StringJoiner(" ");
        while (locations.size() > 0){
            locations.sort(Comparator.comparingInt(location -> Math.abs(loc - location)));
            
            Integer nextEgg = locations.remove(0);
            locations.remove(nextEgg);
            loc = nextEgg;
            result.add(String.valueOf(nextEgg));
        }

        System.out.println(result.toString());
    }

}
