package com.practice.searching;

import java.util.*;

/**
 * Created by Zachary Herridge on 10/30/2017.
 */
public class HappyHunting {

    public static int loc;
    public static int caseCount = 1;

    public static void search(int startLocation, List<Integer> locations){
        loc = startLocation;
        StringJoiner result = new StringJoiner(" ");
        result.add("Case "  + (caseCount++) + ":");
        while (locations.size() > 0){
            locations.sort(Comparator.comparingInt(location -> Math.abs(loc - location)));

            Integer nextEgg = locations.remove(0);
            loc = nextEgg;
            result.add(String.valueOf(nextEgg));
        }
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        search(14, new ArrayList<>(Arrays.asList(20, 32, 10, -1)));
        search(50, new ArrayList<>(Arrays.asList(56, 3, 8, 82, 203)));
    }
}
