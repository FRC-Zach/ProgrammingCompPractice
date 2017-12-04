package com.practice.sorting;

import java.util.Arrays;

public class BSTIndex {

    public static int maxIndex = 0;

    public static void main(String[] args) {
        int[] input = new int[]{50, 70, 30, 80, 34, 32, 9, 47, 18};

        Node root = new Node(input[0], 0);
        for (int i = 1; i < input.length; i++) {
            place(root, input[i]);
        }

        System.out.println(maxIndex);
    }

    private static void place(Node current, int value) {
        boolean left = current.getValue() > value;
        if (current.getChild(left) != null) {
            place(current.getChild(left), value);
        } else {
            current.setChild(new Node(value, current.getIndex() * 2 + (left ? 1 : 2)), left);
        }
    }

    public static class Node {

        private int value;
        private int index;
        private Node left;
        private Node right;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
            if (index > maxIndex) maxIndex = index;
        }

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }

        public Node getChild(boolean left) {
            return (left ? this.left : this.right);
        }

        public Node setChild(Node child, boolean left) {
            if (left) this.left = child;
            else this.right = child;
            return this;
        }
    }
}
