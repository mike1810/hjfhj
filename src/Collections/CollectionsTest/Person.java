package Collections.CollectionsTest;

public class Person implements Comparable<Person>{
    private String name;
    Person(){
        this.name = "Mike";
    }
    Person(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public int compareTo(Person person) {
        int result = this.name.compareTo(person.name);
        return Integer.compare(result, 0);
    }

}
