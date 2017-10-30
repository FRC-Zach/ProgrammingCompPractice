package com.practice.mock_competitons.ICPC.problems_2014;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RankOrder {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input/rankOrderInput"));

        int caseNum = 0;
        while (sc.hasNextInt()){

            int ratingCount = sc.nextInt();
            ArrayList<Integer> inputOne = new ArrayList<>();
            ArrayList<Integer> inputTwo = new ArrayList<>();

            for (int i = 0; i < ratingCount; i++){
                inputOne.add(sc.nextInt());
            }
            for (int i = 0; i < ratingCount; i++){
                inputTwo.add(sc.nextInt());
            }

            ArrayList<Integer> sortedOne = new ArrayList<>(inputOne);
            ArrayList<Integer> sortedTwo = new ArrayList<>(inputTwo);

            sortedOne.sort((o1, o2) -> -Integer.compare(o1, o2));
            sortedTwo.sort((o1, o2) -> -Integer.compare(o1, o2));

            int found = -1;
            for (int i =  0; i < sortedOne.size(); i++){
                if (inputOne.indexOf(sortedOne.get(i)) != inputTwo.indexOf(sortedTwo.get(i))){
                    found = i+1;
                    break;
                }
            }

            System.out.println("Case "+ (caseNum++) +": " + (found == -1 ? "agree" : "" + found));
        }
    }
}
