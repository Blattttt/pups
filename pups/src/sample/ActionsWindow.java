package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class ActionsWindow {
    @FXML private Button exitButton;
    @FXML private TableView<BD> actionsListTable;
    @FXML private TableColumn<BD, String> Id;
    @FXML private TableColumn<BD, String> Number;
    @FXML private TableColumn<BD, String> Name;
    @FXML private TableColumn<BD, String> Date;
    @FXML private TableColumn<BD, String> Days;
    @FXML private TableColumn<BD, String> Actions;
    @FXML private TableColumn<BD, String> DayNumber;
    @FXML private TableColumn<BD, String> Starts;
    @FXML private TableColumn<BD, String> Moder;
    @FXML private TableColumn<BD, String> Jury1;
    @FXML private TableColumn<BD, String> Jury2;
    @FXML private TableColumn<BD, String> Jury3;
    @FXML private TableColumn<BD, String> Jury4;
    @FXML private TableColumn<BD, String> Jury5;
    @FXML private TableColumn<BD, String> Winner;
    private final ObservableList<BD> actionsListData = FXCollections.observableArrayList();
    @FXML private void initialize() {

        Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        Number.setCellValueFactory(new PropertyValueFactory<>("Number"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Days.setCellValueFactory(new PropertyValueFactory<>("Days"));
        Actions.setCellValueFactory(new PropertyValueFactory<>("Actions"));
        DayNumber.setCellValueFactory(new PropertyValueFactory<>("DayNumber"));
        Starts.setCellValueFactory(new PropertyValueFactory<>("Starts"));
        Moder.setCellValueFactory(new PropertyValueFactory<>("Moder"));
        Jury1.setCellValueFactory(new PropertyValueFactory<>("Jury1"));
        Jury2.setCellValueFactory(new PropertyValueFactory<>("Jury2"));
        Jury3.setCellValueFactory(new PropertyValueFactory<>("Jury3"));
        Jury4.setCellValueFactory(new PropertyValueFactory<>("Jury4"));
        Jury5.setCellValueFactory(new PropertyValueFactory<>("Jury5"));
        Winner.setCellValueFactory(new PropertyValueFactory<>("Winner"));

        FXMLLoader loader = new FXMLLoader();
        tablerefresh();


        exitButton.setOnAction(event -> {
            loader.setLocation(getClass().getResource("Authorization.fxml"));
            exitButton.getScene().getWindow().hide();
            Parent root = null;
            try {root = loader.load(); }
            catch (IOException e) { e.printStackTrace();}
            Stage stage = new Stage();
            assert root != null;
            stage.setScene(new Scene(root));
            stage.show();});
    }


    private void tablerefresh(){
        actionsListData.clear();
        try { Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/worldskilscourse4",
                    "root", "1234")) { Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM activity");
                while(resultSet.next()){ actionsListData.add(new BD(
                        resultSet.getInt("Id"),
                        resultSet.getString("Number"),
                        resultSet.getString("NameAction"),
                        resultSet.getString("Data"),
                        resultSet.getString("CountDay"),
                        resultSet.getString("Activity"),
                        resultSet.getString("Day"),
                        resultSet.getString("TimeStart"),
                        resultSet.getString("Moderator"),
                        resultSet.getString("Jury1"),
                        resultSet.getString("Jury2"),
                        resultSet.getString("Jury3"),
                        resultSet.getString("Jury4"),
                        resultSet.getString("Jury5"),
                        resultSet.getString("Winner")
                ));}}
            if (!actionsListData.isEmpty()){ actionsListTable.setItems(actionsListData); }}
        catch (Exception e){ System.out.println("Ошибка в БД"); }}
}
