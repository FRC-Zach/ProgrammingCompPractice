package com.practice.dynamic;

import java.util.Arrays;

/**
 * Created by Zachary Herridge on 10/18/2017.
 */
public class StampProblem {

    public static int coinChangeDynamic(int[] coins, int goal) {
        if(goal == 0) return 0;

        int[] memory = new int [goal + 1];
        Arrays.fill(memory, 1, goal + 1, Integer.MAX_VALUE);

        for(int index = 0; index <= goal; index++){
            for(int coin : coins){
                if (index + coin > goal) continue;

                if(memory[index] != Integer.MAX_VALUE){
                    memory[index + coin] = Math.min(memory[index + coin], memory[index] + 1); //If memory[i + coin] is not already a coin (memory[i + coin]) then set it to (memory[i] + 1) aka 1 more of the current coin
                }
            }
        }

        if(memory[goal] >= Integer.MAX_VALUE) return -1;

        return memory[goal];
    }

    public static void main(String[] args) {
        System.out.println(coinChangeDynamic(new int[]{5, 7, 10}, 263));
    }

}
