package Collections.PersonList;

import java.util.*;
import static Collections.PersonList.Person.removeDuplicates;
import static Collections.PersonList.Person.compareLists;

public class PersonDemo {

    public static void main(String[] args){

        Person[] personArray = new Person[]{
                new Person("Oleg", 12),
                new Person("Oleg", 13),
                new Person("Tamara", 12),
                new Person("Oleg", 12),
                new Person("Omar", 12)
        };

        ArrayList<Person> personListToSortUsingComparable = new ArrayList<>();
        ArrayList<Person> personListToSortUsingComparator = new ArrayList<>();

        for (Person person : personArray){
            personListToSortUsingComparable.add(person);
            personListToSortUsingComparator.add(person);
        }

        //do it to compare lists like: {12,15,16} {12,16,15}
        personListToSortUsingComparable.remove(new Person("Oleg", 12));
        personListToSortUsingComparable.add(new Person("Oleg", 12));
        //

        System.out.println("First PersonList, we need to sort using comparable");
        personListToSortUsingComparable.forEach(a -> System.out.println(a));


        System.out.println("\nSecond PersonList, we need to sort using Comparator");
        personListToSortUsingComparator.forEach(a -> System.out.println(a));


        System.out.println("\nSorted first PersonList used Comparable");
        Collections.sort(personListToSortUsingComparable);
        personListToSortUsingComparable.forEach(a -> System.out.println(a));


        System.out.println("\nAre sorted first and unsorted second PersonLists equals? "
                + compareLists(personListToSortUsingComparable, personListToSortUsingComparator));


        Collections.sort(
                personListToSortUsingComparator,
                new Person.SortByName().thenComparing(new Person.SortByAge())
        );
        System.out.println("\nSorted second PersonList used Comparator");
        personListToSortUsingComparator.forEach(a -> System.out.println(a));


        System.out.println("\nAre sorted first and sorted second PersonLists equals? "
                + compareLists(personListToSortUsingComparable, personListToSortUsingComparator));


        System.out.println("\nFirst PersonList after removing duplicates");
        personListToSortUsingComparable = removeDuplicates(personListToSortUsingComparable);
        personListToSortUsingComparable.forEach(a -> System.out.println(a));


        System.out.println("\nAre first(w/o duplicates) and sorted second PersonLists equals? "
                + compareLists(personListToSortUsingComparable, personListToSortUsingComparator));
    }
}
