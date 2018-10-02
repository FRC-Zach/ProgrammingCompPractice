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
public class Problem3 {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String encode = in.replaceAll("\t", "1").replaceAll(" ", "0");
        String output = "";
        for (int i = 0; i < in.length(); i+= 7) {
            String temp = encode.substring(i, i + 7);
            char out = (char) Integer.parseInt(Integer.toString(Integer.parseInt(temp, 2), 10));
            output += out;
        }
        System.out.println(output);
        
    }
}
