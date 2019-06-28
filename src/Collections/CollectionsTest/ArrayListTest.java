package Collections.CollectionsTest;

import java.util.*;

public class ArrayListTest {

    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList<Integer>(){{
            add(1);
            add(-4);
            add(11);
            add(-4);
            add(-5);
            add(8);
            add(5);
        }};

        System.out.println("\nWe added some numbers into array.");

        System.out.println("Array values:");
        printHashSet(array);

        array.set(1, 2);
        System.out.println("\nWe edited value with index of 1:");
        printHashSet(array);

        array.remove(1);
        System.out.println("\nWe removed edited value:");
        printHashSet(array);

        Collections.sort(array);
        System.out.println("\nSorted array printed by Iterator:");
        Iterator arrayIterator = array.iterator();
        while(arrayIterator.hasNext()){
            System.out.print(arrayIterator.next() + " ");
        }
        System.out.println();
    }

    private static void printHashSet(ArrayList<Integer> array){
        for(Integer a : array){
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
