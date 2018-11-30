package denistouch.splat.test1.educationNIO;

import java.io.IOException;
import java.nio.file.*;

/*
 * Получаем из файла аттрибуты время создания, время последнего изменения, размер в байтах и является ли файл дирректорией
 * Files.getAttribute(path, "creationTime")
 * ВЫВОД: Creation time: 2018-11-08T13:43:04.580787Z
 * Files.getAttribute(path, "lastModifiedTime",LinkOption.NOFOLLOW_LINKS)
 * ВЫВОД: Last modified time: 2018-11-09T14:12:02.58056
 * Files.getAttribute(path,"size");
 * ВЫВОД: Size: 2802
 * Files.getAttribute(path,"isDirectory");
 * ВЫВОД: isDirectory: false
 * */
public class Test7 {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\denis\\IdeaProjects\\test1\\src\\denistouch\\splat\\test1\\view\\RootLayout.fxml");
        try {
            Object object = Files.getAttribute(path, "creationTime");
            System.out.println("Creation time: " + object);
            object = Files.getAttribute(path, "lastModifiedTime", LinkOption.NOFOLLOW_LINKS);
            System.out.println("Last modified time: " + object);
            object = Files.getAttribute(path, "size");
            System.out.println("Size: " + object);
            object = Files.getAttribute(path, "isDirectory");
            System.out.println("isDirectory: " + object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
