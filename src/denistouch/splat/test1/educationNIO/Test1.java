package denistouch.splat.test1.educationNIO;

import java.nio.file.*;

/*выводит на экран построчно
Информацию о объекте заданными методами:
	 testPath: c:\work\projects\fileBrowser\testFile.txt - путь testPath
	 testPath.getFileName(): testFile.txt - имя файла
	 testPath.getRoot(): c:\ - корневую директорию для файла
	 testPath.getParent(): c:\work\projects\fileBrowser - имя родительской дирректории
Для объекта testPath выводит поэлементно структуру пути:
	 path element: work
	 path element: projects
	 path element: fileBrowser
	 path element: testFile.txt
*/
public class Test1 {
    public static void main(String[] args) {
        Path testPath = Paths.get("c:/work/projects/fileBrowser/testFile.txt");
        System.out.println("Printing file information: ");
        System.out.println("\t testPath: " + testPath);
        System.out.println("\t file name: " + testPath.getFileName());
        System.out.println("\t root of the path: " + testPath.getRoot());
        System.out.println("\t parent of the target: " + testPath.getParent());

        System.out.println("Printing elements of the path: ");
        for (Path element : testPath) {
            System.out.println("\t path element: " + element);
        }
    }
}
