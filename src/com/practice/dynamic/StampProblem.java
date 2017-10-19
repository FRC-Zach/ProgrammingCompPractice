package com.practice.dynamic;

import java.util.Arrays;

/**
 * Created by Zachary Herridge on 10/18/2017.
 */
public class StampProblem {

    public static int runDenominations(int[] denominations, int goal) {
        if(goal == 0) return 0;

        int[] memory = new int [goal + 1];
        Arrays.fill(memory, 1, goal + 1, Integer.MAX_VALUE);

        for(int index = 0; index <= goal; index++){
            for(int value : denominations){
                if (index + value > goal) continue;

                if(memory[index] != Integer.MAX_VALUE){
                    memory[index + value] = Math.min(memory[index + value], memory[index] + 1); //If memory[i + value] is not already a coin (memory[i + value]) then set it to (memory[i] + 1) aka 1 more of the current value
                }
            }
        }

        if(memory[goal] >= Integer.MAX_VALUE) return -1;

        return memory[goal];
    }

    public static void main(String[] args) {
        System.out.println(runDenominations(new int[]{5, 7, 10}, 263));
    }

}
