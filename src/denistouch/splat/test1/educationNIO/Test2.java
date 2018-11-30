package denistouch.splat.test1.educationNIO;

import java.io.IOException;
import java.nio.file.*;


/*
 * Выводит в консоль построчно
 * testPath.getFileName(): Test - имя файла
 * testPath.toUri(): file:///C:/Users/denis/IdeaProjects/test1/./Test/ - получаем путь в виде ссылки URI
 * testPath.toAbsolutePath(): C:\Users\denis\IdeaProjects\test1\.\Test - получаем абсолютный путь
 * testPath.normalize(): Test - выполняет нормализацию пути, удаляя ненужные символы(вроде ".") из объекта
 * Path testPathNormalized = Paths.get(testPath.normalize().toString()); - создаём новый объект Path и получаем для него путь из testPath.normalize()
 * testPathNormalized.toAbsolutePath(): C:\Users\denis\IdeaProjects\test1\Test - получаем абсолютный путь для нормализованного вида
 * testPath.toRealPath(LinkOption.NOFOLLOW_LINKS): C:\Users\denis\IdeaProjects\test1\test - получаем действительный путь для объекта,
 * если файла не существует будет брошено исключение IOException
 * */
public class Test2 {
    public static void main(String[] args) throws IOException {
        Path testPath = Paths.get("./Test");

        System.out.println("The file name is: " + testPath.getFileName());
        System.out.println("It`s URI is: " + testPath.toUri());
        System.out.println("It`s absolute path is: " + testPath.toAbsolutePath());
        System.out.println("It`s normalized path is: " + testPath.normalize());

        Path testPathNormalized = Paths.get(testPath.normalize().toString());
        System.out.println("It`s normalized absolute path is: " + testPathNormalized.toAbsolutePath());
        System.out.println("It`s normalized real path is: " + testPath.toRealPath(LinkOption.NOFOLLOW_LINKS));
    }
}
