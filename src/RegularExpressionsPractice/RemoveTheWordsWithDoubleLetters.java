package RegularExpressionsPractice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveTheWordsWithDoubleLetters {
    public static void main(String[] args) {
        String text = "password wword word    11ord tort dD SS Heeeeeeello";

        Pattern doubleAndMoreLetters = Pattern.compile("\\w*(\\w)\\1+\\w*");
        Matcher matcher = doubleAndMoreLetters.matcher(text);

        text = matcher.replaceAll("").
                replaceAll("\\s+", " ").
                replaceFirst("\\s+","").
                replaceFirst("(\\s+\\Z)", "");
        System.out.println(text);
    }
}
