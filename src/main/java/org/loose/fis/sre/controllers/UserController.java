package org.loose.fis.sre.controllers;

import org.loose.fis.sre.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.loose.fis.sre.util.ConnectionUtil;
import org.loose.fis.sre.model.Reservation;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserController implements Initializable {
    Main main;
    Stage primaryStage;
    private ObservableList<Reservation> reservationsList = FXCollections.observableArrayList();

    @FXML
    private Button newResv;

    @FXML
    private TableView<Reservation> ResvTable;

    @FXML
    private TableColumn<Reservation, Integer> id;

    @FXML
    private TableColumn<Reservation, String> hotelName;

    @FXML
    private TableColumn<Reservation, String> NoOfRooms;

    @FXML
    private TableColumn<Reservation, String> RoomType;

    @FXML
    private TableColumn<Reservation, String> NoOfPeople;

    @FXML
    private TableColumn<Reservation, String> TotalDays;

    @FXML
    private TableColumn<Reservation, LocalDate> ResDate;
    @FXML
    private Button logout;

    @FXML
    void LogOut(ActionEvent event) {
        main.loginWindow();
    }
    @FXML
    void newReservation(ActionEvent event) {
        main.newReserv();

    }
    public void setmain(Main main, Stage primaryStage) {
        this.main = main;
        this.primaryStage = primaryStage;
        ResvTable.setItems(reservationsList);

    }
    public void addNewReservation(Reservation reservation) {
        reservationsList.add(reservation);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {


            Connection con = ConnectionUtil.conDB();
            ResultSet rs = con.createStatement().executeQuery("select * from reservation");

            while (rs.next()){
                reservationsList.add(new Reservation(rs.getString("idreservation"),
                        rs.getString("hotels"),
                        rs.getString("name"),
                        rs.getString("rooms"),
                        rs.getString("roomtype"),
                        rs.getString("peoples"),
                        rs.getString("days"),
                        LocalDate.parse(rs.getString("date"))));
            }
        }
        catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        id.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("id"));
        hotelName.setCellValueFactory(new PropertyValueFactory<Reservation,String>("name"));
        NoOfRooms.setCellValueFactory(new PropertyValueFactory<Reservation,String>("rooms"));
        RoomType.setCellValueFactory(new PropertyValueFactory<Reservation,String>("roomsType"));
        NoOfPeople.setCellValueFactory(new PropertyValueFactory<Reservation,String>("noOfPeoples"));
        TotalDays.setCellValueFactory(new PropertyValueFactory<Reservation,String>("totalDays"));
        ResDate.setCellValueFactory(new PropertyValueFactory<Reservation,LocalDate>("date"));
        ResvTable.setItems(reservationsList);
    }
}
