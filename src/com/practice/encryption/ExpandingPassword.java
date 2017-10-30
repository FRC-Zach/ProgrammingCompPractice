package com.practice.encryption;

/**
 * Created by Zachary Herridge on 10/30/2017.
 */
public class ExpandingPassword {

    public static void main(String[] args) {
        String password = "9P8L7U6M@52";
        int targetLength = 16;


        char[] chars = password.toCharArray();

        StringBuilder result = null;
        for (int baseOffset = 0; baseOffset <= 7; baseOffset++) {
            result = new StringBuilder();
            for (char aChar : chars) {
                result.append(Character.isDigit(aChar) ? Integer.toString(Integer.valueOf(String.valueOf(aChar)), 9 - baseOffset) : aChar);
            }
            if (result.length() >= targetLength) break;
        }

        int missing = targetLength - result.length();
        for (int i = 0; i < missing; i++) {
            result.append("@");
        }

        System.out.println(result.toString());
    }
}
