package denistouch.splat.test1.educationNIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class MyFileCopyVisitor extends SimpleFileVisitor<Path> {
    private Path source, destination;

    public MyFileCopyVisitor(Path s, Path d) {
        source = s;
        destination = d;
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
        Path newDestination = destination.resolve(source.relativize(path));
        //здесь становится понятно как мы получаем точную копию структуры всех вложенных катологов
        /*System.out.println("-----------------------------------------------------");
        System.out.println("path\n\t - " + path);
        System.out.println("source\n\t - " + source);
        System.out.println("source.relativize(path)\n\t - " + source.relativize(path));
        System.out.println("destination\n\t - " + destination);
        System.out.println("destination.resolve(source.relativize(path)\n\t - " + destination.resolve(source.relativize(path)));*/
        try {
            Files.copy(path, newDestination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
        Path newDestination = destination.resolve(source.relativize(path));
        try {
            Files.copy(path, newDestination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }
}
/*
* осуществляем обход дерева файлов с копированием каталога со всеми вложенными каталогами и файлами*/
public class Test12 {
    public static void main(String[] args) {
        Path pathSource = Paths.get("C:\\Users\\denis\\IdeaProjects\\test1\\src\\denisTouch\\splat\\test1");
        Path pathDestination = Paths.get("C:\\Users\\denis\\IdeaProjects\\test1\\testCopy");
        try {
            Files.walkFileTree(pathSource, new MyFileCopyVisitor(pathSource,pathDestination));
            System.out.println("Files copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
