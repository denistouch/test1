package denistouch.splat.test1.educationNIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

 class MyFileVisitor extends SimpleFileVisitor<Path> { //поведение при обходе дерева
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println("File name: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        System.out.println("Directory name: " + dir);
        return FileVisitResult.CONTINUE;
    }
}
/*
* Совершает обход по дереву файлов по заданному пути включая все вложенные каталоги, выводит в командную строку:
* имя файла если натыкается на файл
* имя папки если натыкается на папку*/
public class Test11 {
    public static void main(String[] args) {
        Path pathSource = Paths.get("C:\\Users\\denis\\IdeaProjects\\test1"); // путь по которому совершается обход дерева файлов
        try {
            Files.walkFileTree(pathSource, new MyFileVisitor());
            /*MyFileVisitorSearch myFileVisitorSearch = new MyFileVisitorSearch();
            myFileVisitorSearch.partOfName="java";
            myFileVisitorSearch.partOfContent="main";
            Files.walkFileTree(pathSource,myFileVisitorSearch);*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
