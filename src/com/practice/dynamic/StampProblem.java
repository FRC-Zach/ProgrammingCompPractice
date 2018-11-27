package com.practice.dynamic;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by Zachary Herridge on 10/18/2017.
 */
public class StampProblem {

    static int[] memory;

    public static int runDenominations(int[] denominations, int goal) {
        if(goal == 0) return 0;

         memory = new int [goal + 1];
        Arrays.fill(memory, 1, goal + 1, Integer.MAX_VALUE);

        for(int index = 0; index <= goal; index++){
            for(int value : denominations){
                if (index + value > goal) continue;

                //[0, 1, 2, 3, 1, 2, 3,... ]


                if(memory[index] != Integer.MAX_VALUE){
//If memory[i + value] is not already a coin (memory[i + value]) then set it to (memory[i] + 1) aka 1 more of the current value
                    memory[index + value] = Math.min(memory[index + value], memory[index] + 1);
                }
            }
        }

        if(memory[goal] >= Integer.MAX_VALUE) return -1;

        return memory[goal];
    }

    public static void main(String[] args) {
        System.out.println(runDenominations(new int[]{1, 5, 10, 12, 25, 50}, 79));
        System.out.println();
    }

}
