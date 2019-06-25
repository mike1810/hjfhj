package Collections.CollectionsTest;

import java.util.*;

public class ArrayListTest {

    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList<>();

        array.add(1);
        array.add(-4);
        array.add(11);
        array.add(-4);
        array.add(-5);
        array.add(8);
        array.add(5);

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
        System.out.println("\nWe sorted array:");

        Iterator arrayIterator = array.iterator();
        while(arrayIterator.hasNext()){
            System.out.print(arrayIterator.next() + " ");
        }
    }

    private static void printHashSet(ArrayList<Integer> array){
        for(Integer a : array){
            System.out.print(a + " ");
        }
    }
}
