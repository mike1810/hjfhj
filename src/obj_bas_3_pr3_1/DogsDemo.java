package obj_bas_3_pr3_1;

import static obj_bas_3_pr3_1.Dog.*;
import static java.lang.System.out;

public class DogsDemo {

    public static void main(String[] args) {
        Dog [] dogArrayByString = new Dog[]{};
        String userSet = "";
        inputDogFromString(userSet, dogArrayByString);

        Dog [] dogArray;
        dogArray = inputDogArray();
        out.println("\nArray before sorting");
        dogDetails(dogArray);

        out.println("\nArray after sorting by name(ascending)");
        insertionSortingOfDogArrayByNameAsc(dogArray);
        dogDetails(dogArray);
        out.println("\nArray after sorting by name(descending)");
        insertionSortingOfDogArrayByNameDesc(dogArray);
        dogDetails(dogArray);


        out.println("\nArray after sorting by size(ascending)");
        insertionSortingOfDogArrayBySizeAsc(dogArray);
        dogDetails(dogArray);
        out.println("\nArray after sorting by size(descending)");
        insertionSortingOfDogArrayBySizeDesc(dogArray);
        dogDetails(dogArray);


        out.println("\nArray after sorting by Age(ascending)");
        insertionSortingOfDogArrayByAgeAsc(dogArray);
        dogDetails(dogArray);
        out.println("\nArray after sorting by Age(descending)");
        insertionSortingOfDogArrayByAgeDesc(dogArray);
        dogDetails(dogArray);
    }
}