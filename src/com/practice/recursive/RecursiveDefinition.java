package com.practice.recursive;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zachary Herridge on 10/18/2017.
 */
public class RecursiveDefinition {

    private static Map<BigInteger, BigInteger> memory = new HashMap<>();

    static int calls = 0;
    public static BigInteger recursiveDefinition(BigInteger n){
        calls++;
        BigInteger memorizedInt = memory.get(n);
        if (memorizedInt != null) return memorizedInt;

        if (BigInteger.valueOf(3).compareTo(n) > 0){
            memory.put(n, n);
            return n;
        }

        BigInteger result = recursiveDefinition(n.subtract(BigInteger.valueOf(2)))
                .subtract(recursiveDefinition(n.subtract(BigInteger.valueOf(4))))
                .add(recursiveDefinition(n.subtract(BigInteger.valueOf(5))))
                .subtract(recursiveDefinition(n.subtract(BigInteger.valueOf(8))));

        memory.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        memory.put(BigInteger.valueOf(3), BigInteger.valueOf(10));

        BigInteger bigInteger = recursiveDefinition(BigInteger.valueOf(8));
        System.out.println(bigInteger);
    }
}
