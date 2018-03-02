package com.practice.recursive;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Zach on 10/24/2017.
 */
public class TreeBorer {

    private static int ALPH_LENGTH = 126 - 32 + 1;

    public static void main(String[] args) {
        String str = "Hello young fellow.";
        System.out.println(encode(str, 600));
        System.out.println(decode(encode(str, 600), 600));
    }

    private static int reduce(int i){
        while (i < 32){
            i += ALPH_LENGTH;
        }
        while (i > 126){
            i -= ALPH_LENGTH;
        }
        return i;
    }

    public static String decode(String enc, int offset) {
        return encode(enc, ALPH_LENGTH - offset);
    }

    public static String encode(String enc, int offset) {
        String result = "";
        for (int i = 0; i < enc.length(); i++) {
            char c = enc.charAt(i);
            result += (char) reduce(c + offset);
        }
        return result;
    }
}
