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
            ArrayList<Integer> numbers = new ArrayList<>();

            int in;
            while ((in = sc.nextInt()) > 0) {
                numbers.add(in);
            }

            Node head = new Node(numbers.get(0));
            for (int i = 1; i < numbers.size(); i++) {
                addToTree(numbers.get(i), head);
            }

            ArrayList<Integer> tree = new ArrayList<>();
            addTreeNumbers(tree, head);

            System.out.println("Case " + ++caseNum + ": " + (numbers.equals(tree) ? "yes" : "no"));
        }
    }

    public static void addTreeNumbers(ArrayList<Integer> tree, Node node) {
        if (node == null) return;
        tree.add(node.value);
        addTreeNumbers(tree, node.leftNode);
        addTreeNumbers(tree, node.rightNode);
    }

    public static void addToTree(int num, Node node) {
        if (num < node.value) {
            if (node.leftNode == null) {
                node.leftNode = new Node(num);
            }
            else {
                addToTree(num, node.leftNode);
            }
        }
        else if (num > node.value) {
            if (node.rightNode == null) {
                node.rightNode = new Node(num);
            }
            else {
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
