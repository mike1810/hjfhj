package Collections.CustomLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Demo {
        public static void main(String[] args) {
            CustomLinkedList<Double> arr = new CustomLinkedList<>();
            System.out.println("Created new list with size of '" + arr.size() + "' ");
            arr.add(5.5);
            arr.add(7.5);
            arr.add(2.5);
            arr.add(2.5);
            arr.add(4.5);
            arr.add(-5.5);

            System.out.println("List has '" + arr.size() + "' values:");

            //print out using iterator
            Iterator iterator = arr.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }

            System.out.println("\nAdded at first and last places value 2.5:");
            arr.addFirst(2.5);
            arr.addLast(2.5);
            arr.forEach(a -> System.out.println(a));


            System.out.println("\nRemoved from list first and last values:");
            arr.removeFirst();
            arr.removeLast();
            arr.forEach(a -> System.out.println(a));


            System.out.println("\nRemove all elements with value 2.5:");
            arr.removeAllElementsWithValue(2.5);
            arr.forEach(a -> System.out.println(a));


            System.out.println("\nRemove second element:");
            arr.remove(2);//  not index. if u have array {2,3,4,5} and index value = 2,
                                //  array value 3 will be removed
            arr.forEach(a -> System.out.println(a));


            System.out.println("\nReverse list:");
            arr = arr.reverseElements();
            arr.forEach(a -> System.out.println(a));

        }
}
