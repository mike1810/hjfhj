package Collections.CollectionsTest;
import java.util.*;

import java.text.SimpleDateFormat;

public class HashMapTest {
    public static void main(String[] args) {

        HashMap< Integer, String > runners = new HashMap<>();

        runners.put(1, "Lena" );
        runners.put( 4, "Leonard");
        runners.put( 59, "Ivan");
        runners.put( 5, "Tommy");

        System.out.println("\nWe added some people into HashMap.");
        //printHashMap(runners);

        for(Map.Entry< Integer, String > item : runners.entrySet()){
            System.out.println("ID: " + item.getKey() + " Name: " + item.getValue());
        }

        Person ivan = new Person("Ivan");
        runners.remove(ivan);
        System.out.println("\nWe removed person with key = 1");
        printHashMap(runners);

        runners.replace(1, "Boris");
        System.out.println("\nWe edited value with key = 1");
        printHashMap(runners);

        System.out.println("\n\nUnsorted united HashMap:");
        printHashMap(runners);

        System.out.println("\n\nSorted HashMap:");
        List<String> hashMapValues = new ArrayList<>(runners.values());
        Collections.sort(hashMapValues);
        

        TreeMap<Integer, String> sorter = new TreeMap<>(runners);
        sorter.putAll(runners);
        for (HashMap.Entry<Integer, String> entry : sorter.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }

    private static void printHashMap(HashMap<Integer, String > runners){
        runners.forEach((k,v) -> System.out.println( "Name: " + k + " Class: " + v));
    }


}
