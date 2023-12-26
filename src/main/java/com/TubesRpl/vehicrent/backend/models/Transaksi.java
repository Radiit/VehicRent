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
    private int idTransaksi;

    @ManyToOne
    // @JoinColumn(name = "ID_Regent")
    private User regent;

    @ManyToOne
    // @JoinColumn(name = "ID_Client")
    private User client;

    @ManyToOne
    @JoinColumn(name = "idKendaraan")
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

    @Column
    private String status;

    @Column
    private boolean hidden;

    public Transaksi() {
    }

    public Transaksi(int ID_Transaksi, User regent, User client, Kendaraan kendaraan, String orderName,
            String phoneNumber, String pickUpAddress, String dropOffAddString, String destination, Date rentDateStart,
            Date rentDateEnd, LocalDateTime dateTransaksi, int rentTotalDay, int hargaTotal, String status,
            boolean hidden) {
        this.idTransaksi = ID_Transaksi;
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
        this.status = status;
        this.hidden = hidden;
    }

    public String getStatus() {
        return status;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int ID_Transaksi) {
        this.idTransaksi = ID_Transaksi;
    }

    public User getRegent() {
        return regent;
    }

    public void setRegent(User regent) {
        this.regent = regent;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
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