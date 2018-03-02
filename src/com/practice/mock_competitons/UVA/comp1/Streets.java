package com.practice.mock_competitons.UVA.comp1;

import java.util.*;
import java.util.stream.Collectors;

public class Streets {

    private Map<Integer, Node> map = new HashMap<>();
    private List<String> results = new ArrayList<>();

    public Node getNode(Integer id){
        return map.computeIfAbsent(id, Node::new);
    }

    public String findPath(Node start){
        int goal = map.values().stream().mapToInt(value -> value.getConnected().size()).sum();
        rec(start, new ArrayList<>(), goal / 2 );
        return results.stream().sorted(String::compareTo).findFirst().orElse("Round trip does not exist");
    }

    private void rec(Node current, List<Connection> path, int goal){
        if (current.getId() == 1 && path.size() == goal){
            results.add(path.stream().map(connection -> connection.getStreet() + "").collect(Collectors.joining(" ")));
        }

        for (Connection connection : current.getConnected()) {
            if (!path.contains(connection)){
                ArrayList<Connection> pathCopy = new ArrayList<>(path);
                pathCopy.add(connection);
                rec(connection.getEnd(), pathCopy, goal);
            }
        }
    }

    public static void main(String[] args) {
        Streets streets = new Streets();
        //args = new String[]{"1 2 1", "2 3 2", "3 1 6", "1 2 5", "2 3 3", "3 1 4"};
        args = new String[]{"1 2 1", "1 2 2", "1 2 4", "1 4 3", "4 3 6", "2 3 5"};
        
        for (String arg : args) {
            String[] split = arg.split(" ");

            streets.getNode(Integer.parseInt(split[0])).getConnected().add(new Connection(Integer.parseInt(split[2]), streets.getNode(Integer.parseInt(split[1]))));
            streets.getNode(Integer.parseInt(split[1])).getConnected().add(new Connection(Integer.parseInt(split[2]), streets.getNode(Integer.parseInt(split[0]))));
        }

        Node start = streets.getNode(1);
        System.out.println(streets.findPath(start));
    }


    private static class Connection{

        private int street;
        private Node end;

        public Connection(int street, Node end) {
            this.street = street;
            this.end = end;
        }

        public int getStreet() {
            return street;
        }

        public Node getEnd() {
            return end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Connection that = (Connection) o;
            return street == that.street;
        }

        @Override
        public int hashCode() {

            return Objects.hash(street);
        }
    }

    private static class Node{

        private int id;
        private List<Connection> connected = new ArrayList<>();

        public Node(int id) {
            this.id = id;
        }

        public List<Connection> getConnected() {
            return connected;
        }

        public int getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {

            return Objects.hash(id);
        }
    }

}
