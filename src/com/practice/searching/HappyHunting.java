package com.practice.searching;

import java.util.*;

/**
 * Created by Zachary Herridge on 10/30/2017.
 */
public class HappyHunting {


    public static void main(String[] args) {
        int loc = 50;
        List<Integer> locations = new ArrayList<>(Arrays.asList(56, 3, 8, 82, 203));
        StringJoiner result = new StringJoiner(" ");

        while (locations.size() > 0){
            int finalLoc = loc;
            Integer nextEgg = locations.stream().sorted(Comparator.comparingInt(o -> Math.abs(finalLoc - o))).findFirst().get();
            locations.remove(nextEgg);
            loc = nextEgg;
            result.add(String.valueOf(nextEgg));
        }

        System.out.println(result.toString());
    }

}
