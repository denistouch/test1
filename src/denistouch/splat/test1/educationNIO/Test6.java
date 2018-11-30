package denistouch.splat.test1.educationNIO;

import java.nio.file.*;

/*
 * Проверяется доступен ли файл для чтения, записи, выполнения
 * используемые методы Files.isReadable(path),Files.isWritable(path),Files.isExecutable(path)
 * ВЫВОД: Readable: true, Writable true, Executable true*/
public class Test6 {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\denis\\IdeaProjects\\test1\\src\\denistouch\\splat\\test1\\view\\RootLayout.fxml");
        System.out.printf("Readable: %b, Writable %b, Executable %b", Files.isReadable(path), Files.isWritable(path), Files.isExecutable(path));
    }
}
