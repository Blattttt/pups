package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class Authorization {
    @FXML private TextField numberfield;
    @FXML private PasswordField passwordfield;
    @FXML private TextField codefield;
    @FXML private Label codepic;
    @FXML private Button enterbtn;
    @FXML private Button activityButton;
    @FXML private Label codelabel;
    @FXML private Label exLabel1;

    @FXML
    private void initialize() {
        FXMLLoader loader = new FXMLLoader();
        codefield.setEditable(true);
        codelabel.setVisible(true);
        String simCode = "qwertyuiopasdfghjkzxcvbnmQWERTYUOASDFGHJKLZXCVBNM1234567890";
        Random random = new Random();
        char sim;
        String code = "";
        int index;
        for (int i = 0; i < 4; i++){
            index = random.nextInt(simCode.length());
            sim = simCode.charAt(index);
            code += sim;}
        codepic.setText(code);


        activityButton.setOnAction(event -> {
            loader.setLocation(getClass().getResource("actionsWindow.fxml"));
            activityButton.getScene().getWindow().hide();
            Parent root = null;
            try { root = loader.load(); }
            catch (IOException e) { e.printStackTrace(); }
            Stage stage = new Stage();
            assert root != null;
            stage.setScene(new Scene(root));
            stage.show();
        });


        passwordfield.textProperty().addListener((observableValue, s, t1)-> {
                exLabel1.setVisible(false);});


        codefield.textProperty().addListener((observableValue, s, t1)-> exLabel1.setVisible(false));
        passwordfield.textProperty().addListener((observableValue, s, t1)-> exLabel1.setVisible(false));
        numberfield.textProperty().addListener((observableValue, s, t1)-> exLabel1.setVisible(false));

        enterbtn.setOnAction(event -> {
            exLabel1.setVisible(false);
            try {
                String number = numberfield.getText();
                String password = passwordfield.getText();
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/worldskilscourse4",
                        "root", "1234")) {
                    System.out.println("Подключение к бд");
                    Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM jury");
                    if (codefield.getText().equals(codepic.getText())) {
                    while (resultSet.next()) {
                        if (resultSet.getString("IdJury").equals(number) &&
                                resultSet.getString("Password").equals(password) &&
                                (codefield.getText().equals(codepic.getText()))){
                            System.out.println("Complete connect jury");
                            enterbtn.getScene().getWindow().hide();
                            loader.setLocation(getClass().getResource("jury.fxml"));
                            Parent root = null;
                            try { root = loader.load();
                            } catch (IOException e) { e.printStackTrace(); }
                            Stage stage = new Stage();
                            assert root != null;
                            stage.setScene(new Scene(root));
                            stage.show();
                            break;
                        } else { exLabel1.setVisible(true);} }

                    Statement statement2 = conn.createStatement();
                    ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM moders");
                    while (resultSet2.next()) {
                        if (resultSet2.getString("IdModer").equals(number) &&
                                resultSet2.getString("Password").equals(password)&&
                                (codefield.getText().equals(codepic.getText()))){
                            System.out.println("Complete connect moder");
                            enterbtn.getScene().getWindow().hide();
                            loader.setLocation(getClass().getResource("moders.fxml"));
                            Parent root = null;
                            try { root = loader.load();
                            } catch (IOException e) { e.printStackTrace(); }
                            Stage stage = new Stage();
                            assert root != null;
                            stage.setScene(new Scene(root));
                            stage.show();
                            break;
                        } else { exLabel1.setVisible(true);} }

                    Statement statement3 = conn.createStatement();
                    ResultSet resultSet3 = statement3.executeQuery("SELECT * FROM organizers");
                    while (resultSet3.next()) {
                        if (resultSet3.getString("IdOrganizers").equals(number) &&
                                resultSet3.getString("Password").equals(password) &&
                                (codefield.getText().equals(codepic.getText()))){
                            System.out.println("Complete connect organizer");
                            Get.setOrgName(resultSet3.getString("FullName"));
                            Get.setOrgSex(resultSet3.getString("Sex"));
                            enterbtn.getScene().getWindow().hide();
                            loader.setLocation(getClass().getResource("organizers.fxml"));
                            Parent root = null;
                            try { root = loader.load();
                            } catch (IOException e) { e.printStackTrace(); }
                            Stage stage = new Stage();
                            assert root != null;
                            stage.setScene(new Scene(root));
                            stage.show();
                            break;
                        } else { exLabel1.setVisible(true);} }

                    Statement statement4 = conn.createStatement();
                    ResultSet resultSet4 = statement4.executeQuery("SELECT * FROM players");
                    while (resultSet4.next()) {
                        if (resultSet4.getString("IdPlayer").equals(number) &&
                                resultSet4.getString("Password").equals(password) &&
                                (codefield.getText().equals(codepic.getText()))){
                            System.out.println("Complete connect player");
                            enterbtn.getScene().getWindow().hide();
                            loader.setLocation(getClass().getResource("players.fxml"));
                            Parent root = null;
                            try { root = loader.load();
                            } catch (IOException e) { e.printStackTrace(); }
                            Stage stage = new Stage();
                            assert root != null;
                            stage.setScene(new Scene(root));
                            stage.show();
                            break;
                        } else { exLabel1.setVisible(true);} }
                } else {
                        String simCode1 = "qwertyuiopasdfghjkzxcvbnmQWERTYUOASDFGHJKLZXCVBNM1234567890";
                        Random random1 = new Random();
                        char sim1;
                        String code1 = "";
                        int index1;
                        for (int i = 0; i < 4; i++){
                            index1 = random1.nextInt(simCode1.length());
                            sim1 = simCode1.charAt(index1);
                            code1 += sim1;}
                        codepic.setText(code1);
                        exLabel1.setVisible(true);}
                }
            } catch (Exception ex) { System.out.println("Ошибка доступа к БД");}});
    }
}