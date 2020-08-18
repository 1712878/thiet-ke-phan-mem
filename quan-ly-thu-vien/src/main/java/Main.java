import DAO.AccountsDAO;
import DTO.Accounts;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import UTILS.HibernateUtils;

import java.util.List;

public class Main extends Application {

    static {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();

            System.out.println("Create successfully!!");
        }catch (Throwable ex){
            System.err.println("Intial SesstionFactory creation failed + " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TrangChuAdmin.fxml"));
        primaryStage.setTitle("Đăng nhập");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        List<Accounts> accounts = AccountsDAO.getAccounts();
        System.out.println(accounts.size());
        launch(args);
    }
}
