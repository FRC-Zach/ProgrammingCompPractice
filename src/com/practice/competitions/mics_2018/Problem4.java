package com.practice.competitions.mics_2018;

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
public class Problem4 {
    static String output = "";
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int minVal = sc.nextInt();
        int maxVal = sc.nextInt();
        int[] primes = new int[2000000]; // zero indexing
        primes[1] = 1;
        for (int i = 2; i < 2000000; i++){
            if (primes[i] != -1){ // not already set to not prime
                primes[i] = 1;
                for (int a = 2 * i; a < 2000000; a+=i){
                    primes[a] = -1;
                }
            }
        } 
//        for (int i = 2; i < 2000000; i++){
//            primes[i] = 1;
//            for (int a = 2; a < 2000000; a++){
//           
//            }
//        }
        for (int i = minVal; i < maxVal; i++){
            if (primes[i] == 1){
                isCircularPrime(i, primes);
            }
        }
        System.out.print(output.trim());
    }
    
    static String swap(String str){
        char last = str.charAt(str.length() - 1);
        return last + str.substring(0, str.length() - 1);
    }
    
    static void isCircularPrime(int num, int primes[]){
        String startVal = "" + num;
        String cur = startVal;
        boolean works = true;
        for (int i = 0; i < startVal.length() - 1; i++){
            cur = swap(cur);
            if (primes[Integer.parseInt(cur)] == -1){
                works = false;
                break;
            }
        }
        if (works){
           output += num + "\n";
        }
    }
}
