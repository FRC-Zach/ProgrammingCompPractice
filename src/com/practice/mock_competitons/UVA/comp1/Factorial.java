package com.practice.mock_competitons.UVA.comp1;

import java.math.BigInteger;
import java.util.Map;
import java.util.stream.Collectors;

public class Factorial {

    public static BigInteger factorial(int in){
        BigInteger out = BigInteger.ONE;
        for (int i = in; i > 0; i--) {
            out = out.multiply(BigInteger.valueOf(i));
        }
        return out;
    }

    public static Map<Integer, Long> freg(int in){
        return factorial(in).toString().chars().mapToObj(value -> Integer.parseInt("" + ((char) value))).collect(Collectors.groupingBy(Object::hashCode, Collectors.counting()));
    }

    public static void main(String[] args) {

        args = new String[]{"3"};

        for (String in : args) {
            Map<Integer, Long> freg = freg(Integer.parseInt(in));


            System.out.println(in +  "! --");
            for (int i = 0; i <= 4; i++) {
                System.out.print("(" + i + ") " + freg.getOrDefault(i, 0L) + " ");
            }
            System.out.println();
            for (int i = 5; i <= 9; i++) {
                System.out.print("(" + i + ") " + freg.getOrDefault(i, 0L) + " ");
            }
        }
    }

}
