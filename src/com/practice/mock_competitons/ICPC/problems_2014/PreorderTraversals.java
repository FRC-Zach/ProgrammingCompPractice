package com.practice.mock_competitons.ICPC.problems_2014;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PreorderTraversals {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input/preorderTraversals.txt"));

        int caseNum = 0;
        while (sc.hasNextInt()) {
            caseNum++;
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            int x = 0;
            while ((x = sc.nextInt()) > 0) {
                numbers.add(x);
            }
            Node head = new Node(numbers.get(0));
            for (int i = 1; i < numbers.size(); i++) {
                addToTree(numbers.get(i), head);
            }
            ArrayList<Integer> tree = new ArrayList<Integer>();
            addTreeNumbers(tree, head);

            String output = (numbers.equals(tree)) ? "yes" : "no";
            System.out.println("Case " + caseNum + ": " + output);
        }
    }

    public static void addTreeNumbers(ArrayList<Integer> tree, Node node) {
        if (node == null) {
            return;
        }
        tree.add(node.value);
        addTreeNumbers(tree, node.leftNode);
        addTreeNumbers(tree, node.rightNode);
    }

    public static void addToTree(int num, Node node) {
        if (num < node.value) {
            if (node.leftNode == null) {
                node.leftNode = new Node(num);
                return;
            } else {
                addToTree(num, node.leftNode);
            }
        }
        if (num > node.value) {
            if (node.rightNode == null) {
                node.rightNode = new Node(num);
                return;
            } else {
                addToTree(num, node.rightNode);
            }
        }
    }


    public static class Node {
        public Node leftNode;
        public Node rightNode;
        public int value;

        public Node(int val){
            value = val;
        }
    }
}
