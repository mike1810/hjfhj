package obj_bas_pr1_1;

import static java.lang.System.out;

public class Author {

    private String firstName;
    private String lastName;
    {
        firstName = "Nameless";
        lastName = "Author";
    }
    Author(){
        PrintAuthor();
    }
    Author(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        PrintAuthor();
    }
    public void PrintAuthor(){
        out.println("\nFirstName = " + firstName + "; LastName = " + lastName);
    }
    public String AuthorDetailsToBook(){
        return (firstName + " " + lastName);
    }
}
