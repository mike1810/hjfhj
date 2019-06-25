package GenericsTheSecond;

public class GenericEqualsOnlyForString {
    public <String> boolean equals(String qwe, String ewq) {
        return qwe.equals(ewq);
    }
}
