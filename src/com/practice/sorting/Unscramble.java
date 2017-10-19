package com.practice.sorting;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * Created by Zachary Herridge on 10/17/2017.
 */
public class Unscramble {

    private static final int[] PRIMES = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199};

    public static BigInteger primeHash(String word){
        BigInteger hash = BigInteger.valueOf(1);
        for (char c : word.toCharArray()) {
            hash = hash.multiply(BigInteger.valueOf(PRIMES[Character.toLowerCase(c) - 'a']));
        }
        return hash;
    }

    public static String countHash(String word){
        Map<Integer, List<Integer>> characterCountMap = word.chars().boxed().collect(Collectors.groupingBy(charAsInt -> charAsInt));
        return characterCountMap.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).map(entry -> entry.getKey() + ":" + entry.getValue().size()).collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(new File("words.txt").toPath());

            long l = System.currentTimeMillis();
            ConcurrentMap<BigInteger, List<String>> primeDictionaryMap = lines.stream().parallel()
                    .collect(Collectors.groupingByConcurrent(Unscramble::primeHash));

            String targetWord = "cat";
            List<String> result = primeDictionaryMap.getOrDefault(primeHash(targetWord), Collections.emptyList());
            long s = System.currentTimeMillis();
            System.out.println(result);

            System.out.println(s - l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
