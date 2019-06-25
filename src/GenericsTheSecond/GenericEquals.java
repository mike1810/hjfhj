package GenericsTheSecond;

public class GenericEquals <T> implements Comparable<T> {

    @Override
    public boolean equals(T qwe, T ewq) {
        return qwe.equals(ewq);
    }

}
