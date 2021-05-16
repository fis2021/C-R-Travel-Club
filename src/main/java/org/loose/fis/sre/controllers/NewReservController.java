package org.loose.fis.sre.controllers;


import org.loose.fis.sre.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.loose.fis.sre.util.ConnectionUtil;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class NewReservController implements Initializable {
    Main main;
    Stage primaryStage;
    String roomtype;
    String hotelname;
    @FXML
    private Button resvButton;

    @FXML
    private TextField noOfRooms;

    @FXML
    private TextField noOFPeoples;

    @FXML
    private TextField totalDays;

    @FXML
    private TextField userFullName;

    @FXML
    private ComboBox<String> selectHotel;

    @FXML
    private DatePicker Date;

    @FXML
    private ComboBox<String> roomType;

    @FXML
    private Button goBack;

    @FXML
    void Back(ActionEvent event) {
        main.userWindow();
    }

    @FXML
    void Hotel(ActionEvent event) {

        hotelname = selectHotel.getSelectionModel().getSelectedItem().toString();

    }

    @FXML
    void Reserve(ActionEvent event) {

        ConnectionUtil connectNow = new ConnectionUtil();
        Connection connectDb = connectNow.conDB();

        String noofpeople = noOFPeoples.getText();
        String noofrooms = noOfRooms.getText();
        String totaldays = totalDays.getText();
        String userfullname = userFullName.getText();
        LocalDate date = Date.getValue();

        String insertFields = "INSERT INTO reservation(hotels,name,rooms,roomtype,peoples,days,date) VALUES ('";
        String insertValues = hotelname +"','"+ userfullname +"','" + noofrooms +"','" + roomtype +"','" + noofpeople +"','" + totaldays +"','" + date+"')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDb.createStatement();
            statement.executeUpdate(insertToRegister);
            main.userWindow();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void SelectRoom(ActionEvent event) {

        roomtype = roomType.getSelectionModel().getSelectedItem().toString();

    }

    public void setmain(Main main, Stage primaryStage) {
        this.main = main;
        this.primaryStage = primaryStage;
    }
    ObservableList<String> list1 = FXCollections.observableArrayList();

    ObservableList<String> list2 = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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

            selectHotel.setItems(list2);





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

