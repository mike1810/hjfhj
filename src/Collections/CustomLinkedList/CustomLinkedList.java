package Collections.CustomLinkedList;

import java.util.Iterator;

public class CustomLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    CustomLinkedList() {
        this.head = new Node<>(null, null, tail);
        this.tail = new Node<>(head, null, null);
        size = 0;
    }

    public void add(T added) {
        addFirst(added);
    }

    public void assIfFirstCollectionElement(T added) {
        Node<T> add = new Node<>(head, added, tail);
        tail.prev = add;
        head.next = add;
        size++;
    }

    public void addLast(T added) {
        if (size == 0) {
            assIfFirstCollectionElement(added);
        } else {
            Node<T> previous = tail;
            previous.container = added;
            tail = new Node<>(previous, null, null);
            previous.next = tail;
            size++;
        }
    }

    public void addFirst(T added) {
        if (size == 0) {
            assIfFirstCollectionElement(added);
        } else {
            Node<T> next = head;
            next.container = added;
            head = new Node<>(null, null, next);
            next.prev = head;
            size++;
        }
    }

    public void remove(int index) {
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
    }

    public void remove(T container) {
        Node<T> curr = head;
        for (int i = 0; i < size; i++) {
            curr = curr.next;
            if (curr.container.equals(container)) {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                size--;
                break;
            }
        }
    }

    public void removeFirst() {
        remove(1);
    }

    public void removeLast() {
        remove(size);
    }

    public void removeAllElementsWithValue(T container) {
        Node<T> curr = head;
        for (int i = 0; i < size; i++) {
            remove(container);
        }
    }

    public CustomLinkedList<T> reverseElements() {
        CustomLinkedList<T> reversed = new CustomLinkedList<T>();
        CustomLinkedList<T> current = this;
        current.forEach(a -> reversed.addFirst(a));
        return reversed;
    }

    //
    public CustomLinkedList<T> reverseElements2() {
        return this;
    }

    //
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public T next() {
                return getIndexElement(counter++);
            }
        };
    }

    public T getIndexElement(int count) {
        Node<T> needToFind = getNext(head);
        for (int i = 0; i < count; i++) {
            needToFind = getNext(needToFind);
        }
        return needToFind.container;
    }

    private Node<T> getNext(Node<T> curr) {
        return curr.next;
    }
}
