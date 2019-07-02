package obj_bas_pr1;

import static java.lang.System.out;

public class Author{
    private String firstName;
    private String lastName;

    public Author(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    Author(){
        this("Mr or ms","w/o last name");
    }

    protected void printAuthor(){
        out.println(firstName + " " + lastName);
    }

    protected String authorDetailsToBook(){
        return (firstName + " " + lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
