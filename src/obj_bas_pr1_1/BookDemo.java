package obj_bas_pr1_1;


public class BookDemo {

    public static void main(String[] args) {
    Author Author1 = new Author("Russel","Winderand");
    Book book = new Book("Developing Java Software", Author1, 79.75);
    book.BookDetails();
    Book book2 = new Book("Developing Java Software 2-nd edition", 59.75);
    book2.BookDetails();
    }
}
