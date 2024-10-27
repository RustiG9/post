package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import util.PdfCreater;

import java.io.IOException;

public class PostApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

//    private DataLayoutController dlc = new DataLayoutController();

//    public Letter getLetter() {
//        return letter;
//    }

//    public Letter letter = new Letter(
//            dlc.getFromField().getText(),
//            dlc.getFromFieldAddress().getText(),
//            dlc.getToField().getText(),
//            dlc.getToFieldAddress().getText(),
//            dlc.getFromFieldIndex(),
//            dlc.getToFieldIndex());

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PostApp.class
                    .getResource("/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showData() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PostApp.class.getResource("/view/DataLayout.fxml"));
            ScrollPane dataLayout = (ScrollPane) loader.load();

            rootLayout.setCenter(dataLayout);

//            DataLayoutController dlc = loader.getController();
//            dlc.setPostApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
        PdfCreater p = new PdfCreater();

    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        initRootLayout();

        showData();

    }


}
