package obj_bas_pr1_1;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
public class BookDemo {

    public static void main(String[] args) {
        Book book = createBook();
        book.bookDetails();

    //Author author1 = new Author("Russel","Winderand");
    //Book book = new Book("Developing Java Software", author1, 79.75);
    //book.bookDetails();
    }
    static Book createBook(){
        out.println("Let`s start to create book!");
        Author author = createAuthor();
        String title = createTitle();
        double price = createPrice();
        return new Book(title, author, price);
    }
    static String createTitle(){
        Scanner scan = new Scanner(in);
        String titleIsKnown;
        do{
            out.println("Do you know book`s title?(yes or no)");
            titleIsKnown = scan.nextLine();
        }
        while(!titleIsKnown.equals("yes") && !titleIsKnown.equals("no"));

        String newBookTitle = "***";
        if(titleIsKnown.equals("yes")){
            out.println("Enter book`s title:");
            newBookTitle = scan.next();
        }
        return newBookTitle;
    }
    static double createPrice(){
        Scanner scan = new Scanner(in);
        String priceIsKnown;
        do{
            out.println("Do you know book`s price?(yes or no)");
            priceIsKnown = scan.next();
        }
        while(!priceIsKnown.equals("yes") && !priceIsKnown.equals("no"));

        double newBookPrice = 0;
        if(priceIsKnown.equals("yes")){
            out.println("Enter book`s price(like '1' or '24,58'):");
            newBookPrice = scan.nextDouble();
        }
        return newBookPrice;
    }
    static Author createAuthorWOQuestions(){
        Scanner scan = new Scanner(in);
        String nameIsKnown;
        do{
            out.println("Do you know authors name?(yes or no)");
            nameIsKnown = scan.next();
        }
        while(!nameIsKnown.equals("yes") && !nameIsKnown.equals("no"));

        String newAuthorFirstName,newAuthorLastName;
        Author newAuthor = new Author();
        if(nameIsKnown.equals("yes")){
            out.println("Enter authors firstname:");
            newAuthorFirstName = scan.next();
            out.println("Enter authors lastname:");
            newAuthorLastName = scan.next();
            newAuthor = new Author(newAuthorFirstName, newAuthorLastName);
        }
        return newAuthor;
    }
    static String createTitleWOQuestions(){
        Scanner scan = new Scanner(in);
        String titleIsKnown;
        do{
            out.println("Do you know book`s title?(yes or no)");
            titleIsKnown = scan.nextLine();
        }
        while(!titleIsKnown.equals("yes") && !titleIsKnown.equals("no"));

        String newBookTitle = "***";
        if(titleIsKnown.equals("yes")){
            out.println("Enter book`s title:");
            newBookTitle = scan.next();
        }
        return newBookTitle;
    }
    static double createPriceWOQuestions(){
        Scanner scan = new Scanner(in);
        String priceIsKnown;
        do{
            out.println("Do you know book`s price?(yes or no)");
            priceIsKnown = scan.next();
        }
        while(!priceIsKnown.equals("yes") && !priceIsKnown.equals("no"));

        double newBookPrice = 0;
        if(priceIsKnown.equals("yes")){
            out.println("Enter book`s price(like '1' or '24,58'):");
            newBookPrice = scan.nextDouble();
        }
        return newBookPrice;
    }
    static Author createAuthor(){
        Scanner scan = new Scanner(in);
        String nameIsKnown;
        do{
            out.println("Do you know authors name?(yes or no)");
            nameIsKnown = scan.next();
        }
        while(!nameIsKnown.equals("yes") && !nameIsKnown.equals("no"));

        String newAuthorFirstName,newAuthorLastName;
        Author newAuthor = new Author();
        if(nameIsKnown.equals("yes")){
            out.println("Enter authors firstname:");
            newAuthorFirstName = scan.next();
            out.println("Enter authors lastname:");
            newAuthorLastName = scan.next();
            newAuthor = new Author(newAuthorFirstName, newAuthorLastName);
        }
        return newAuthor;
    }
}
