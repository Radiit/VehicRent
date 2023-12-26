package com.TubesRpl.vehicrent.backend.payloads.requests;

public class TransaksiRequest {
    
    private Integer ID_Transaksi;
    private Integer ID_Regent;
    private Integer ID_Client;
    private Integer ID_Kendaraan;
    private Integer Waktu_Pemesanan;
    private Double Hargatotal_Pemesanan;
    private String Status_Pemesanan;
    private String virtualAccountNumber;

    public Integer getID_Transaksi() {
        return ID_Transaksi;
    }

    public void setID_Transaksi(Integer ID_Transaksi) {
        this.ID_Transaksi = ID_Transaksi;
    }

    public Integer getID_Regent() {
        return ID_Regent;
    }

    public void setID_Regent(Integer ID_Regent) {
        this.ID_Regent = ID_Regent;
    }

    public Integer getID_Client() {
        return ID_Client;
    }

    public void setID_Client(Integer ID_Client) {
        this.ID_Client = ID_Client;
    }

    public Integer getID_Kendaraan() {
        return ID_Kendaraan;
    }

    public void setID_Kendaraan(Integer ID_Kendaraan) {
        this.ID_Kendaraan = ID_Kendaraan;
    }

    public Integer getWaktu_Pemesanan() {
        return Waktu_Pemesanan;
    }

    public void setWaktu_Pemesanan(Integer Waktu_Pemesanan) {
        this.Waktu_Pemesanan = Waktu_Pemesanan;
    }

    public Double getHargatotal_Pemesanan() {
        return Hargatotal_Pemesanan;
    }

    public void setHargatotal_Pemesanan(Double Hargatotal_Pemesanan) {
        this.Hargatotal_Pemesanan = Hargatotal_Pemesanan;
    }

    public String getStatus_Pemesanan() {
        return Status_Pemesanan;
    }

    public void setStatus_Pemesanan(String Status_Pemesanan) {
        this.Status_Pemesanan = Status_Pemesanan;
    }

    public String getVirtualAccountNumber() {
        return virtualAccountNumber;
    }

    public void setVirtualAccountNumber(String virtualAccountNumber) {
        this.virtualAccountNumber = virtualAccountNumber;
    }
}