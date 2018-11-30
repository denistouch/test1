package denistouch.splat.test1.educationNIO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitorSearch extends SimpleFileVisitor<Path> {
    String partOfName;
    String partOfContent;

    /*
        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            boolean containsName = true;
            if(partOfName!=null && !path.getFileName().toString().contains(partOfName))
                containsName = false;

            String content = new String(Files.readAllBytes(path));
            boolean containsContent = true;
            if(partOfContent!=null && !content.contains(partOfContent))
                containsContent = false;

            if (containsName && containsContent)
                System.out.println(path);

            return FileVisitResult.CONTINUE;
        }*/
    //Выводит в коммандную строку объект класса Path, файла имеющего расширение ".fxml" или ".iml"
    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        if (path.toString().endsWith(".fxml") || path.toString().endsWith(".iml"))
            System.out.println(path);
        return FileVisitResult.CONTINUE;
    }
}
