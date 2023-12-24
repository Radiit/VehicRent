package com.TubesRpl.vehicrent.backend.models;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transaksi")
public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Transaksi;

    @ManyToOne
    @JoinColumn(name = "ID_Regent")
    private Regent regent;

    @ManyToOne
    @JoinColumn(name = "ID_Client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "ID_Kendaraan")
    private Kendaraan kendaraan;

    @Column
    private String orderName;

    @Column
    private String phoneNumber;

    @Column
    private String pickUpAddress;

    @Column
    private String dropOffAddress;

    @Column
    private String destination;

    @Column
    private Date rentDateStart;

    @Column
    private Date rentDateEnd;

    @Column
    private LocalDateTime dateTransaksi;

    @Column
    private long lamaSewa;

    @Column
    private int hargaTotal;

    public Transaksi() {
    }

    public Transaksi(int ID_Transaksi, Regent regent, Client client, Kendaraan kendaraan, String orderName,
            String phoneNumber, String pickUpAddress, String dropOffAddString, String destination, Date rentDateStart,
            Date rentDateEnd, LocalDateTime dateTransaksi, int rentTotalDay, int hargaTotal) {
        this.ID_Transaksi = ID_Transaksi;
        this.regent = regent;
        this.client = client;
        this.kendaraan = kendaraan;
        this.orderName = orderName;
        this.phoneNumber = phoneNumber;
        this.pickUpAddress = pickUpAddress;
        this.dropOffAddress = dropOffAddString;
        this.destination = destination;
        this.rentDateStart = rentDateStart;
        this.rentDateEnd = rentDateEnd;
        this.dateTransaksi = dateTransaksi;
        this.lamaSewa = rentTotalDay;
        this.hargaTotal = hargaTotal;
    }

    public long getLamaSewa() {
        return lamaSewa;
    }

    public void setLamaSewa(long rentTotalDay) {
        this.lamaSewa = rentTotalDay;
    }

    public int getHargaTotal() {
        return hargaTotal;
    }

    public void setHargaTotal(int hargaTotal) {
        this.hargaTotal = hargaTotal;
    }

    public int getID_Transaksi() {
        return ID_Transaksi;
    }

    public void setID_Transaksi(int ID_Transaksi) {
        this.ID_Transaksi = ID_Transaksi;
    }

    public Regent getRegent() {
        return regent;
    }

    public void setRegent(Regent regent) {
        this.regent = regent;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
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

    public LocalDateTime getDateTransaksi() {
        return dateTransaksi;
    }

    public void setDateTransaksi(LocalDateTime dateTransaksi) {
        this.dateTransaksi = dateTransaksi;
    }
}