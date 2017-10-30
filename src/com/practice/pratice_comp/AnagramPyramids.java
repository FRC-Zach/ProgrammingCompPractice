package com.practice.pratice_comp;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class AnagramPyramids {

    private static final int[] PRIMES = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199};

    public static BigInteger primeHash(String word){
        BigInteger hash = BigInteger.valueOf(1);
        for (char c : word.toCharArray()) {
            hash = hash.multiply(BigInteger.valueOf(PRIMES[Character.toLowerCase(c) - 'a']));
        }
        return hash;
    }

    public static void main(String[] args) {
        int cc = 0;
        try {
            List<String> strings = Files.readAllLines(new File("C:\\Users\\zgh\\Dropbox\\Code\\Code Projects\\AcuityBotting\\ProgrammingCompPractice\\src\\com\\practice\\pratice_comp\\anagramInput.txt").toPath());
            Iterator<String> iterator = strings.iterator();

            ArrayList<String> dict = new ArrayList<>();
            int c = Integer.parseInt(iterator.next());
            iterator.remove();
            for (int i = 0; i < c; i++) {
                String next = iterator.next();
                dict.add(next);
                iterator.remove();
            }

            System.out.println("Case " + ++cc + ":");

            ConcurrentMap<BigInteger, List<String>> collect = dict.stream().parallel().collect(Collectors.groupingByConcurrent(AnagramPyramids::primeHash));

            int c1 = Integer.parseInt(iterator.next());
            iterator.remove();

            for (int i = 0; i < c1; i++) {
                String[] split = iterator.next().split(" ");
                iterator.remove();

                String start = split[1];
                String end = split[0];

                HashSet<String> result = check(start, collect);
                while (result.size() > 0){
                    if (result.contains(end)) break;
                    else {
                        for (String s : result) {
                            result = check(s, collect);
                        }
                    }
                }

                System.out.println(result.size() == 0 ? "no" : "yes");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static HashSet<String> check(String in, ConcurrentMap<BigInteger, List<String>> collect) {
        HashSet<String> results = new HashSet<>();
        for (char removed : in.toCharArray()) {
            BigInteger hash = BigInteger.ONE;
            for (char c : in.toCharArray()) {
                hash = hash.multiply(BigInteger.valueOf(PRIMES[Character.toLowerCase(c) - 'a']));
            }
            hash = hash.divide(BigInteger.valueOf(PRIMES[Character.toLowerCase(removed) - 'a']));
            results.addAll(collect.getOrDefault(hash, Collections.emptyList()));
        }
        return results;
    }

}
