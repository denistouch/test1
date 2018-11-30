package denistouch.splat.test1.educationNIO;

import java.io.IOException;
import java.nio.file.*;

/*
 * Метод осуществляющий перемещение файла из одного пути в другой
 * Files.copy(pathSource,pathDestination,StandardCopyOption.REPLACE_EXISTING)
 * StandardCopyOption.REPLACE_EXISTING - определяет действие при уже имеющемся файле в каталоге
 * если перемещать папку она перемещается со всем содержимым??!!
 * бросит исключение при отсутствии файла исходника
 * */
public class Test9 {
    public static void main(String[] args) {
        Path pathSource = Paths.get("C:\\Users\\denis\\IdeaProjects\\test1\\test");
        Path pathDestination = Paths.get("C:\\Users\\denis\\IdeaProjects\\test1\\src\\denistouch\\splat\\test1\\new");
        try {
            Files.move(pathSource, pathDestination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Source file moved successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
