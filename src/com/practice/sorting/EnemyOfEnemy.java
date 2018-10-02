package com.practice.sorting;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Zach on 10/18/2017.
 */
public class EnemyOfEnemy {

    private static Map<String, Person> persons = new HashMap<>();

    public static Person get(String name){
        return persons.computeIfAbsent(name, Person::new);
    }

    public static boolean check(List<Person> persons){


        for (Person base : persons) {
            for (Person other : persons) {
                if (base.equals(other)) continue;

                boolean directFriend = base.getFriends().contains(other);
                boolean eoe = base.getEnemies().stream().map(Person::getEnemies).anyMatch(eoeSet -> eoeSet.contains(other));
                if (!directFriend && !eoe) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void parse(String in, boolean friends){
        String[] names = in.split(" ");
        for (String name : names) {
            Person person = get(name);
            for (String s : names) {
                if (s.equals(name)) continue;
                (friends ? person.getFriends() : person.getEnemies()).add(get(s));
            }
        }
    }

    public static void main(String[] args) {
        parse("Tom Fay", false);
        parse("Fay Mae Joe", true);
        parse("Al Mae", true);
        parse("Sam Tom", false);
        parse("Tom Al", false);
        parse("Sam Mae", true);

        System.out.println(check(Arrays.asList(get("Mae"), get("Fay"), get("Joe"))));
        System.out.println(check(Arrays.asList(get("Sam"), get("Al"), get("Fay"))));
        System.out.println(check(Arrays.asList(get("Joe"), get("Al"))));
        System.out.println(check(Arrays.asList(get("Fay"), get("Sam"), get("Tom"))));
    }

    public static class Person {

        private String name;
        private Set<Person> friends = new HashSet<>();
        private Set<Person> enemies = new HashSet<>();

        public Person(String name) {
            this.name = name;
        }

        public Set<Person> getFriends() {
            return friends;
        }

        public Set<Person> getEnemies() {
            return enemies;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (!(object instanceof Person)) return false;

            Person person = (Person) object;

            return name != null ? name.equals(person.name) : person.name == null;

        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }


}
