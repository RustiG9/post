package view;


import App.PostApp;
import javafx.fxml.FXML;

public class RootLayoutController {
    private PostApp postApp;

    public void setPostApp(PostApp postApp) {
        this.postApp = postApp;
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
