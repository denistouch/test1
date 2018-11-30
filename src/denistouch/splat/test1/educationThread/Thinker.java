package denistouch.splat.test1.educationThread;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
/*
* представляет собой класс наследующий класс Thread
* и я являющийся "тяжёлой" операцией*/
public class Thinker extends Thread {
    public static int i = 0;
    public static String buffer;

    @Override
    public void run() {
        /*FileChooser fileChooser = new FileChooser();
        fileChooser.showOpenDialog(new Stage());*/
        do {
            i++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                return;
            }
        } while (i < 40);
        System.out.print("\n");
    }
}
