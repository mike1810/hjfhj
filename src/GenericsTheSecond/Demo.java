package GenericsTheSecond;
import InnerAbstractInterfacesPracticeTheFirst.Rectangle;

public class Demo {
    public static void main(String[] args){

        GenericEquals<Rectangle> RectanglePair
                = new GenericEquals<>();
        System.out.println(
                RectanglePair.equals(
                new Rectangle((int)(Math.random()),(int)(Math.random())),
                new Rectangle((int)(Math.random()),(int)(Math.random())))
        );

    }
}
