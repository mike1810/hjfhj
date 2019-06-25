package GenericsTheFirst;

public class GenericPairWithoutBounds<T,V> {
    T first;
    V second;

    GenericPairWithoutBounds(T first, V second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return first;
    }
    public V getSecond(){
        return second;
    }
}
