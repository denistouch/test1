package denistouch.splat.test1.educationNIO;

import java.io.IOException;
import java.nio.file.*;

/*
 * Проверяет тот же самый ли это файл сравнивая два пути и выводит на экран значение Boolean
 * ВЫВОД: Files.isSameFile(path1,path2) is: true
 * */
public class Test4 {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("Test");
        Path path2 = Paths.get("C:\\Users\\denis\\IdeaProjects\\test1\\Test");

        System.out.println("Files.isSameFile(path1,path2) is: " + Files.isSameFile(path1, path2));
    }
}
