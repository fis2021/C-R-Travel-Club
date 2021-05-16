package org.loose.fis.sre.model;

import java.time.LocalDate;
import java.util.Date;

public class Reservation {
    private String id;
    private String name;
    private String rooms;
    private String roomsType;
    private String noOfPeoples;
    private String totalDays;
    private LocalDate date;
    private String fullName;

    public Reservation(int id, String name, String rooms, String roomsType, String noOfPeoples, String totalDays, LocalDate date, String fullName) {
        this.name = name;
        this.rooms = rooms;
        this.roomsType = roomsType;
        this.noOfPeoples = noOfPeoples;
        this.totalDays = totalDays;
        this.date = date;
        this.fullName = fullName;
    }

    public Reservation(String id, String hotel, String name, String rooms, String roomtype, String peoples, String days, LocalDate date) {
        this.id = id;
        this.name = hotel;
        this.fullName = name;
        this.rooms = rooms;
        this.roomsType = roomtype;
        this.noOfPeoples = peoples;
        this.totalDays = days;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getRoomsType() {
        return roomsType;
    }

    public void setRoomsType(String roomsType) {
        this.roomsType = roomsType;
    }

    public String getNoOfPeoples() {
        return noOfPeoples;
    }

    public void setNoOfPeoples(String noOfPeoples) {
        this.noOfPeoples = noOfPeoples;
    }

    public String getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(String totalDays) {
        this.totalDays = totalDays;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
