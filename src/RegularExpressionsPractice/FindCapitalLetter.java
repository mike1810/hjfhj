package RegularExpressionsPractice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindCapitalLetter {
    public static void main(String[] args) {

        String text = "Там виднелась надпись 'Warning!!!'. " +
                "После, я зашёл в скрипучую дверь и увидел соседского щенка Toby," +
                " который ужасно хотел есть...";
        Pattern wordsWithCapitalLetter = Pattern.compile("([A-Z]|[А-Я]).*?\\b");
        Matcher matcher = wordsWithCapitalLetter.matcher(text);
        System.out.println(text);
        while (matcher.find()){
            System.out.print(text.substring(matcher.start(), matcher.end()) + " ");
        }
    }
}
