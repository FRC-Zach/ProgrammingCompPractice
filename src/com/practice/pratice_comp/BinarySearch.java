package com.practice.pratice_comp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("BinarySearchInput.txt"));
        int caseNum = 0;
        while (sc.hasNextInt()) {
            caseNum++;
            int amount = sc.nextInt();
            ArrayList<Integer> inputs = new ArrayList<Integer>();
            for (int i = 0; i < amount; i++) {
                inputs.add(i * 5);
            }

            int count = 0;
            for (int i = 0; i < inputs.size(); i++){
                count += Search(inputs.get(i), inputs);
            }
            System.out.println("Case "+caseNum+": "+count);
        }
    }

    static int Search(int num, ArrayList<Integer> inputs){
        int count  = 0;
        int Low = 0;
        int High = inputs.size() - 1;
        while (Low <= High){
            count++;
            int Mid = (Low + High) / 2;
            if (inputs.get(Mid) == num){
                break;
            }
            if (inputs.get(Mid) < num){
                Low = Mid + 1;
            }
            if (inputs.get(Mid) > num){
                High = Mid - 1;
            }
        }
        return count;
    }
}