package Collections.CustomLinkedList;

public class Node <T> {
    Node <T> prev;
    Node <T> next;
    T container;

    Node(Node<T> prev, T container, Node<T> next){
        this.container = container;
        this.next = next;
        this.prev = prev;
    }
}
