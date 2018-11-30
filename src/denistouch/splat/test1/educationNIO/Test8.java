package denistouch.splat.test1.educationNIO;

import java.io.IOException;
import java.nio.file.*;

/*
 * Метод осуществляющий копирование файла из одного пути в другой
 * Files.copy(pathSource,pathDestination,StandardCopyOption.REPLACE_EXISTING)
 * StandardCopyOption.REPLACE_EXISTING - определяет действие при уже имеющемся файле в каталоге
 * если копировать папку она скопируется без вложенного содержимого
 * бросит исключение при отсутствии файла исходника
 * */
public class Test8 {
    public static void main(String[] args) {
        Path pathSource = Paths.get("C:\\Users\\denis\\IdeaProjects\\new");
        Path pathDestination = Paths.get("C:\\Users\\denis\\IdeaProjects\\test1\\new");
        try {
            Files.copy(pathSource,pathDestination,StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Source file copied successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
