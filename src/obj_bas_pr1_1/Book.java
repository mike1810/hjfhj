package obj_bas_pr1_1;
import obj_bas_pr1_1.Author;

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
        this.title = title;
        this.author = new Author();
        this.price = price;
    }
    public void BookDetails(){
        out.println("\nBook title: " + title + "\nBook author: " + author.AuthorDetailsToBook() + "\nBook price : " + price);
    }
}
