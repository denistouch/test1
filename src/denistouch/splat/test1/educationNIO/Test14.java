package denistouch.splat.test1.educationNIO;

import java.io.IOException;
import java.nio.file.*;
/*
* создаём объект класса WatchService и регистрируем его в каталоге по заданному пути,
* если файл не является каталогом кидает IOException
* при изменении файлов к каталоге сообщает нам о том, что произошло с файлом
* создан, удалён, изменён*/
public class Test14 {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\denis\\IdeaProjects\\test1\\src\\denistouch\\splat\\test1");
        System.out.println(path);
        WatchService watchService = null;
        try {
            watchService = path.getFileSystem().newWatchService();
            path.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
        } catch (IOException e) {
            e.printStackTrace();
        }

        do {
            WatchKey key = null;
            try {
                key = watchService.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (WatchEvent event : key.pollEvents()) {
                switch (event.kind().name()) {
                    case "OVERFLOW":
                        System.out.println("We lost some events");
                        break;
                    case "ENTRY_CREATE":
                        System.out.println("File " + event.context() + " is created!");
                        break;
                    case "ENTRY_MODIFY":
                        System.out.println("File " + event.context() + " is modified!");
                        break;
                    case "ENTRY_DELETE":
                        System.out.println("File " + event.context() + " is deleted!");
                        break;
                }
            }
            key.reset();
        } while (true);
        /*for (;;) {
            WatchKey key = null;
            try {
                key = watchService.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (WatchEvent event : key.pollEvents()) {
                switch (event.kind().name()) {
                    case "OVERFLOW":
                        System.out.println("We lost some events");
                        break;
                    case "ENTRY_CREATE":
                        System.out.println("File " + event.context() + " is created!");
                        break;
                    case "ENTRY_MODIFY":
                        System.out.println("File " + event.context() + " is modified!");
                        break;
                    case "ENTRY_DELETE":
                        System.out.println("File " + event.context() + " is deleted!");
                        break;
                }
            }
            key.reset();
        }*/
    }
}
