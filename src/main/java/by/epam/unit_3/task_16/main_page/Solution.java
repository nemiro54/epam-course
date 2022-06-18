package by.epam.unit_3.task_16.main_page;

/*
task16: Создать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три
различных операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова
по длине; отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае
равенства – по алфавиту.
 */

import by.epam.unit_3.task_16.exceptions.IncorrectInputFileException;
import by.epam.unit_3.task_16.reader.ReadStringFromFile;
import by.epam.unit_3.task_16.sorter.Sort;

import java.io.File;

public class Solution {
    public static void main(String[] args) throws IncorrectInputFileException {
        String text = ReadStringFromFile.read(new File("src/main/java/by/epam/unit_3/task_16/textForTask16"));
        System.out.println(text);
    }
}
