package com.practice.sorting;

public class BSTHeight {

    public static int maxHeight = 0;

    public static void main(String[] args) {
        int[] input = new int[]{50, 70, 30, 80, 34, 32, 9, 47, 18};

        Node root = new Node(input[0], 0);
        for (int i = 1; i < input.length; i++) {
            place(root, input[i]);
        }

        System.out.println(maxHeight);
    }

    private static void place(Node current, int value) {
        boolean left = current.getValue() > value;
        if (current.getChild(left) != null) {
            place(current.getChild(left), value);
        } else {
            current.setChild(new Node(value, current.getHeight() + 1), left);
        }
    }

    public static class Node {

        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value, int height) {
            this.value = value;
            this.height = height;
            if (height > maxHeight) maxHeight = height;
        }

        public int getValue() {
            return value;
        }

        public int getHeight() {
            return height;
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
