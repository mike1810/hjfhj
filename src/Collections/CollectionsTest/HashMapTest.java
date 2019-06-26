package Collections.CollectionsTest;
import java.util.*;

import java.text.SimpleDateFormat;

public class HashMapTest {
    public static void main(String[] args) {

        HashMap<Person, Integer> runners = new HashMap<>();

        runners.put( new Person("Dima"),  1);
        runners.put( new Person("Lena"),  4);
        runners.put( new Person("Ivan"),  5);
        runners.put( new Person("Tommy"), 57);

        System.out.println("\nWe added some people into HashMap.");
        printHashMap(runners);

        runners.remove("Ivan");
        System.out.println("\nWe removed person with key = 1");
        printHashMap(runners);

        System.out.println("\n\nUnsorted united HashMap:");
        printHashMap(runners);

        System.out.println("\n\nSorted HashMap:");
        TreeMap<Person, Integer> sorter = new TreeMap<>(runners);
        sorter.putAll(runners);
        for (HashMap.Entry<Person, Integer> entry : sorter.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }

    private static void printHashMap(HashMap<Person, Integer> runners){
        runners.forEach((k,v) -> System.out.println( "Name: " + k + " Class: " + v));
    }


}
