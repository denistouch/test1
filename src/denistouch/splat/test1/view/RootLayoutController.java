package denistouch.splat.test1.view;

import denistouch.splat.test1.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.ExecutorService;

public class RootLayoutController {
    @FXML
    private Button openDir;
    @FXML
    private TextField searchField;
    @FXML
    private ChoiceBox extensionBox;
    @FXML
    private TreeView<PathItem> directoryTree;
    @FXML
    private TabPane tabPane;
    @FXML
    private Label nameSelection;
    @FXML
    private Label extensionSelection;
    @FXML
    private Button button;

    private MainApp mainApp;
    private volatile Path path = null;
    private TreeItem root;
    private TextField searchIn;
    private TextArea documentContent;
    //private Service service;
    ExecutorService service;

    public RootLayoutController() {
    }

    /*private Tab addTab (){

    }*/

    @FXML
    private void initialize() {
        extensionBox.getItems().addAll(".log", ".txt", ".java");
        extensionBox.getSelectionModel().select(0);
        extensionBox.show();

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
        directoryTree.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //service = Executors.newFixedThreadPool(3);
        directoryTree.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (directoryTree.getSelectionModel().getSelectedItem() != null) {
                    nameSelection.setText(directoryTree.getSelectionModel().getSelectedItem().getValue().toString());
                    if (event.getClickCount() >= 2) {
                        Tab tab = new Tab(directoryTree.getTreeItem(directoryTree.getSelectionModel().getSelectedIndex()).getValue().toString());
                        System.out.println(directoryTree.getTreeItem(directoryTree.getSelectionModel().getSelectedIndex()).getValue().getPath());
                        //Stream<String> streamText = null;
                        try {
                            BufferedReader reader = Files.newBufferedReader(directoryTree.getTreeItem(directoryTree.getSelectionModel().getSelectedIndex()).getValue().getPath());
                            String string = null;
                            String text = "";
                            while ((string = reader.readLine()) != null) {
                                //System.out.println(string);
                                text = text + string + "\n";
                            }
                            reader.close();
                            tab.setClosable(true);
                            searchIn = new TextField();
                            documentContent = new TextArea();
                            documentContent.setText(text);
                            SplitPane splitPane = new SplitPane();
                            splitPane.setOrientation(Orientation.VERTICAL);
                            splitPane.getItems().add(0, searchIn);
                            splitPane.getItems().add(1, documentContent);

                            tab.setContent(splitPane);
                            tabPane.getTabs().add(tab);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        }
                    }
                } else
                    System.out.println("FUCK!!!");


            }
        });
    }

    @FXML
    private void setOnOpenHandler() {
        //System.out.println("----------------------------------------------------------------------");
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Выберете директорию");
        File file = directoryChooser.showDialog(mainApp.getPrimaryStage());

        if (file != null) {
            path = file.toPath();
            //System.out.println("createNode(pathItem)");
            PathItem pathItem = new PathItem(path);
            root = createNode(pathItem);
            directoryTree.setRoot(root);
            directoryTree.getRoot().setExpanded(true);

            //System.out.println("directoryTree.setRoot(createNode(pathItem))");
        } else {
            path = null;
        }
        button.setDisable(false);
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    private TreeItem<PathItem> createNode(PathItem pathItem) {
        return PathTreeItem.createNode(pathItem);
    }

}

class PathItem {
    private Path path;

    public PathItem(Path path) {
        //System.out.println("public PathItem(Path path) + path: " + path);
        this.path = path;
    }

    public Path getPath() {
        //System.out.println("public Path getPath() + path: " + path);
        return path;
    }

    @Override
    public String toString() {
        //System.out.println("public String toString() + path: " + path);
        if (path.getFileName() == null) {
            return path.toString();
        } else {
            return path.getFileName().toString();
        }
    }
}

class PathTreeItem extends TreeItem<PathItem> {
    private boolean isLeaf = false;
    private boolean isFirstTimeChildren = true;
    private boolean isFirstTimeLeft = true;

    private PathTreeItem(PathItem pathItem) {
        super(pathItem);
        //System.out.println("private PathTreeItem(PathItem pathItem) + pathItem.getPath(): " + pathItem.getPath());
    }

    public static TreeItem<PathItem> createNode(PathItem pathItem) {
        //System.out.println("public static TreeItem<PathItem> createNode(PathItem pathItem) + pathItem.getPath(): " + pathItem.getPath());
        return new PathTreeItem(pathItem);
    }

    @Override
    public ObservableList<TreeItem<PathItem>> getChildren() {
        //System.out.println("public ObservableList<TreeItem<PathItem>> getChildren() ");
        if (isFirstTimeChildren) {
            isFirstTimeChildren = false;
            super.getChildren().setAll(buildChildren(this));
        }
        return super.getChildren();
    }

    @Override
    public boolean isLeaf() {
        if (isFirstTimeLeft) {
            isFirstTimeLeft = false;
            Path path = getValue().getPath();
            isLeaf = !Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS);
            //System.out.println("isLeaf + path: " + path);
        }
        return isLeaf;
    }

    private ObservableList<TreeItem<PathItem>> buildChildren(TreeItem<PathItem> treeItem) {
        //System.out.println("private ObservableList<TreeItem<PathItem>> buildChildren(TreeItem<PathItem> treeItem) ");
        Path path = treeItem.getValue().getPath();
        if (path != null && Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
            ObservableList<TreeItem<PathItem>> children = FXCollections.observableArrayList();
            try (DirectoryStream<Path> dirs = Files.newDirectoryStream(path)) {
                for (Path dir : dirs) {
                    PathItem pathItem = new PathItem(dir);
                    children.add(createNode(pathItem));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return children;
        }
        return FXCollections.emptyObservableList();
    }
}
