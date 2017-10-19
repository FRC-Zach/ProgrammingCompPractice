package com.acuity.control.client.mics;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zachary Herridge on 10/18/2017.
 */
public class RecursiveDefinition {


    private static Map<BigInteger, BigInteger> memory = new HashMap<>();

    public static BigInteger recursiveMethod(BigInteger n){
        BigInteger bigInteger = memory.get(n);
        if (bigInteger != null) return bigInteger;

        if (BigInteger.valueOf(3).compareTo(n) > 0){
            memory.put(n, n);
            return n;
        }

        BigInteger result = recursiveMethod(n.subtract(BigInteger.valueOf(2)))
                .subtract(recursiveMethod(n.subtract(BigInteger.valueOf(4))))
                .add(recursiveMethod(n.subtract(BigInteger.valueOf(5))))
                .subtract(recursiveMethod(n.subtract(BigInteger.valueOf(8))));

        memory.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        memory.put(BigInteger.valueOf(3), BigInteger.valueOf(10));

        BigInteger bigInteger = recursiveMethod(BigInteger.valueOf(9006));
        System.out.println(bigInteger);
    }

}
