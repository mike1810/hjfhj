package LambdaExpressionsAndStreamApi;

import obj_bas_pr1.Author;
import obj_bas_pr1.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Practice2 {
    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<Book>() {{
            add(new Book("Open air", new Author("Antoha", "Kartoha"), 590.2));
            add(new Book("Pool", new Author("Boris", "Borisevsky"), 666));
            add(new Book("Give me hand", new Author("Fedya", "Nifedyan"), 189));
            add(new Book("Think like i am", new Author("Antoha", "Kartoha"), 1890));
            add(new Book("Gabriel the archangel", new Author("Pavlinius", "Determinius"), 459));
            add(new Book("Gabriel the demon", new Author("Pavlinius", "Afterminius"), 954));
            add(new Book("Marta and Peter", new Author("Pavlinius", "Determinius"), 300));
            add(new Book("Why a pie", new Author("Galya", "Potter"), 100));
        }};


        //Book with highest price
        Book withTheHighestPrice =
                bookList.stream().
                        max(Comparator.comparingDouble(book -> book.getPrice())).
                        get();
        System.out.println("Book with highest price:");
        System.out.println(withTheHighestPrice);


        //Books price sum
        double sum =
                bookList.stream().
                        flatMapToDouble(book -> DoubleStream.of(book.getPrice())).
                        sum();
        System.out.println("\nBooks price sum: " + sum);


        //list of books sorted by the author's full name;
        System.out.println("\nBooks sorted by authors full name: ");
        List<Book> bookListSorted = bookList.stream().
                sorted(Comparator.comparing(book ->
                        book.getAuthor().getFirstName() + book.getAuthor().getLastName())).
                collect(Collectors.toList());
        bookListSorted.forEach(System.out::println);


        //String containing books titles separated by the space character containing all books written by an author;
        Author hisBooksWeWantToFind = new Author("Pavlinius", "Determinius");
        System.out.println("\nBooks of " + hisBooksWeWantToFind + ":");
        bookList.stream().
                filter(book ->
                        book.getAuthor().getFirstName() == hisBooksWeWantToFind.getFirstName() &&
                                book.getAuthor().getLastName() == hisBooksWeWantToFind.getLastName()
                ).
                peek(book -> System.out.print("'" + book.getTitle() + "' ")).
                collect(Collectors.toList());
    }
}