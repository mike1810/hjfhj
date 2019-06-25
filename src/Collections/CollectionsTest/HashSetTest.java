package Collections.CollectionsTest;

import java.util.*;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> myFamily = new HashSet<>();

        myFamily.add("Oleg");
        myFamily.add("Daniil");
        myFamily.add("Phil");
        myFamily.add("Boris");
        myFamily.add("Tolik");

        System.out.println("\nWe added some numbers into HashSet.");

        System.out.println("\nHashSet values:");
        printArrayList(myFamily);


        myFamily.remove("Oleg");
        System.out.println("\nWe removed Oleg from HashSet:");
        printArrayList(myFamily);


        HashSet<String> brotherFamily = new HashSet<>();
        brotherFamily.add("Anna");
        brotherFamily.add("Olya");
        brotherFamily.add("Tolik");

        System.out.println("\nWe created new HashSet:");
        printArrayList(brotherFamily);


        myFamily.addAll(brotherFamily);
        System.out.println("\nWe united our HashSets and sorted:");

        Set<String> sorter = new TreeSet<>(myFamily);
        for(String s : sorter){
            System.out.print(s + " ");
        }

        System.out.println("\n\nUnsorted united HashSet:");

        Iterator hashSetIterator = myFamily.iterator();
        while(hashSetIterator.hasNext()){
            System.out.print(hashSetIterator.next() + " ");
        }
    }

    private static void printArrayList(HashSet<String> hashSet){
        for(String a : hashSet){
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
