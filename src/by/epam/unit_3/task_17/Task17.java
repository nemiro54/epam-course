package by.epam.unit_3.task_17;

/*
task17: Дана строка, содержащая xml-документ. Напишите анализатор, позволяющий последовательно возвращать содержимое
узлов xml-документа и его тип (открывающий тег, закрывающий тег, содержимое тега, тек без тела). Без использования
готовых парсеров XML.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task17 {
    public static void main(String[] args) throws IOException {
        String path = "xmlTask17";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();

        while (line != null) {
            analyzerXml(line);
            line = reader.readLine();
        }
    }

    private static void analyzerXml(String line) {
        String openingTag = "^<\\w+>$";
        String closingTag = "^</\\w+>$";
        String emptyTag = "^<\\w+/>$";
        String contentTag = "(<.+>)(.+)(</.+>)";
        String tagAttribute = "(<\\w+\\s+)(\\w+)([\\s=\"]+)(.+)(\">)";

        Pattern patternContent = Pattern.compile(contentTag);
        Matcher matcherContent = patternContent.matcher(line.trim());

        if (matcherContent.find()) {
            System.out.print(matcherContent.group(1) + " - открывающий тег, ");
            System.out.print(matcherContent.group(2) + " - содержимое тега, ");
            System.out.println(matcherContent.group(3) + " - закрывающий тег");
        }

        Pattern patternOpening = Pattern.compile(openingTag);
        Matcher matherOpening = patternOpening.matcher(line.trim());

        if (matherOpening.find()) {
            System.out.println(matherOpening.group() + " - открывающий тег");
        }

        Pattern patternClosing = Pattern.compile(closingTag);
        Matcher matcherClosing = patternClosing.matcher(line.trim());

        if (matcherClosing.find()) {
            System.out.println(matcherClosing.group() + " - закрывающий тег");
        }

        Pattern patternEmpty = Pattern.compile(emptyTag);
        Matcher matcherEmpty = patternEmpty.matcher(line.trim());

        if (matcherEmpty.find()) {
            System.out.println(matcherEmpty.group() + " - тег без тела");
        }

        Pattern patternAttribute = Pattern.compile(tagAttribute);
        Matcher matcherAttribute = patternAttribute.matcher(line.trim());

        if (matcherAttribute.find()) {
            System.out.print(matcherAttribute.group(0) + " - открывающий тег с атрибутом: ");
            System.out.print(matcherAttribute.group(2) + " - название атрибута, ");
            System.out.println(matcherAttribute.group(4) + " - значение атрибута");
        }
    }
}
