package denistouch.splat.test1.educationNIO;

import java.nio.file.*;

/*
 * Проверяет существует ли файл методом Files.exists(path, LinkOption.NOFOLLOW_LINKS)
 * ВЫВОД: The file/directory educationNIO exists
 * Проверяет является ли файл каталогом методом Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)
 * ВЫВОД: educationNIO is a directory*/
public class Test5 {
    public static void main(String[] args) {

        //Path path = Paths.get("C:\\Users\\denis\\IdeaProjects\\test1\\src\\denistouch\\splat\\test1\\educationNIO\\Test5.java");

        Path path = Paths.get("C:\\Users\\denis\\IdeaProjects\\test1\\src\\denistouch\\splat\\test1\\educationNIO");

        //Path path = Paths.get("C:\\");

        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println("The file/directory " + path.getFileName() + " exists");
            if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                System.out.println(path.getFileName() + " is a directory");
            } else {
                System.out.println(path.getFileName() + " is a file");
            }
        } else {
            System.out.println("The file/directory " + path.getFileName() + " does not exists");
        }
    }
}
