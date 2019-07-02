package Collections.CollectionsTest;

import java.util.*;

public class QueueTest {

    public static void main(String[] args){

        Queue<String> queue = new PriorityQueue<String>(){{
            add("Masha");
            add("Pasha");
            add("Dasha");
            add("Kasha");
        }};

        System.out.println("We added some names into queue and printed it using Iterator");
        Iterator queueIterator = queue.iterator();
        while(queueIterator.hasNext()){
            System.out.println(queueIterator.next());
        }

        System.out.println("\nWe removed 'Kasha' from HashSet:");
        queue.remove("Kasha");
        queue.forEach(a -> System.out.println(a));


        System.out.println("\nWe added names 'Macho-Man' and 'Zidane' into queue and sorted at once");
        queue.offer("Macho-Man");
        queue.offer("Zidane");
        queue.forEach(a -> System.out.println(a));

        while (!queue.isEmpty()){
            queue.remove();
        }
        if(queue.size() == 0){
            System.out.println( "\nWe removed all names from queue");
        }
        queue.forEach(a -> System.out.println(a));

    }


}
