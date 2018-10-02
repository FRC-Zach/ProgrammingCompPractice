package com.practice.competitions.mics_2018;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reunion
 */
public class Problem8 {
    
    private static HashMap<BigInteger, BigInteger> mem = new HashMap<>();
    
    public static BigInteger rec(BigInteger in){
        
        if(mem.containsKey(in)) return mem.get(in);
        
        if(in.compareTo(BigInteger.valueOf(-8)) <= 0){
            BigInteger x = rec(in.add(BigInteger.valueOf(5))).add(rec(in.add(BigInteger.valueOf(4)))).add(rec(in.add(BigInteger.valueOf(2))));
            mem.put(in , x);
            return x;
        }
        else if(in.compareTo(BigInteger.valueOf(10)) == -1){
            return in;
        }
        
        BigInteger x = rec(in.subtract(BigInteger.valueOf(8))).add(rec(in.subtract(BigInteger.valueOf(5)))).add(rec(in.subtract(BigInteger.valueOf(3))));
        mem.put(in , x);
        return x;
    }
    
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        long runs = in.nextLong();
        
        String output = "";
        for (int i = 0; i < runs; i++) {
            long input = in.nextLong();
            output += "Case " + (i + 1) + ": H(" + input + ") = " + rec(BigInteger.valueOf(input)) + "\n";
        }
        
        System.out.println(output.trim());
    }
}
