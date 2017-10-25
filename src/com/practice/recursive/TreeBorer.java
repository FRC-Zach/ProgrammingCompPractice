package com.practice.recursive;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Zach on 10/24/2017.
 */
public class TreeBorer {


    private int count = 0;
    public void count(int pos, List<Integer> path){
        if (path.size() == 0 || pos == path.size() - 1) return;

        Integer current = path.get(pos);
        Integer next = path.get(pos + 1);



    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(2, 1, 1, 1, 1, 2);
        TreeBorer treeBorer = new TreeBorer();
        treeBorer.count(0, integers);
        System.out.println(treeBorer.count);
    }
}
