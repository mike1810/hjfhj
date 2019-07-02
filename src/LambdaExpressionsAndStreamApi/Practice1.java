package LambdaExpressionsAndStreamApi;

import Collections.PersonList.Person;

import java.util.*;
import java.util.stream.*;

public class Practice1 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>() {{
            add(new Person("Mitch", 10));
            add(new Person("Pavel", 30));
            add(new Person("Mitchell", 27));
            add(new Person("Daniil", 29));
            add(new Person("Boris", 21));
            add(new Person("Boris", 23));
            add(new Person("Boris", 23));
            add(new Person("Kesha", 21));
        }};

        personList = personList.stream().
                filter(person -> person.getAge() < 30 && person.getAge() > 20).
                peek(person -> person.setName(person.getName().toUpperCase())).
                distinct().
                sorted(Comparator.comparingInt(person -> person.getName().length())).
                collect(Collectors.toList());

        personList.forEach(System.out::println);
    }
}
