package GenericsTheFirst;

import InnerAbstractInterfacesPracticeTheFirst.Rectangle;

public class GenericPair <T extends Number,V extends Rectangle> {

    T first;
    V second;

    GenericPair(T first, V second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}
