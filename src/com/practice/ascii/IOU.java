package com.practice.ascii;

public class IOU {

    private static char[][] def = new char[][]{
            new char[]{'i', 'i' , 'i'},
            new char[]{' ', 'i', ' '},
            new char[]{'i', 'i', 'i'},

            new char[]{'o', 'o', 'o'},
            new char[]{'o', ' ', 'o'},
            new char[]{'o', 'o', 'o'},

            new char[]{'u', ' ', 'u'},
            new char[]{'u', ' ', 'u'},
            new char[]{'u', 'u', 'u'},
    };


    public static void main(String[] args) {
        int scale = 2;

        for (char[] line : def) {
            for (int i = 0; i < scale; i++) {
                for (char c : line) {
                    for (int j = 0; j < scale; j++) {
                        System.out.print(c);
                    }
                }
                System.out.println();
            }
        }
    }
}
