package org.loose.fis.sre.controllers;

import org.loose.fis.sre.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Window;
import org.loose.fis.sre.util.ConnectionUtil;
import org.loose.fis.sre.model.User;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    Main main;
    Stage primaryStage;
    String role;
    @FXML
    private Button register;

    @FXML
    private Hyperlink hyperLinkLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPhone;

    @FXML
    private ComboBox rolebox;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtAddress;

    @FXML
    void RedirectLogin(ActionEvent event) {
        main.loginWindow();
    }
    private User user = new User();


    @FXML
    void RegisterUser(ActionEvent event) {
        register();

    }
    public void register(){
        ConnectionUtil connectNow = new ConnectionUtil();
        Connection connectDb = connectNow.conDB();

        String fullName = txtname.getText();
        String emailId = txtEmail.getText();
        String password = txtPassword.getText();
        String userName = txtUsername.getText();
        String phone = txtPhone.getText();
        String address = txtAddress.getText();

        String insertFields = "INSERT INTO users(name,role,username,password,email,phone,address) VALUES ('";
        String insertValues = fullName +"','"+ role +"','" + userName +"','" + password +"','" + emailId +"','" + phone +"','" + address+"')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDb.createStatement();
            statement.executeUpdate(insertToRegister);
            main.loginWindow();
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
    @FXML
    void SelectRole(ActionEvent event) {
        role = rolebox.getSelectionModel().getSelectedItem().toString();
    }
    public void setmain(Main main, Stage primaryStage) {
        this.main = main;
        this.primaryStage=primaryStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList("Hotel Manager",
                "Customer");
        rolebox.setItems(list);


    }
}

