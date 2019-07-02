package obj_bas_pr1;

import java.util.*;

import static java.lang.System.out;

public class Book {

    private String title;
    private Author author;
    private double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(String title, Author author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    Book(String title, double price) {
        this(title, new Author(), price);
    }

    protected void bookDetails() {
        out.println("\nBook title:  " + title + "\nBook author: " +
                author.authorDetailsToBook() + "\nBook price : " + price + "$");
    }

    @Override
    public String toString() {
        return "\nBook title:  " + title + "\nBook author: " +
                author.authorDetailsToBook() + "\nBook price : " + price + "$";
    }


}
