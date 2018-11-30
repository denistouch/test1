package denistouch.splat.test1.educationNIO;

import java.nio.file.*;

/*
 * Сравниваем два пути разными методами
 * path1 = Test
 * path2 = C:\Users\denis\IdeaProjects\test1\Test
 *
 * compareTo() сравнивает пути посимвольно и возвращает: 0, если пути равны;
 * отрицательное целое значение, если путь в объекте вызывающем метод лексикографически меньше пути в объекте, переданном в качестве параметра;
 * положительное целое значение в противоположном случае.
 * ВЫВОД: (path1.compareTo(path2) == 0) is: false
 *
 * equals() сравнивает пути и возвращает Boolean
 * ВЫВОД: path1.equals(path2) is: false -
 * ВЫВОД: path1.toAbsolutePath() = C:\Users\denis\IdeaProjects\test1\Test
 * ВЫВОД: path2.equals(path1.toAbsolutePath()) is: true
 * */
public class Test3 {
    public static void main(String[] args) {
        Path path1 = Paths.get("Test");
        Path path2 = Paths.get("C:/Users/denis/IdeaProjects/test1/Test/");
        System.out.println("path1 = " + path1);
        System.out.println("path2 = " + path2);
        System.out.println("(path1.compareTo(path2) == 0) is: " + (path1.compareTo(path2) == 0));
        System.out.println("path1.equals(path2) is: " + path1.equals(path2));
        System.out.println("path2.equals(path1.toAbsolutePath()) is: " + path2.equals(path1.toAbsolutePath()));
        System.out.println("path1.toAbsolutePath() = " + path1.toAbsolutePath());
    }
}
