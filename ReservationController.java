package org.loose.fis.sre.controllers;

import org.loose.fis.sre.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.loose.fis.sre.util.ConnectionUtil;
import org.loose.fis.sre.model.Reservation;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservationController implements Initializable {
    String roomtype,hotelname;
    Main main;
    Stage primaryStage;
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private ObservableList<Reservation> resList = FXCollections.observableArrayList();
    @FXML
    private TableView<Reservation> reservations;

    @FXML
    private TableColumn<Reservation, String> CId;

    @FXML
    private TableColumn<Reservation, String> hName;

    @FXML
    private TableColumn<Reservation, String> CName;

    @FXML
    private TableColumn<Reservation, String> NRoom;

    @FXML
    private TableColumn<Reservation, String> RType;

    @FXML
    private TableColumn<Reservation, String> NPeople;

    @FXML
    private TableColumn<Reservation, String> TDays;

    @FXML
    private TableColumn<Reservation, LocalDate> CDate;

    @FXML
    private TextField id;

    @FXML
    private TextField Name;

    @FXML
    private TextField Rooms;

    @FXML
    private TextField peoples;

    @FXML
    private Button insert;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    @FXML
    private ComboBox<String> roomType;

    @FXML
    private TextField totaldays;

    @FXML
    private ComboBox<String> hotelName;

    @FXML
    private DatePicker date;


    @FXML
    void SelectHotel(ActionEvent event) {
        hotelname = hotelName.getSelectionModel().getSelectedItem().toString();

    }

    @FXML
    void SelectRooms(ActionEvent event) {
        roomtype = roomType.getSelectionModel().getSelectedItem().toString();

    }

    @FXML
    void handleMouseAction(MouseEvent event) {

        Reservation res = reservations.getSelectionModel().getSelectedItem();
        id.setText(""+res.getId());
        Name.setText(""+res.getName());
        Rooms.setText(""+res.getRooms());
        peoples.setText(""+res.getNoOfPeoples());
        totaldays.setText(""+res.getTotalDays());
        date.setValue(LocalDate.parse(""+res.getDate()));

    }
    public void setmain(AdminController adminController, Stage primaryStage) {
    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void Insert(ActionEvent event) {

    }

    @FXML
    void Update(ActionEvent event) {
    }

    ObservableList<String> list1 = FXCollections.observableArrayList();

    ObservableList<String> list2 = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {


            Connection con = ConnectionUtil.conDB();
            ResultSet rs = con.createStatement().executeQuery("select * from reservation");

            while (rs.next()){
                resList.add(new Reservation(rs.getString("idreservation"),
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
        CId.setCellValueFactory(new PropertyValueFactory<Reservation,String>("id"));
        hName.setCellValueFactory(new PropertyValueFactory<Reservation,String>("name"));
        NRoom.setCellValueFactory(new PropertyValueFactory<Reservation,String>("rooms"));
        RType.setCellValueFactory(new PropertyValueFactory<Reservation,String>("roomsType"));
        NPeople.setCellValueFactory(new PropertyValueFactory<Reservation,String>("noOfPeoples"));
        TDays.setCellValueFactory(new PropertyValueFactory<Reservation,String>("totalDays"));
        CDate.setCellValueFactory(new PropertyValueFactory<Reservation,LocalDate>("date"));
        reservations.setItems(resList);

        String sql = "select * from hotes";
        String sql2 = "select * from rooms";

        try {
            Connection con = ConnectionUtil.conDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() )
            {
                list2.add(rs.getString("name"));
            }

            hotelName.setItems(list2);





        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            Connection con = ConnectionUtil.conDB();
            PreparedStatement ps = con.prepareStatement(sql2);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() )
            {
                list1.add(rs.getString("roomtype"));
            }

            roomType.setItems(list1);


        } catch(Exception e) {
            e.printStackTrace();
        }



    }
}

