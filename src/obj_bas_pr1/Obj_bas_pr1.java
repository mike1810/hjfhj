package obj_bas_pr1;

import static java.lang.System.*;
public class Obj_bas_pr1 {

    public static void main(String[] args) {
        Author Author1 = new Author("Russel","Winderand");
        Book book = new Book("Developing Java Software", Author1, 79.75);
        book.BookDetails();
    }

    static class Author {
        private String firstName;
        private String lastName;

        {
            firstName = "Nameless";
            lastName = "Author";
        }

        Author(){
            ShowRegistredAuthor();
        }

        Author(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
            ShowRegistredAuthor();
        }

        public void ShowRegistredAuthor(){
            out.println("\nRegistered Author: " + firstName + " " + lastName);
        }

        public void PrintAuthor(){
            out.println("\nFirstName = " + firstName + "; LastName = " + lastName);
        }

        public String AuthorDetailsToBook(){
            return (firstName + " " + lastName);
        }
        public void GetClassname(){
            out.println(this.getClass());
        }
    }

    static class Book{

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
            out.println("\nBook title: " + title + "\nBook author: " + author.AuthorDetailsToBook() + "\nBook price = " + price);
        }
    }


}