package com.TubesRpl.vehicrent.backend.payloads.requests;

import java.sql.Date;

public class TransaksiRequest {

    private int ID_Kendaraan;
    private int ID_Regent;
    private int ID_Client;
    private String orderName;
    private String phoneNumber;
    private String pickUpAddress;
    private String dropOffAddress;
    private String destination;
    private Date rentDateStart;
    private Date rentDateEnd;

    public TransaksiRequest(int ID_Kendaraan, int ID_Regent, int ID_Client, String orderName, String phoneNumber,
            String pickUpAddress, String dropOffAddString, String destination, Date rentDateStart, Date rentDateEnd) {
        this.ID_Kendaraan = ID_Kendaraan;
        this.ID_Regent = ID_Regent;
        this.ID_Client = ID_Client;
        this.orderName = orderName;
        this.phoneNumber = phoneNumber;
        this.pickUpAddress = pickUpAddress;
        this.dropOffAddress = dropOffAddString;
        this.destination = destination;
        this.rentDateStart = rentDateStart;
        this.rentDateEnd = rentDateEnd;
    }

    public TransaksiRequest() {
    }

    public int getID_Kendaraan() {
        return ID_Kendaraan;
    }

    public void setID_Kendaraan(int ID_Kendaraan) {
        this.ID_Kendaraan = ID_Kendaraan;
    }

    public int getID_Regent() {
        return ID_Regent;
    }

    public void setID_Regent(int ID_Regent) {
        this.ID_Regent = ID_Regent;
    }

    public int getID_Client() {
        return ID_Client;
    }

    public void setID_Client(int ID_Client) {
        this.ID_Client = ID_Client;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPickUpAddress() {
        return pickUpAddress;
    }

    public void setPickUpAddress(String pickUpAddress) {
        this.pickUpAddress = pickUpAddress;
    }

    public String getDropOffAddress() {
        return dropOffAddress;
    }

    public void setDropOffAddress(String dropOffAddString) {
        this.dropOffAddress = dropOffAddString;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getRentDateStart() {
        return rentDateStart;
    }

    public void setRentDateStart(Date rentDateStart) {
        this.rentDateStart = rentDateStart;
    }

    public Date getRentDateEnd() {
        return rentDateEnd;
    }

    public void setRentDateEnd(Date rentDateEnd) {
        this.rentDateEnd = rentDateEnd;
    }
}