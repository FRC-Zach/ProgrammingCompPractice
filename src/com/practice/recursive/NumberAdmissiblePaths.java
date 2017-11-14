package com.practice.recursive;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberAdmissiblePaths {

    private static Set<String> paths = new HashSet<>();
    private static void rec(int x, int y, int gX, int gY, String path){
        if (x == gX && y == gY){
            paths.add(path);
            return;
        }

        if ((x != 0 && y != 0) && isPerfectNumber(x) && isPerfectNumber(y) && isPerfectNumber(x + y)){
            return;
        }

        if (x + 1 <= gX){
            rec(x + 1, y, gX, gY, path + (x + 1) + ","  + y + " ");
        }

        if (y + 1 <= gY){
            rec(x, y  + 1, gX, gY, path + x + ","  + (y + 1) + " ");
        }
    }

    private static Map<Integer, Boolean> mem = new HashMap<>();
    private static boolean isPerfectNumber(int number){
        return mem.computeIfAbsent(number, integer -> {
            int temp = 0;
            for(int i=1; i <= number / 2; i++){
                if(number % i == 0){
                    temp += i;
                }
            }
            return temp == number;
        });
    }

    private static int getP(int dim){
        rec(0, 0, dim, dim, "");
        return paths.size();
    }

    public static void main(String[] args) {
        System.out.println("Paths: " + getP(5));
    }
}

