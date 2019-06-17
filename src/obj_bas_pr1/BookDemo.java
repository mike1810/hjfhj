package obj_bas_pr1;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
public class BookDemo {

    public static void main(String[] args) {

        out.println("In practice we need create a Book titled “Developing Java Software” " +
                    "with authors Russel Winderand price 79.75");
        Author author1 = new Author("Russel","Winderand");
        Book book = new Book("Developing Java Software", author1, 79.75);
        book.bookDetails();
        out.println("\nWell done");

        out.println("You can do it yourselves!");
        Book book2 = createBook();
        out.print("\nDetails, you entered about book:");
        book2.bookDetails();
    }
    static Book createBook(){
        out.println("Let`s start to input information about book!");
        Author author = createAuthor();
        String title = createTitle();
        double price = createPrice();
        return new Book(title, author, price);
    }
    static Author createAuthor(){
        Scanner scan = new Scanner(in);
        String newAuthorFirstName,newAuthorLastName;

        out.println("Enter authors first name:");
        newAuthorFirstName = scan.nextLine();
        if(newAuthorFirstName.equals("") ){
            out.println("Author have no first name");
            newAuthorFirstName = "Mr or ms";
        }

        out.println("Enter authors last name:");
        newAuthorLastName = scan.nextLine();
        if(newAuthorLastName.equals("") ){
            out.println("Author have no last name");
            newAuthorLastName = "w/o last name";
        }
        return new Author(newAuthorFirstName, newAuthorLastName);
    }
    static String createTitle(){
        Scanner scan = new Scanner(in);
        String newBookTitle;

        out.println("Enter book`s title:");
        newBookTitle = scan.nextLine();
        if(newBookTitle.equals("") ){
            out.println("Book have no title");
            newBookTitle = "***";
        }
        return newBookTitle;
    }
    static double createPrice(){
        Scanner scan = new Scanner(in);
        double newBookPrice;

        out.println("Enter book`s price(like '1' or '24,58'):");
        String checkEmptyDoubleValue = scan.nextLine();
        if(checkEmptyDoubleValue.contains("")){
            out.println("Was set min price = 0.0$");
            newBookPrice = 0;
            return newBookPrice;
        }
        newBookPrice = Double.parseDouble(checkEmptyDoubleValue);

        if(newBookPrice < 0 ){
            out.println("Was set min price = 0.0$");
            newBookPrice = 0;
        }
        return newBookPrice;
    }
}
