package Collections.PersonList;

import java.util.*;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static ArrayList<Person> removeDuplicates(ArrayList<Person> uniqueFromThisList) {
        HashSet<Person> personHashSet = new HashSet<>(uniqueFromThisList);
        return new ArrayList<>(personHashSet);
    }

    public static boolean compareLists(ArrayList<Person> first, ArrayList<Person> second) {

        if (first.size() != second.size()) {
            return false;
        }

        ArrayList<Person> comparedTo = new ArrayList<>();
        ArrayList<Person> comparedWith = new ArrayList<>();

        for (Person person : first) {
            if (personIsIn(comparedWith, person)) {
                comparedTo.remove(person);
                comparedWith.remove(person);
            }
        }

        if (comparedTo.size() == comparedWith.size() && comparedTo.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean personIsIn(ArrayList<Person> comparedWith, Person person) {
        boolean isIn = false;
        for (Person a : comparedWith) {
            if (a.equals(person)) {
                isIn = true;
            }
        }
        return isIn;
    }

    @Override
    public int compareTo(Person comparedWith) {
        return name.compareTo(comparedWith.name);
    }

    public static class SortByAge implements Comparator<Person> {
        @Override
        public int compare(Person compared, Person comparedWith) {
            if (compared.age < comparedWith.age) {
                return -1;
            } else {
                if (compared.age > comparedWith.age) {
                    return 1;
                } else
                    return 0;
            }
        }
    }

    public static class SortByName implements Comparator<Person> {
        @Override
        public int compare(Person compared, Person comparedWith) {
            return compared.name.compareTo(comparedWith.name);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Name: " + name + " Age: " + age;
    }

    @Override
    public boolean equals(Object comparedWith) {
        if (comparedWith != null && comparedWith.getClass().equals(this.getClass())) {
            if (this.compareTo((Person) comparedWith) == 0)
                return true;
        }
        return false;
    }


}
