package denistouch.splat.test1.educationNIO;

import java.io.IOException;
import java.nio.file.*;

/*
 * Пробует удалить файл по заданному пути, если файл отсутствует или это не пустая папка кидает IOException*/
public class Test10 {
    public static void main(String[] args) {
        Path pathSource = Paths.get("C:\\Users\\denis\\IdeaProjects\\test1\\src\\denistouch\\splat\\test1\\new");
        try {
            Files.delete(pathSource);
            System.out.println("File deleted successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
