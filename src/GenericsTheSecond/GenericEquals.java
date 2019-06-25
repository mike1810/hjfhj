package GenericsTheSecond;

public class GenericEquals <T> implements IComparable<T> {

    @Override
    public boolean equals(T qwe, T ewq) {
        return qwe.equals(ewq);
    }
}
