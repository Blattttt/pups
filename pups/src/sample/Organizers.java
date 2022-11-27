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

public class Organizers {
    @FXML private Button uchastnikiButton;
    @FXML private Button juriButton;
    @FXML private Button activityButton;
    @FXML private Button exitButton;
    @FXML private Label helloLadel;
    @FXML private Label msMrsLadel;

    @FXML
    private void initialize() {
        FXMLLoader loader = new FXMLLoader();
        showTime();
        showName();

        activityButton.setOnAction(event -> {
            loader.setLocation(getClass().getResource("actionsWindowOrg.fxml"));
            activityButton.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            assert root != null;
            stage.setScene(new Scene(root));
            stage.show();});

        juriButton.setOnAction(event -> {
            loader.setLocation(getClass().getResource("juri.fxml"));
            juriButton.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            assert root != null;
            stage.setScene(new Scene(root));
            stage.show();});

        uchastnikiButton.setOnAction(event -> {
            loader.setLocation(getClass().getResource("players.fxml"));
            uchastnikiButton.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            assert root != null;
            stage.setScene(new Scene(root));
            stage.show();});

        exitButton.setOnAction(event -> {
            loader.setLocation(getClass().getResource("Authorization.fxml"));
            exitButton.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            assert root != null;
            stage.setScene(new Scene(root));
            stage.show();});
    }

    private void showTime(){
        int time = Integer.parseInt(String.valueOf(java.time.LocalDateTime.now()).substring(11, 13));
        if (9<=time && time<=10) {
            helloLadel.setText("Доброе утро");}
        else if (11<=time && time<=17) {
            helloLadel.setText("Добрый день");}
        else if (18<=time && time<=23) {
            helloLadel.setText("Добрый вечер");}}

    private void showName(){
        String name = Get.getOrgName();
        String sex = Get.getOrgSex();
        if (sex.equals("мужской")){
            msMrsLadel.setText("Mr. " + name);
        } else if (sex.equals("женский")) {
            msMrsLadel.setText("Mrs. " + name);
        }}


}