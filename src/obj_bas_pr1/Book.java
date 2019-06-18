package obj_bas_pr1;

import static java.lang.System.out;

public class Book {

    private String title ;
    private Author author ;
    private double price ;
    
    Book(String title, Author author, double price ){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    Book(String title, double price ){
        this(title, new Author(), price);
    }
    protected void bookDetails(){
        out.println("\nBook title: " + title + "\nBook author: " +
                author.authorDetailsToBook() + "\nBook price : " + price + "$");
        //Если отталкиваться от того, что в задании нужно реализовать метод вывода данных об авторе на экран
        //и этот метод нигде не используется, то можно сделать так:
        // out.print("\nBook title: " + title + "\nBook author: ");author.printAuthor();
        //       out.println("Book price : " + price + "$");
    }
}
