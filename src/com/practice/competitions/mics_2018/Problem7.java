package com.practice.competitions.mics_2018;

import java.util.Arrays;
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
public class Problem7 {
    
    private static boolean[][] map;
    
    public static void fill(int x, int y, int width, int height){
        for (int i = 0; i < width; i++) {
         for (int z = 0; z < height; z++) {
             map[x + i][y + z] = !map[x + i][y + z];
         }
        }
    }
    
    public static long count(){
        long total = 0;
        for(boolean[] x : map){
             for(boolean y : x){
                 if(y) total ++;
           }
        }
        return total;
    }
    
    public static void main(String[] args) {
        
        
        Scanner scan = new Scanner(System.in);
//        scan.nextLine();
        int caseNum = Integer.parseInt(scan.nextLine());
        int caseF = 1;
        String output = "";
        for (int z = 0; z < caseNum; z++){
            String in = scan.nextLine();
            
            String[] split = in.split(" ");
            
            int sizeX = Integer.parseInt(split[0]);
            int sizeY = Integer.parseInt(split[1]);
            
            map = new boolean[sizeX][sizeY];
            for(int i = 3; i < split.length; i+=4){
              fill(Integer.parseInt(split[i]), Integer.parseInt(split[i + 1]), Integer.parseInt(split[i + 2]), Integer.parseInt(split[i + 3]));
            }
           
            output += "Case " + caseF++ + ": " + count() + "\n";
        } 
        System.out.println(output.trim());
    }
}
