package com.practice.recursive;

public class AlternativeRoutes {

    private static int count = 0;
    private static void rec(int x, int y, int gX, int gY){
        if (x == gX && y == gY){
            count++;
            return;
        }

        if (x + 1 <= gX) rec(x + 1, y, gX, gY);
        if (y + 1 <= gY) rec(x, y  + 1, gX, gY);
    }

    private static int getP(int dimX, int dimY){
        count = 0;
        rec(0, 0, dimX, dimY);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getP(20, 4));
    }
}
