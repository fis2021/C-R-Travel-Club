package org.loose.fis.sre;

import org.loose.fis.sre.controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Stage primaryStage;
    Stage secondStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage=primaryStage;
        mainWindow();
    }
    public void mainWindow() {
        try {
            FXMLLoader loader= new FXMLLoader(Main.class.getResource("/resources/HomeView.fxml"));
            AnchorPane pane;
            pane = loader.load();
            HomeController controller = loader.getController();
            controller.setmain(this,primaryStage);
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loginWindow() {
        try {
            FXMLLoader loader= new FXMLLoader(Main.class.getResource("/resources/LoginView.fxml"));
            AnchorPane pane;
            pane = loader.load();
            LoginController controller = loader.getController();
            controller.setmain(this,primaryStage);
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerWindow() {
        try {
            FXMLLoader loader= new FXMLLoader(Main.class.getResource("/resources/RegisterView.fxml"));
            AnchorPane pane;
            pane = loader.load();
            RegisterController controller = loader.getController();
            controller.setmain(this,primaryStage);
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adminWindow() {
        try {
            FXMLLoader loader= new FXMLLoader(Main.class.getResource("/resources/AdminView.fxml"));
            AnchorPane pane;
            pane = loader.load();
            AdminController controller = loader.getController();
            controller.setmain(this,primaryStage);
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void userWindow() {
        try {
            FXMLLoader loader= new FXMLLoader(Main.class.getResource("/resources/UserView.fxml"));
            AnchorPane pane;
            pane = loader.load();
            UserController controller = loader.getController();
            controller.setmain(this,primaryStage);
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void newReserv() {
        try {
            FXMLLoader loader= new FXMLLoader(Main.class.getResource("/resources/NewResvView.fxml"));
            AnchorPane pane;
            pane = loader.load();
            NewReservController controller = loader.getController();
            controller.setmain(this,primaryStage);
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

