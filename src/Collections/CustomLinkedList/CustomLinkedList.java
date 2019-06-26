package Collections.CustomLinkedList;

import java.util.LinkedList;

public class CustomLinkedList <T>{
    private Node <T> head;
    private Node <T> tail;
    private int size;

    CustomLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }


    public int length(){
        return size;
    }

    public void add(T added) {
        if(size == 0){
            Node<T> addFirst = new Node<T>(null, added, null);
            head.container = added;
            size++;
        }
        if(size > 1){
            Node<T> addToList = new Node<T>(head, added , null);
            head.next = addToList;
            size++;
        }



    }


    public void remove(int index){

    }





}
