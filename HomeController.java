package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.loose.fis.sre.Main;

public class HomeController {
    Main main;
    Stage primaryStage;
    @FXML
    private Button register;

    @FXML
    private Button login;

    @FXML
    private Button exit;

    @FXML
    void LoginPanel(ActionEvent event) {
        main.loginWindow();
    }

    @FXML
    void RegisterPanel(ActionEvent event) {
        main.registerWindow();
    }

    @FXML
    void exitProject(ActionEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    public void setmain(Main main, Stage primaryStage) {
        this.main = main;
        this.primaryStage = primaryStage;
    }
}
