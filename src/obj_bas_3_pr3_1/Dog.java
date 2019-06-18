package obj_bas_3_pr3_1;

import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

class Dog {
    private String name;
    private Size size;
    private int age;

    Dog(){
        this.name = giveDogName();
        this.size = giveDogSize();
        this.age = giveDogAge();
    }
    Dog(String name, Size size, int age){
        this.name = name;
        this.size = size;
        this.age = age;
    }
    Dog(Size size, int age){
        this("", size,age);
        this.name = giveDogName();
    }
    Dog(String name, Size size){
        this(name, size,0);
        this.age = giveDogAge();
    }
    Dog(String name, int age){
        this(name, Size.BIG ,age);
        this.size = giveDogSize();
    }
    Dog(Size size){
        this("", size, 0);
        this.name = giveDogName();
        this.age = giveDogAge();
    }
    Dog(String name){
        this(name, Size.BIG,0);
        this.size = giveDogSize();
        this.age = giveDogAge();
    }
    Dog(int age){
        this("", Size.BIG ,age);
        this.name = giveDogName();
        this.size = giveDogSize();
    }
    private static String giveDogName(){
        DogName [] dogNameArray = DogName.values();
        int dogNameIndex =  (int)(Math.random()*dogNameArray.length);
        return dogNameArray[dogNameIndex].code;
    }
    private static Size giveDogSize(){
        Size[] dogSizeArray = Size.values();
        int dogSizeIndex =  (int)(Math.random()*dogSizeArray.length);
        return dogSizeArray[dogSizeIndex];
    }
    private static int giveDogAge(){
        return (int)(Math.random()*20);
    }
    public void dogDetails(){
        out.println("Name: " + name + "; Size: " + size + "; Age: " + age);
    }

    private enum Size{
        BIG("big", 3),SMALL("small",1),MEDIUM("medium",2);
        private String code;
        public int forSorting;
        Size(String code, int forSorting){
            this.code = code;
            this.forSorting = forSorting;
        }
    }
    private enum DogName{
        SHARIK("SHARIK"),
        TUZIK("TUZIK"),
        BARON("BARON"),
        BOBIK("BOBIK"),
        BRO("TOLIK");
        private String code;
        DogName(String code){
            this.code = code;
        }
    }
    private static Boolean checkDogSize(String size){
        boolean check = false;
        Size[] types = Size.values();
        for(Size enumSize: types){
            if(enumSize.code.equals(size)){
                check = true;
            }
        }
        return check;
    }
    private static Size returnEnumSize(String size){
        Size[] types = Size.values();
        for(Size enumSize: types){
            if(enumSize.code == size){
                return enumSize;
            }
        }
        return Size.BIG;
    }
    protected static void insertionSortingOfDogArrayByNameAsc( Dog [] dogArray){
        Dog temporary;
        for (int min = 0; min < dogArray.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < dogArray.length; j++) {
                if (dogArray[j].name.compareTo(dogArray[least].name) < 0) {
                    least = j;
                }
            }
            temporary = dogArray[min];
            dogArray[min] = dogArray[least];
            dogArray[least] = temporary;
        }
    }
    protected static void insertionSortingOfDogArrayByNameDesc( Dog [] dogArray){
        insertionSortingOfDogArrayByNameAsc(dogArray);
        Dog[] temporary = new Dog[dogArray.length];
        for(int i = 0; i < dogArray.length; i++)
        {
            temporary[i] = dogArray[(dogArray.length-1) -i];
        }
        for(int i = 0; i < dogArray.length; i++)
        {
            dogArray[i] = temporary[i];
        }
    }
    protected static void insertionSortingOfDogArrayBySizeAsc( Dog [] dogArray){
        Dog temporary;
        for (int min = 0; min < dogArray.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < dogArray.length; j++) {
                if (dogArray[j].size.forSorting < dogArray[least].size.forSorting) {
                    least = j;
                }
            }
            temporary = dogArray[min];
            dogArray[min] = dogArray[least];
            dogArray[least] = temporary;
        }
    }
    protected static void insertionSortingOfDogArrayBySizeDesc( Dog [] dogArray){
        insertionSortingOfDogArrayBySizeAsc(dogArray);
        Dog[] temporary = new Dog[dogArray.length];
        for(int i = 0; i < dogArray.length; i++)
        {
            temporary[i] = dogArray[(dogArray.length-1) -i];
        }
        for(int i = 0; i < dogArray.length; i++)
        {
            dogArray[i] = temporary[i];
        }
    }
    protected static void insertionSortingOfDogArrayByAgeAsc( Dog [] dogArray){
        Dog temporary;
        for (int min = 0; min < dogArray.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < dogArray.length; j++) {
                if (dogArray[j].age < dogArray[least].age) {
                    least = j;
                }
            }
            temporary = dogArray[min];
            dogArray[min] = dogArray[least];
            dogArray[least] = temporary;
        }
    }
    protected static void insertionSortingOfDogArrayByAgeDesc( Dog [] dogArray){
        insertionSortingOfDogArrayByAgeAsc(dogArray);
        Dog[] temporary = new Dog[dogArray.length];
        for(int i = 0; i < dogArray.length; i++)
        {
            temporary[i] = dogArray[(dogArray.length-1) -i];
        }
        for(int i = 0; i < dogArray.length; i++)
        {
            dogArray[i] = temporary[i];
        }
    }
    protected static void dogDetails(Dog [] dogArray){
        for(int i = 0; i < dogArray.length; i++){
            out.print("Dog " + (i+1) + " in array: ");
            dogArray[i].dogDetails();
        }
    }
    private static String inputDogName(){
        Scanner scan = new Scanner(in);
        String newDogName;
        out.println("Enter dogs name:");
        newDogName = scan.nextLine();
        if(newDogName.equals("") ){
            newDogName = giveDogName();
        }
        return newDogName;
    }
    private static Size inputDogSize(){
        Scanner scan = new Scanner(in);

        String EnteredDogSize;
        Size newDogSize;
        out.println("Enter dogs size (1 of 3 options: big, small, medium):");
        EnteredDogSize = scan.nextLine();
        if(EnteredDogSize.equals("") ){
            newDogSize = giveDogSize();
            return newDogSize;
        }
        else{
            //если введена не пустая строка
            boolean isSizeReal = false;
            do{
                // проверяем, существует ли такой код размера
                // для этого создаём переменную isSizeReal
                isSizeReal = checkDogSize(EnteredDogSize);
                // если такой код размера есть, то
                if(isSizeReal) {
                    newDogSize = returnEnumSize(EnteredDogSize);
                    return newDogSize;
                }
                // если такого кода размера нет, то мы генерируем своё значение, чтобы не мучить пользователя
                else{
                    //out.print("This size is not correct. We will generate size.");
                    newDogSize = giveDogSize();
                    return newDogSize;
                }
            }
            while(!isSizeReal);
        }
    }
    private static int inputDogAge(){

        Scanner scan = new Scanner(in);
        int newDogAge;
        out.println("Enter dogs age (not less than 0, not greater than 20)");
        String checkEmptyAgeValue = scan.nextLine();
        if(checkEmptyAgeValue.equals("")){
            //Age generated automatically, cause of empty value of newDogAge
            newDogAge = giveDogAge();
            return newDogAge;
        }
        newDogAge = Integer.parseInt(checkEmptyAgeValue);
        if(newDogAge < 0 || newDogAge > 20){
            //Age(which is out of [0;20]) generated automatically:");
            newDogAge = giveDogAge();
            return newDogAge;
        }
        return newDogAge;
    }
    protected static Dog [] inputDogArray() {
        Scanner scan = new Scanner(in);

        out.println("How many dogs are you wanted to add in array?");
        String checkDogArrayLength;

        int dogArrayLength;
        checkDogArrayLength = scan.nextLine();
        if(checkDogArrayLength.equals("") ){
            //    User don`t input incorrect number of dogs in array, it was generated automatically
            dogArrayLength = (int)(Math.random()*5) + 2;
        }
        else{
            dogArrayLength = Integer.parseInt(checkDogArrayLength);
            if(dogArrayLength <= 0 ){
                //    User inputted incorrect number of dogs in array, it was generated automatically
                dogArrayLength = (int)(Math.random()*10) + 1;
            }
        }
        Dog [] dog = new Dog[dogArrayLength];

        for(int i = 0; i < dogArrayLength; i++){
            out.println("Dog '" + (i+1) + "'");
            dog[i] = inputDog();
        }
        return dog;
    }
    protected static Dog inputDog() {
        String newDogName = inputDogName();//Даём имя собаке
        Size newDogSize = inputDogSize();//Указываем размер собаки
        int newDogAge = inputDogAge();//Указываем размер собаки}
        return new Dog(newDogName, newDogSize, newDogAge);//добавляем собаку с установленными значениями в массив
    }
    /*
    protected void inputDogFromString(String userSettings){
        String[] userSettingsSplit = userSettings.split(" ");
        boolean firstWordIsIntegerType = true;
        int firstWord = 0;
        try {
            firstWord = Integer.parseInt(userSettingsSplit[0]);
        }
        catch(NumberFormatException ex){
            firstWordIsIntegerType = false;
        }
        if(firstWord <= 0){
            firstWordIsIntegerType = false;
        }
        out.println((firstWordIsIntegerType)?"Dogs array can be created":"Dogs array can`t be created");
        for(int i = 1; i < userSettingsSplit.length; i++){
        }
        Dog [] dogToReturn = new Dog[firstWord];
        if(firstWordIsIntegerType){

            createDogArrayByStringUserSettings(dog);
        }
        return dog
    }
    protected void createDogArrayByStringUserSettings(Dog[] dog){

    }
    */
}