package obj_bas_3_pr3_1;
import static java.lang.System.out;

class Dog {
    protected String name;
    protected Size size;
    protected int age;
    Dog(){
        this.name = GiveDogName();
        this.size = GiveDogSize();
        this.age = GiveDogAge();
    }
    Dog(String name, Size size, int age){
        this.name = name;
        this.size = size;
        this.age = age;
}
    Dog(Size size, int age){
        this("", size,age);
        this.name = GiveDogName();
    }
    Dog(String name, Size size){
        this(name, size,0);
        this.age = GiveDogAge();
    }
    Dog(String name, int age){
        this(name, Size.BIG ,age);
        this.size = GiveDogSize();
    }
    Dog(Size size){
        this("", size, 0);
        this.name = GiveDogName();
        this.age = GiveDogAge();
    }
    Dog(String name){
        this(name, Size.BIG,0);
        this.size = GiveDogSize();
        this.age = GiveDogAge();
    }
    Dog(int age){
        this("", Size.BIG ,age);
        this.name = GiveDogName();
        this.size = GiveDogSize();
    }
    protected static String GiveDogName(){
        DogName [] dogNameArray = DogName.values();
        int dogNameIndex =  (int)(Math.random()*dogNameArray.length);
        return dogNameArray[dogNameIndex].code;
    }
    protected static Size GiveDogSize(){
        Size[] dogSizeArray = Size.values();
        int dogSizeIndex =  (int)(Math.random()*dogSizeArray.length);
        return dogSizeArray[dogSizeIndex];
    }
    protected static int GiveDogAge(){
        return (int)(Math.random()*20);
    }
    public void DogDetails(){
        out.println("Name: " + name + "; Size: " + size + "; Age: " + age);
    }
    enum Size{
        BIG("big", 3),SMALL("small",1),MEDIUM("medium",2);
        private String code;
        public int forSorting;
        Size(String code, int forSorting){
            this.code = code;
            this.forSorting = forSorting;
        }
    }
    enum DogName{
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
    static Boolean CheckDogSize(String size){
        boolean check = false;
        Size[] types = Size.values();
        for(Size enumSize: types){
            if(enumSize.code.equals(size)){
                check = true;
            }
        }
        return check;
    }
    static Size ReturnEnumSize(String size){
        Size[] types = Size.values();
        for(Size enumSize: types){
            if(enumSize.code == size){
                return enumSize;
            }
        }
        return Size.BIG;
    }
}
