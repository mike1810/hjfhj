package Collections.CollectionsTest;
import java.util.*;

import java.text.SimpleDateFormat;

public class HashMapTest {
    public static void main(String[] args) {

        HashMap<Integer, String> runners = new HashMap< Integer, String >(){{
            put( 1, "Lena" );
            put( 4, "Leonard");
            put( 59, "Ivan");
            put( 5, "Tommy");
            put( 5, "Bobby");
        }};


        System.out.println("\nWe added some runners into HashMap.");
        for(Map.Entry< Integer, String > item : runners.entrySet()){
            System.out.println("ID: " + item.getKey() + " Name: " + item.getValue());
        }


        System.out.println("\nWe removed runner with key = 59");
        runners.remove(59);
        printHashMap(runners);


        System.out.println("\nWe edited values with keys: 1,4");
        runners.replace(1, "Boris");
        runners.put( 4, "Tony");
        printHashMap(runners);


        System.out.println("\nWe added new runner:");
        runners.put(3, "Tonya");
        printHashMap(runners);


        System.out.println("\nSorted values:");
        List<String> hashMapValues = new ArrayList<>(runners.values());
        Collections.sort(hashMapValues);
        hashMapValues.forEach(a -> System.out.println("Name = " + a));


        Map<Integer, String> sorter = new TreeMap<>(runners);
        sorter.putAll(runners);
        System.out.println("\nSorted united HashMap(it is already sorted, but we sorted it again):");
        for (Map.Entry<Integer, String> entry : sorter.entrySet())
            System.out.println("ID: " + entry.getKey() +
                    " Name: " + entry.getValue());
    }

    private static void printHashMap(HashMap<Integer, String > runners){
        runners.forEach((k,v) -> System.out.println( "ID: " + k + " Name: " + v));
    }


}
