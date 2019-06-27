package Collections.CustomLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Demo {
        public static void main(String[] args) {
            CustomLinkedList<Double> arr = new CustomLinkedList<>();
            arr.addLast(5.5);
            arr.addLast(4.5);
            arr.addLast(2.5);
            arr.addLast(2.5);
            arr.addLast(4.5);
            arr.addLast(5.5);
            arr.addLast(4.5);
            System.out.println(arr.size());

            arr.remove(2);
            System.out.println(arr.size());


            Iterator iterator = arr.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
            System.out.println("___________________________________");

            arr.removeAllElementsWithThisValue(2.5);
            System.out.println(arr.size());

            System.out.println("__________________________+______");
            arr.forEach(a -> System.out.println(a));
            arr = arr.reverseElements(arr);
            System.out.println("__________________________+______");
            arr.forEach(a -> System.out.println(a));

        }
}
