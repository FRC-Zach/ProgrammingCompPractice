package com.practice.mock_competitons.ICPC.problems_2014;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input/BinarySearchInput.txt"));

        int caseNum = 0;
        while (sc.hasNextInt()) {

            ArrayList<Integer> inputs = new ArrayList<>();

            int in = sc.nextInt();
            for (int i = 0; i < in; i++) {
                inputs.add(i * 5);
            }

            int count = 0;
            for (int i = 0; i < inputs.size(); i++){
                count += search(inputs.get(i), inputs);
            }
            System.out.println("Case " + (caseNum++) + ": " + count);
        }
    }

    public static int search(int num, ArrayList<Integer> inputs){
        int count  = 0;
        int low = 0;
        int high = inputs.size() - 1;
        while (low <= high){
            count++;
            int mid = (low + high) / 2;
            if (inputs.get(mid) == num){
                break;
            }
            else if (inputs.get(mid) < num){
                low = mid + 1;
            }
            else if (inputs.get(mid) > num){
                high = mid - 1;
            }
        }
        return count;
    }
}