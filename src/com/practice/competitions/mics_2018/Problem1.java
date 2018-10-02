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
public class Problem1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String css = "CCCCC     SSSSS     SSSSS\n"
                    +"C         S         S    \n"
                    +"C         SSSSS     SSSSS\n"
                    +"C             S         S\n"
                    +"CCCCC     SSSSS     SSSSS";
        
        
        int caseCount = sc.nextInt();
        for (int i = 0; i < caseCount; i++){
            int scale = sc.nextInt();
            String[] lines = css.split("\n");
            String output = "";
            for (String line : lines){
            String outLine = "";
                for (int a = 0; a < line.length(); a++){
                    for (int y = 0; y < scale; y++){
                        outLine += line.charAt(a);
                    }
                }
                for (int a = 0; a < scale; a++){
                    output += outLine + "\n";
                }
            }
            System.out.println("Case "+(i+1)+":");
            System.out.println(output.trim());
            for (int a = 0; a < 5; a++){
                System.out.println();
            }
        }
    }
}
