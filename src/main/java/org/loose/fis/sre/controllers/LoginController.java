package org.loose.fis.sre.controllers;


import org.loose.fis.sre.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.loose.fis.sre.util.ConnectionUtil;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController implements Initializable {
    Main main;
    Stage primaryStage;
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button LoginButton;

    @FXML
    private ImageView loginBg;

    @FXML
    private Label errorLabel;
    @FXML
    private Hyperlink registerHyp;

    @FXML
    void GoToRegister(ActionEvent event) {
        main.registerWindow();
    }
    @FXML
    void Login(ActionEvent event) {
        String userName = username.getText().toString();
        String pass = password.getText().toString();

        //
        String sql = "SELECT * FROM users Where username = ? and password = ?";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,pass);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                errorLabel.setTextFill(Color.TOMATO);
                errorLabel.setText("Invalid Credentials!");
            }
            else {
                redirect(userName);
            }

        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void redirect(String userName){
        String sql = "SELECT * FROM users Where username = ? and role = ?";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,"Hotel");

            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                main.userWindow();
            }
            else {
                main.adminWindow();
            }

        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void setmain(Main main, Stage primaryStage) {
        this.main = main;
        this.primaryStage =primaryStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public LoginController(){
        con = ConnectionUtil.conDB();
    }
}
