package com.practice.sorting;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Zachary Herridge on 11/27/2017.
 */
public class HardestHangman {

    private static Map<Character, Integer> letterCount = new HashMap<>();;

    public static int score(String in){
        int score = 0;
        for (char c : in.toCharArray()) {
            score += letterCount.getOrDefault(c, 0);
        }
        return score;
    }

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(new File("input/HardestHangman.txt").toPath());

            lines.forEach(s -> {
                for (char c : s.toCharArray()) {
                    letterCount.put(c, letterCount.getOrDefault(c, 0)  + 1);
                }
            });

            Map<Integer, List<String>> collect = lines.stream().collect(Collectors.groupingBy(String::length));
            collect.forEach((key, value) -> value.sort((o1, o2) -> {
                int s1 = score(o1);
                int s2 = score(o1);

                if (s1 == s2) {
                    return o2.compareTo(o1);
                }

                return Integer.compare(s1, s2);
            }));

            collect.forEach((key, value) -> {
                System.out.println(key + ": " + value.get(0));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
