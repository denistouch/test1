package denistouch.splat.test1.educationNIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

class MyFileFindVisitor extends SimpleFileVisitor<Path> {
    private PathMatcher pathMatcher;

    public MyFileFindVisitor(String pattern) {
        try {
            pathMatcher = FileSystems.getDefault().getPathMatcher(pattern);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid pattern; did you forget to prefix \"glob:\" or \"regex:\"?");
            System.exit(1);
        }
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) {
        find(path);
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) {
        find(path);
        return FileVisitResult.CONTINUE;
    }

    private void find(Path path) {
        Path name = path.getFileName();
        if (pathMatcher.matches(name))
            System.out.println("Matching file: " + path.getFileName());
    }
}
/*
* осуществляем обход дерева файлов с поиском файлов с именем соответствующим паттерну регулярного выражения*/
public class Test13 {
    public static void main(String[] args) {
        Path startPath = Paths.get("C:\\Users\\denis\\IdeaProjects\\test1");

        //String pattern = "glob:*.java";
        String pattern = "regex:\\S+\\.java";

        try {
            Files.walkFileTree(startPath, new MyFileFindVisitor(pattern));
            System.out.println("File search completed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
