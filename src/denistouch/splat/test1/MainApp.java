package denistouch.splat.test1;

import denistouch.splat.test1.view.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class MainApp extends Application {

    public static void main(String[] args) {/*
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from side thread");
            }
        });
        thread.start();
        System.out.println("Main thread finished");
        System.exit(0);*/

        System.out.println("main()");
        launch(args);
    }

    private Stage primaryStage;
    private VBox rootLayout;


    @Override
    public void start(Stage primaryStage) {
        System.out.println("start()");
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Test");
        initRootLayout();
    }

    public void initRootLayout() {
        try {
            System.out.println("initRootLayout()");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (VBox) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            primaryStage.setMinHeight(500);
            primaryStage.setMinWidth(430);
            primaryStage.show();
            System.out.println("primaryStage.show()");
        } catch (IOException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
