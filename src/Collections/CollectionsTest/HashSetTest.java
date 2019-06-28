package Collections.CollectionsTest;

import java.util.*;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> myFamily = new HashSet<String>(){{
            add("Oleg");
            add("Daniil");
            add("Phil");
            add("Boris");
            add("Tolik");
        }};

        System.out.println( "\nWe added some values into HashSet:");
        printArrayList(myFamily);


        System.out.println("\nWe removed Oleg from HashSet:");
        myFamily.remove("Oleg");
        printArrayList(myFamily);


        HashSet<String> brotherFamily = new HashSet<String>(){{
            add("Anna");
            add("Olya");
            add("Tolik");
        }};


        System.out.println("\nWe created new HashSet:");
        printArrayList(brotherFamily);


        System.out.println("\nWe united our HashSets and sorted:");
        myFamily.addAll(brotherFamily);
        Set<String> sorter = new TreeSet<>(myFamily);
        sorter.forEach(a->System.out.print(a + " "));


        System.out.println("\n\nUnsorted united HashSet printed by Iterator:");
        Iterator hashSetIterator = myFamily.iterator();
        while(hashSetIterator.hasNext()){
            System.out.print(hashSetIterator.next() + " ");
        }
        System.out.println();
    }

    private static void printArrayList(HashSet<String> hashSet){
        for(String a : hashSet){
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
