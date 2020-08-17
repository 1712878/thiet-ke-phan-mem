package BLL;

import DAO.ReadersDAO;
import DTO.Readers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class ReaderList implements Initializable {
    @FXML
    private TableView<Readers> tableView;

    @FXML
    private TextField searchField;

    @FXML
    public ChoiceBox<SearchType> searchItem;

    @FXML
    public ChoiceBox<ClassifyType> classifyItem;

    public class SearchType {
        private String key;
        private String value;

        public SearchType(String key, String value){
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    public class ClassifyType {
        private String key;
        private String value;

        public ClassifyType(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    ObservableList<SearchType> items_2;
    ObservableList<ClassifyType> items_1;
    ObservableList<Readers> readersList = FXCollections.observableList(ReadersDAO.getReaders());

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // menu classify
        ClassifyType tat_ca1 = new ClassifyType("tat_ca", "Tất cả");
        ClassifyType cbvc = new ClassifyType("cbvc", "Cán bộ viên chức");
        ClassifyType sv = new ClassifyType("sv", "Sinh viên");
        ClassifyType dtk = new ClassifyType("dtk", "Đối tượng khác");

        items_1 = FXCollections.observableArrayList(tat_ca1, cbvc, sv, dtk);

        classifyItem.setItems(items_1);
        classifyItem.setValue(items_1.get(0));

        // menu search
        SearchType tat_ca2 = new SearchType("tat_ca", "Tất cả");
        SearchType mail = new SearchType("mail", "Theo email");
        SearchType ten = new SearchType("ten", "Theo tên");

        items_2 = FXCollections.observableArrayList(tat_ca2, mail, ten);

        searchItem.setItems(items_2);
        searchItem.setValue(items_2.get(0));

        // table
        TableColumn<Readers, Integer> id = new TableColumn<>("ID");
        TableColumn<Readers, String> name = new TableColumn<>("Họ và tên");
        TableColumn<Readers, LocalDate> dateOfBirth = new TableColumn<>("Ngày sinh");
        TableColumn<Readers, String> email = new TableColumn<>("Email");
        TableColumn<Readers, String> phone = new TableColumn<>("Số điện thoại");
        TableColumn<Readers, String> type = new TableColumn<>("Trạng thái");

        id.setCellValueFactory(new PropertyValueFactory<Readers, Integer>("personalId"));
        name.setCellValueFactory(new PropertyValueFactory<Readers, String>("name"));
        dateOfBirth.setCellValueFactory(new PropertyValueFactory<Readers, LocalDate>("dateOfBirth"));
        email.setCellValueFactory(new PropertyValueFactory<Readers, String>("email"));
        phone.setCellValueFactory(new PropertyValueFactory<Readers, String>("phone"));
        type.setCellValueFactory(new PropertyValueFactory<Readers, String>("type"));
        tableView.getColumns().addAll(id, name, dateOfBirth, email, phone, type);

        // phan loai
        FilteredList<Readers> filteredList1 = new FilteredList<>(readersList, el -> true);
        Text classifyField = new Text();
        classifyField.setOnKeyReleased(el -> {
            classifyField.textProperty().addListener(((observable, oldValue, newValue) -> {
                filteredList1.setPredicate((Predicate<? super Readers>) reader -> {
                    // search for id, name, place and date
                    final ClassifyType value = classifyItem.getValue();
                    if(value.getKey().compareTo("tat_ca") == 0) {
                        return true;
                    }else if(value.getKey().compareTo("cbvc") == 0){
                        if (reader.getType().toString().contains(String.valueOf(1))) {
                            return true;
                        }
                    }else if (value.getKey().compareTo("sv") == 0){
                        if (reader.getType().toString().contains(String.valueOf(2))) {
                            return true;
                        }
                    }else {
                        if (reader.getType().toString().contains(String.valueOf(3))) {
                            return true;
                        }
                    }
                    return false;
                });
            }));
        });

        // search
        FilteredList<Readers> filteredList2 = new FilteredList<>(readersList, el -> true);
        searchField.setOnKeyReleased(el -> {
            searchField.textProperty().addListener(((observable, oldValue, newValue) -> {
                filteredList2.setPredicate((Predicate<? super Readers>) reader -> {
                    if(newValue == null || newValue.isEmpty())
                        return true;
                    String lowerCaseFilter = newValue.toLowerCase();
                    // search for id, name, place and date
                    final SearchType value = searchItem.getValue();
                    if(value.getKey().compareTo("ten") == 0) {
                        if (reader.getName().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                        }
                    }else if(value.getKey().compareTo("mail") == 0){
                        if (reader.getEmail().toString().contains(lowerCaseFilter)) {
                            return true;
                        }
                    }else {
                        if (String.valueOf(reader.getDob()).contains(newValue)) {
                            return true;
                        } else if (reader.getName().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                        } else if (reader.getAddress().toString().contains(lowerCaseFilter)) {
                            return true;
                        } else if (reader.getEmail().toString().contains(lowerCaseFilter)) {
                            return true;
                        } else if (String.valueOf(reader.getPersonid()).contains(lowerCaseFilter)) {
                            return true;
                        } else if (reader.getPhone().contains(lowerCaseFilter))
                            return true;
                    }
                    return false;
                });
            }));

        });

        SortedList<Readers> sortedList = new SortedList<>(filteredList2);
        sortedList.comparatorProperty().bind(tableView.comparatorProperty());

        tableView.setItems(readersList);
    }
}
