package BLL;

import DAO.ReadersDAO;
import DTO.Readers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class AddReaderFromFile implements Initializable {
    @FXML
    private Button chooseFile;

    @FXML
    private Button saveList;

    @FXML
    private TableView<Readers> table;

    Collection<Readers> list = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveList.setDisable(true);

        chooseFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                Stage stage = new Stage();
                stage.setTitle("File choose image");
                final File file = fileChooser.showOpenDialog(stage);
                if (file != null) {
                    // openFile(file);
                    Collection<Readers> list = null;
                    try {
                        list = Files.readAllLines(file.toPath())
                                .stream()
                                .map(line -> {
                                    String[] details = line.split(",");
                                    Readers reader = new Readers();
                                    reader.setName(details[0]);
                                    reader.setDob(LocalDate.parse(details[1]));
                                    reader.setEmail(details[2]);
                                    reader.setPhone(details[3]);
                                    reader.setType(Integer.valueOf(details[4]));
                                    return reader;
                                })
                                .collect(Collectors.toList());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    ObservableList<Readers> readerList = FXCollections.observableArrayList(list);
                    TableView<Readers> tableView = new TableView<>();
                    TableColumn<Readers, String> name = new TableColumn<>("Họ và tên");
                    TableColumn<Readers, LocalDate> dateOfBirth = new TableColumn<>("Ngày sinh");
                    TableColumn<Readers, String> email = new TableColumn<>("Email");
                    TableColumn<Readers, String> phone = new TableColumn<>("Số điện thoại");
                    TableColumn<Readers, String> type = new TableColumn<>("Trạng thái");

                    name.setCellValueFactory(new PropertyValueFactory<Readers, String>("name"));
                    dateOfBirth.setCellValueFactory(new PropertyValueFactory<Readers, LocalDate>("dateOfBirth"));
                    email.setCellValueFactory(new PropertyValueFactory<Readers, String>("email"));
                    phone.setCellValueFactory(new PropertyValueFactory<Readers, String>("phone"));
                    type.setCellValueFactory(new PropertyValueFactory<Readers, String>("type"));

                    tableView.getColumns().addAll(name, dateOfBirth, email, phone, type);

                    tableView.setItems(readerList);

                    saveList.setDisable(false);
                }
            }
        });

        saveList.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                list.forEach(readers -> ReadersDAO.createReader(readers));
            }
        });
    }
}
