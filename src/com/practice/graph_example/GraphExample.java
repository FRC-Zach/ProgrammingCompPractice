package com.practice.graph_example;

import java.util.*;

public class GraphExample {

    public static List<Node> findPath(Node start, Node end){
        List<Node> openList = new ArrayList<>();
        Map<Node, Integer> costStore = new HashMap<>();
        Map<Node, Node> edgeCache = new HashMap<>();

        openList.add(start);
        costStore.put(start, 0);
        edgeCache.put(start, null);

        while (!openList.isEmpty()){
            Node current = openList.remove(0);

            int currentCost = costStore.getOrDefault(current, Integer.MAX_VALUE);
            for (Edge edge : current.connections) {
                int estimatedCost = currentCost+ edge.weight;
                if (estimatedCost < costStore.getOrDefault(edge.end, Integer.MAX_VALUE)){
                    costStore.put(edge.end, estimatedCost);
                    edgeCache.put(edge.end, current);


                    if (edge.end.equals(end)){
                        //Found path we're done.
                        List<Node> path = new ArrayList<>();

                        Node node = end;
                        while (node != null){
                            path.add(node);
                            node = edgeCache.get(node);
                        }

                        Collections.reverse(path);
                        return path;
                    }

                    if (!openList.contains(edge.end)) openList.add(edge.end);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");
        Node n4 = new Node("D");
        Node n5 = new Node("E");
        Node n6 = new Node("F");

        n1.connections.add(new Edge(3, n1, n2));
        n2.connections.add(new Edge(3, n2, n1));

        n2.connections.add(new Edge(4, n2, n3));
        n3.connections.add(new Edge(4, n3, n4));
        n2.connections.add(new Edge(12, n2, n4));
        n4.connections.add(new Edge(7, n4, n6));
        n4.connections.add(new Edge(7, n4, n5));

        List<Node> path = findPath(n1, n5);
        System.out.println("Result: "  + path);
    }


    public static class Node {

        public String name;
        public List<Edge> connections = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            if (name != null ? !name.equals(node.name) : node.name != null) return false;
            return connections != null ? connections.equals(node.connections) : node.connections == null;
        }


        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class Edge {

        public int weight;
        public Node start;
        public Node end;

        public Edge(int weight, Node start, Node end) {
            this.weight = weight;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "weight=" + weight +
                    ", start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Edge)) return false;

            Edge edge = (Edge) o;

            if (weight != edge.weight) return false;
            if (start != null ? !start.equals(edge.start) : edge.start != null) return false;
            return end != null ? end.equals(edge.end) : edge.end == null;
        }

        @Override
        public int hashCode() {
            int result = weight;
            result = 31 * result + (start != null ? start.hashCode() : 0);
            result = 31 * result + (end != null ? end.hashCode() : 0);
            return result;
        }
    }
}
