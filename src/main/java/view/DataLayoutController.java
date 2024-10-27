package view;

import App.PostApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Letter;
import model.PdfLetter;

import java.io.IOException;

public class DataLayoutController {

    private PostApp postApp;
    PdfLetter pdfLetter;

    @FXML
    private TextField toFieldIndex;

    @FXML
    private TextField fromFieldAddress;

    @FXML
    private TextField toField;

    @FXML
    private TextField toFieldAddress;

    @FXML
    private TextField fromField;

    public void setPostApp(PostApp postApp) {
        this.postApp = postApp;
    }

    public int getToFieldIndex() {
        return Integer.parseInt(toFieldIndex.getText());
    }

    public TextField getFromFieldAddress() {
        return fromFieldAddress;
    }

    public TextField getToField() {
        return toField;
    }

    public TextField getToFieldAddress() {
        return toFieldAddress;
    }

    public TextField getFromField() {
        return fromField;
    }

    public int getFromFieldIndex() {
        return Integer.parseInt(fromFieldIndex.getText());
    }

    @FXML
    private TextField fromFieldIndex;



    @FXML
    void textFieldTyped(ActionEvent event) {
        pdfLetter = new PdfLetter(new Letter(fromField.getText(),toField.getText(),fromFieldAddress.getText(),toFieldAddress.getText(), Integer.parseInt(fromFieldIndex.getText()),Integer.parseInt(toFieldIndex.getText())));
        ////////////////////
        try {
            pdfLetter.creat();
        } catch (IOException e) {
            e.printStackTrace();
        }
//////////////////////////////


        /*System.out.println(new Letter(fromField.getText(),
                toField.getText(),
                fromFieldAddress.getText(),
                toFieldAddress.getText(),
                Integer.parseInt(fromFieldIndex.getText()),
                Integer.parseInt(toFieldIndex.getText())));*/
    }



}
