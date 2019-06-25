package Collections.CollectionsTest;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {

    public static void main(String[] args){

        Queue<String> queue = new PriorityQueue<>();
        queue.add("Masha");
        queue.add("Pasha");
        queue.add("Dasha");
        queue.add("Kasha");
        queue.add("qwe");
        queue.add("qew");
        queue.add("qwe");

        queue.forEach(a -> System.out.println(a));

        queue.remove("Kasha");

        System.out.println( "___________");

        queue.forEach(a -> System.out.println(a));
        System.out.println( "___________");
        while (!queue.isEmpty()){
            queue.remove();
        }

        queue.forEach(a -> System.out.println(a));

    }


}
