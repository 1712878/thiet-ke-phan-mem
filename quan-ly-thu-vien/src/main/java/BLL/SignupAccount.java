package BLL;

import DAO.ReadersDAO;
import DTO.Readers;
import UTILS.AlertDialog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SignupAccount implements Initializable {

    @FXML
    private ImageView image;

    @FXML
    public TextField fullname;

    @FXML
    public DatePicker dateOfBirth;

    @FXML
    public TextField gender;

    @FXML
    public TextField email;

    @FXML
    public TextField phoneNumber;

    @FXML
    public TextField address;

    @FXML
    public Button save;

    @FXML
    public Button cancel;

    @FXML
    public Button changeImage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        image.setImage(new Image("images/user.png"));

        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(fullname.getText().isEmpty() ||
                        email.getText().isEmpty() || phoneNumber.getText().isEmpty() || address.getText().isEmpty() || dateOfBirth.getValue().toString().isEmpty()){
                    AlertDialog.showAlertWithoutHeaderText("Error", "Vui lòng điển đầy đủ thông tin!", "failed");
                }else {
                    Readers readers = new Readers();
                    readers.setName(fullname.getText());
                    readers.setEmail(email.getText());
                    readers.setAddress(address.getText());
                    readers.setDob(LocalDate.parse(dateOfBirth.getValue().toString()));
                    readers.setPhone(phoneNumber.getText());
                    readers.setType(1);

                    boolean result = ReadersDAO.createReader(readers);
                    if(result){
                        AlertDialog.showAlertWithoutHeaderText("Alert", "Successfully!", "success");
                    } else {
                        AlertDialog.showAlertWithoutHeaderText("Alert", "Failed! Some thing went wrong", "failed");
                    }
                }
            }
        });
    }
}
