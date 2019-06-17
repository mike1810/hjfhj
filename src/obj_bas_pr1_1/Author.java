package obj_bas_pr1_1;

import static java.lang.System.out;

public class Author {

    private String firstName;
    private String lastName;


    Author(){
        firstName = "Nameless";
        lastName = "Author";
    }
    Author(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void printAuthor(){
        out.println(firstName + " " + lastName);
    }
    public String authorDetailsToBook(){
        return (firstName + " " + lastName);
    }
}
