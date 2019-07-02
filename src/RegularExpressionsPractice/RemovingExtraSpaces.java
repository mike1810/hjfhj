package RegularExpressionsPractice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemovingExtraSpaces {
    public static void main(String[] args) {
        String text = "    Там виднелась надпись  'Warning!!!'.    ";
        System.out.println(text);
        text.trim();

        Pattern oneSpaceBetweenTheWorlds = Pattern.compile("\\s{2,}");
        Matcher matcher = oneSpaceBetweenTheWorlds.matcher(text);
        text = matcher.
                replaceAll(" ").
                replaceFirst("\\s+","").
                replaceFirst("(\\s+\\Z)", "");
        System.out.println(text);
    }
}
