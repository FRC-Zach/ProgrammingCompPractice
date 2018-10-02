/*
package com.practice.competitions.mics_2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*


*/
/**
 *
 * @author reunion
 *//*



public class Problem6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        ArrayList<Node> nodes = new ArrayList<>();
        
        for (int i = 0; i < caseNum; i++){
            // Throwaway Levels
            sc.nextInt();
            // Head
            nodes.clear();
            nodes.add(new Node(null, sc.nextInt(), 0));
            String line = sc.nextLine().trim();
            String[] childNodes = line.split(" ");
            int curAddNodeIndex = 0; // node to add children to
            for (int a = 0; a < childNodes.length - 1; a+=2){
                int leftNodeVal = Integer.parseInt(childNodes[a]);
                int rightNodeVal = Integer.parseInt(childNodes[a+1]);
                nodes.get(curAddNodeIndex).left = new Node(nodes.get(curAddNodeIndex), leftNodeVal, (a + 1));
                nodes.get(curAddNodeIndex).right = new Node(nodes.get(curAddNodeIndex), rightNodeVal, (a + 2));
                nodes.add(nodes.get(curAddNodeIndex).left);
                nodes.add(nodes.get(curAddNodeIndex).right);
                curAddNodeIndex++;
            }
            
            rec(nodes.get(0));
            
            System.out.println("Inc: " + incor + " " + l2);
            
        }
    }
    
    static Node incor = null;
    static List<Node> l2 = new ArrayList<>();
    static void rec(Node node){
       if(!node.hasChildren()) {
           l2.add(node);
           return;
       }
       if((node.par != null && !node.par.correct) && node.val != node.left.val + node.right.val){
           incor = node;
       }
       else{
           node.correct = true;
       }
       rec(node.left);
       rec(node.right);
    }
    
    static void recurse(int caseNum, Node node){
        if (node == null || (node.left == null && node.right == null)){
            return;
        }
        int expectedVal = ((node.left != null) ? node.left.val : 0) + ((node.right != null) ? node.right.val : 0);
        if (node.val != expectedVal){
//            int expectedVal = node.val - node.left.val;
            Node incorrect = node;
            boolean solved = false;
            while (!solved){
                if (incorrect.val == incorrect.left.val + incorrect.right.val){
                    System.out.println("Case "+caseNum+": " + incorrect.right.index + " " + (incorrect.val - incorrect.left.val));
//                }
//                else if (incorrect.right.right == null){ // leaf
//                    System.out.println("Case "+caseNum+": " + incorrect.right.index + " " + (incorrect.val - incorrect.left.val));
//                    return;
                } else if (incorrect.right.right == null){ // leaf
                    System.out.println("Case "+caseNum+": "+incorrect.index + " " + expectedVal);
                    return;
                } else if (incorrect.right.val != (incorrect.right.left.val + incorrect.right.right.val)){
                    incorrect = incorrect.right;
                }
             
            }
        }
        recurse(caseNum, node.left);
        recurse(caseNum, node.right);
    }

    class Node{
        public int val;
        public Node par;
        public Node left;
        public Node right;
        public int index;
        public boolean correct = false;

        public Node(int val){
            this.val = val;
        }

        public Node(Node par, int val, int index){
            this.par = par;
            this.val = val;
            this.index = index;
        }

        boolean hasChildren(){
            return left != null && right != null;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", left=" + left + ", right=" + right + ", index=" + index + ", correct=" + correct + '}';
        }
    }
}
*/
