package CONTROLLERS;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class QuanLyDocGia implements Initializable {
    @FXML
    private Button signup;

    @FXML
    private Button addReader;

    @FXML
    private Button readerList;

    @FXML
    private BorderPane mainView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }
}
