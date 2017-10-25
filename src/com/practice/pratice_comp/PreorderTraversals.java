package com.practice.pratice_comp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PreorderTraversals {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("preorderTraversals.txt"));
        int caseNum = 0;
        while (sc.hasNextInt()){
            caseNum++;
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            int x = 0;
            while ((x = sc.nextInt()) > 0){
                numbers.add(x);
            }
            Node head = new Node(numbers.get(0));
            for (int i = 1; i < numbers.size(); i++){
                AddToTree(numbers.get(i), head);
            }
            ArrayList<Integer> tree = new ArrayList<Integer>();
            AddTreeNumbers(tree, head);

            String output = (numbers.equals(tree)) ? "yes" : "no";
            System.out.println("Case "+caseNum+": "+output);
        }
    }

    static void AddTreeNumbers(ArrayList<Integer> tree, Node node){
        if (node == null){
            return;
        }
        tree.add(node.value);
        AddTreeNumbers(tree, node.leftNode);
        AddTreeNumbers(tree, node.rightNode);
    }

    static void AddToTree(int num, Node node){
        if (num < node.value){
            if (node.leftNode == null){
                node.leftNode = new Node(num);
                return;
            } else {
                AddToTree(num, node.leftNode);
            }
        }
        if (num > node.value) {
            if (node.rightNode == null){
                node.rightNode = new Node(num);
                return;
            } else {
                AddToTree(num, node.rightNode);
            }
        }
    }
}

class Node {
    public Node leftNode;
    public Node rightNode;
    public int value;

    public Node(int val){
        value = val;
    }
}
