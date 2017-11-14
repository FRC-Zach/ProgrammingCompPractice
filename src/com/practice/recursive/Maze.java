package com.practice.recursive;

import java.awt.*;
import java.util.HashSet;

public class Maze {

    private static char[][] maze = new char[][]{
            {' ', 'a', '*', ' ', ' '},
            {'A', ' ', ' ', ' ', ' '}
    };

    private static int[][] mazeH = new int[][]{
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}

    };


    private static void set(int x, int y, int value){
        try {
            mazeH[x][y] = value;
        }
        catch (Throwable e){
        }
    }

    public static Point find(char search){
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == search) return new Point(i, j);
            }
        }
        return null;
    }

    private static void expand(int x, int y, int lastValue){
        try {
            char c = maze[x][y];

            if (c == '*') return;

            int i = mazeH[x][y];
            if (lastValue + 1 < i){
                mazeH[x][y] = lastValue + 1;
            }
            else {
                return;
            }

            if (Character.isAlphabetic(c) && Character.isLowerCase(c)){
                Point point = find(Character.toUpperCase(c));
                if (point != null){
                    expand(point.x, point.y, mazeH[x][y]);
                }
            }

            expand(x + 1, y, mazeH[x][y]);
            expand(x - 1, y, mazeH[x][y]);
            expand(x, y + 1, mazeH[x][y]);
            expand(x, y - 1, mazeH[x][y]);
        }
        catch (Throwable e){
        }
    }

    public static void main(String[] args) {
        expand(0, 0, -1);
        for (int i = 0; i < mazeH.length; i++) {
            for (int j = 0; j < mazeH[i].length; j++) {
                System.out.print((mazeH[i][j] == Integer.MAX_VALUE ? "*" : mazeH[i][j]) + " ");
            }
            System.out.println();
        }
    }
}
