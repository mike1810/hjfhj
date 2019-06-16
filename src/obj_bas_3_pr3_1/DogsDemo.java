package obj_bas_3_pr3_1;

import obj_bas_3_pr3_1.Dog;
import static obj_bas_3_pr3_1.Dog.*;
import static java.lang.System.out;
import static java.lang.System.in;
import static obj_bas_3_pr3_1.Dog.GiveDogAge;

import java.util.Scanner;

public class DogsDemo {

    public static void main(String[] args) {
        Dog [] DogArray = new Dog[]{};
        DogArray = GenerateDogArray();
        out.println("\nArray before sorting");
        DogDetails(DogArray);

        ///*
        out.println("\nArray after sorting by name(ascending)");
        InsertionSortingOfDogArrayByNameAsc(DogArray);
        DogDetails(DogArray);
        out.println("\nArray after sorting by name(descending)");
        InsertionSortingOfDogArrayByNameDesc(DogArray);
        DogDetails(DogArray);
        //*/
        ///*
        out.println("\nArray after sorting by size(ascending)");
        InsertionSortingOfDogArrayBySizeAsc(DogArray);
        DogDetails(DogArray);
        out.println("\nArray after sorting by size(descending)");
        InsertionSortingOfDogArrayBySizeDesc(DogArray);
        DogDetails(DogArray);
        //*/
        ///*
        out.println("\nArray after sorting by Age");
        InsertionSortingOfDogArrayByAgeAsc(DogArray);
        DogDetails(DogArray);
        out.println("\nArray after sorting by Age");
        InsertionSortingOfDogArrayByAgeDesc(DogArray);
        DogDetails(DogArray);
        //*/

    }

    public static void DogDetails(Dog [] DogArray){
        for(int i = 0; i < DogArray.length; i++){
            out.print("Dog " + (i+1) + " in array: ");
            DogArray[i].DogDetails();
        }
    }

    private static String GenerateDogName(){
        Scanner scan = new Scanner(in);
        String nameIsKnown;
        do {
            out.println("Do you know dogs name? Answer 'yes' or 'no'");
            nameIsKnown = scan.next();}
        while(!nameIsKnown.equals("yes") && !nameIsKnown.equals("no"));

        String newDogName = "";
        if(nameIsKnown.equals("yes")){
            out.println("Enter dogs name:");
            newDogName = scan.next();
        }
        if(nameIsKnown.equals("no")){
            newDogName = GiveDogName();
            out.println("Dogs new name is " + newDogName);
        }
        return newDogName;
    }

    private static Size GenerateDogSize(){
        Scanner scan = new Scanner(in);
        String sizeIsKnown;
        do {
            out.println("Do you know dogs size? Answer 'yes' or 'no'");
            sizeIsKnown = scan.next();}
        while(!sizeIsKnown.equals("yes") && !sizeIsKnown.equals("no"));

        Size newDogSize = Size.BIG;
        if(sizeIsKnown.equals("yes")){
            boolean isSizeReal = false;
            String EnteredDogSize;
            do{
                out.println("Enter dogs size (1 of 3 options: big, small, medium):");
                EnteredDogSize = scan.next();
                isSizeReal = CheckDogSize(EnteredDogSize);
                if(isSizeReal) {
                    newDogSize = ReturnEnumSize(EnteredDogSize);
                }
                else{
                    out.println("This size is not correct");
                }
            }
            while(!isSizeReal);
        }
        if(sizeIsKnown.equals("no")){
            newDogSize = GiveDogSize();
            //out.println("Dogs new size: " + newDogSize);
        }
        return newDogSize;
    }
    private static int GenerateDogAge(){
        Scanner scan = new Scanner(in);
        String ageIsKnown;
        do {
            out.println("Do you know dogs age? Answer 'yes' or 'no'");
            ageIsKnown = scan.next();}
        while(!ageIsKnown.equals("yes") && !ageIsKnown.equals("no"));

        int newDogAge = 0;
        if(ageIsKnown.equals("yes")){
            do{
                out.println("Enter dogs age (Number must be not less than 0 and not greater than 20)");
                newDogAge = scan.nextInt();
            }
            while(newDogAge < 0 || newDogAge > 20);
        }
        if(ageIsKnown.equals("no")){
            newDogAge = GiveDogAge();
            //out.println("Dogs new age is " + newDogAge);
        }
        return newDogAge;
    }

    private static Dog [] GenerateDogArray()  throws NumberFormatException{
        Scanner scan = new Scanner(in);

        out.println("How many dogs are you wanted to add in array?");
        int DogArrayLength;
        do{
            out.println("Number must be greater than 0:");
            DogArrayLength = scan.nextInt();
        }
        while(DogArrayLength <= 0);
        Dog [] dog = new Dog[DogArrayLength];


        out.println("How many dogs are you wanted to add in array yourself:");
        int NumberOfDogsWillBeAddedByUser;
        do{
            out.println("Number must be not less than 0 and not greater than " + DogArrayLength);
            NumberOfDogsWillBeAddedByUser = scan.nextInt();
        }
        while(NumberOfDogsWillBeAddedByUser < 0 | NumberOfDogsWillBeAddedByUser > DogArrayLength);

        for(int i = 0; i < DogArrayLength; i++){
            if(i<NumberOfDogsWillBeAddedByUser){
                out.println("Dog '" + (i+1) + "'");
                String newDogName = GenerateDogName();//Даём имя собаке
                Size newDogSize = GenerateDogSize();//Указываем размер собаки
                int newDogAge = GenerateDogAge();//Указываем размер собаки}
                dog[i] = new Dog(newDogName, newDogSize, newDogAge);//добавляем собаку с установленными значениями в массив
            }
            else{
                out.println("Dog '" + (i+1) + "' is generated");
                dog[i] = new Dog();
            }
        }
        return dog;
    }
    public static void InsertionSortingOfDogArrayByNameAsc( Dog [] DogArray){
        Dog temporary = new Dog();
        for (int min = 0; min < DogArray.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < DogArray.length; j++) {
                if (DogArray[j].name.compareTo(DogArray[least].name) < 0) {
                    least = j;
                }
            }
            temporary = DogArray[min];
            DogArray[min] = DogArray[least];
            DogArray[least] = temporary;
        }
    }
    public static void InsertionSortingOfDogArrayBySizeDesc( Dog [] DogArray){
        Dog temporary = new Dog();
        for (int min = 0; min < DogArray.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < DogArray.length; j++) {
                if (DogArray[j].size.forSorting > DogArray[least].size.forSorting) {
                    least = j;
                }
            }
            temporary = DogArray[min];
            DogArray[min] = DogArray[least];
            DogArray[least] = temporary;
        }
    }
    public static void InsertionSortingOfDogArrayByAgeAsc( Dog [] DogArray){
        Dog temporary = new Dog();
        for (int min = 0; min < DogArray.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < DogArray.length; j++) {
                if (DogArray[j].age < DogArray[least].age) {
                    least = j;
                }
            }
            temporary = DogArray[min];
            DogArray[min] = DogArray[least];
            DogArray[least] = temporary;
        }
    }
    public static void InsertionSortingOfDogArrayByNameDesc( Dog [] DogArray){
        Dog temporary = new Dog();
        for (int min = 0; min < DogArray.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < DogArray.length; j++) {
                if (DogArray[j].name.compareTo(DogArray[least].name) > 0) {
                    least = j;
                }
            }
            temporary = DogArray[min];
            DogArray[min] = DogArray[least];
            DogArray[least] = temporary;
        }
    }
    public static void InsertionSortingOfDogArrayBySizeAsc( Dog [] DogArray){
        Dog temporary = new Dog();
        for (int min = 0; min < DogArray.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < DogArray.length; j++) {
                if (DogArray[j].size.forSorting < DogArray[least].size.forSorting) {
                    least = j;
                }
            }
            temporary = DogArray[min];
            DogArray[min] = DogArray[least];
            DogArray[least] = temporary;
        }
    }
    public static void InsertionSortingOfDogArrayByAgeDesc( Dog [] DogArray){
        Dog temporary = new Dog();
        for (int min = 0; min < DogArray.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < DogArray.length; j++) {
                if (DogArray[j].age > DogArray[least].age) {
                    least = j;
                }
            }
            temporary = DogArray[min];
            DogArray[min] = DogArray[least];
            DogArray[least] = temporary;
        }
    }
}
