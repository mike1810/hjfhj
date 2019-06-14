package obj_bas_pr3;

import static java.lang.System.out;
public class obj_bas_pr3 {


    public static void main(String[] args) {
        boolean check = false;
        check = CheckDogName("SHARIK", check);
        out.println(check);
        check = CheckDogName("TUZeK", check);
        out.println(check);

    }
    class Dog{
        String name;
        Size size;
        int age;

        Dog(){}
        Dog(String name, Size size, int age){
            this.name = name;
            this.size = size;
            this.age = age;

        }
        Dog(Size size, int age){
            int a = DogName.values().length;
            this(,size,age);
        }


    }
    enum Size{
        big("Big"),small("Small"),medium("Medium");
        private String code;
        Size(String code){
            this.code = code;
        }
    }
    enum DogName{
        SHARIK("SHARIK"),
        TUZIK("TUZIK"),
        BOBIK("BOBIK"),
        BRO("BRO");
        private String code;
        DogName(String code){
            this.code = code;
        }


    }
    static boolean CheckDogName(String Name, boolean check){
        check = false;
        DogName[] types = DogName.values();
        for(DogName name: types){

            if(name.code == Name){
                check = true;}
        }
        return check;
    }
}
