package com.TubesRpl.vehicrent.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Kendaraan")
public class Kendaraan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Kendaraan;

    @ManyToOne
    @JoinColumn(name = "ID_Regent")
    @JsonIgnore
    private Regent regent;

    @Column
    private String jenis_Kendaraan;

    @Column
    private String Nopol_Kendaraan;

    @Column
    private String Merk_Kendaraan;

    @Column
    private int Tahun_Kendaraan;

    @Column
    private String Warna_Kendaraan;

    @Column
    private String NoSTNK_Kendaraan;

    @Column
    private String Kapasitas_Kendaraan;

    @Column
    private String NoMesin_Kendaraan;

    @Column
    private int HargaSewa_Kendaraan;

    @Column
    private int MaksimalWaktu_Peminjaman;

    @Column
    private String Status_Kendaraan;

    @Column
    private String Status_ValidasiKendaraan;

    public Kendaraan(int iD_Kendaraan, Regent regent, String jenis_Kendaraan, String nopol_Kendaraan,
            String merk_Kendaraan, int tahun_Kendaraan, String warna_Kendaraan, String noSTNK_Kendaraan,
            String kapasitas_Kendaraan, String noMesin_Kendaraan, int hargaSewa_Kendaraan, int maksimalWaktu_Peminjaman,
            String status_Kendaraan, String status_ValidasiKendaraan) {
        ID_Kendaraan = iD_Kendaraan;
        this.regent = regent;
        this.jenis_Kendaraan = jenis_Kendaraan;
        Nopol_Kendaraan = nopol_Kendaraan;
        Merk_Kendaraan = merk_Kendaraan;
        Tahun_Kendaraan = tahun_Kendaraan;
        Warna_Kendaraan = warna_Kendaraan;
        NoSTNK_Kendaraan = noSTNK_Kendaraan;
        Kapasitas_Kendaraan = kapasitas_Kendaraan;
        NoMesin_Kendaraan = noMesin_Kendaraan;
        HargaSewa_Kendaraan = hargaSewa_Kendaraan;
        MaksimalWaktu_Peminjaman = maksimalWaktu_Peminjaman;
        Status_Kendaraan = status_Kendaraan;
        Status_ValidasiKendaraan = status_ValidasiKendaraan;
    }

    public int getID_Kendaraan() {
        return ID_Kendaraan;
    }

    public void setID_Kendaraan(int iD_Kendaraan) {
        ID_Kendaraan = iD_Kendaraan;
    }

    public Regent getRegent() {
        return regent;
    }

    public void setRegent(Regent regent) {
        this.regent = regent;
    }

    public String getJenis_Kendaraan() {
        return jenis_Kendaraan;
    }

    public void setJenis_Kendaraan(String jenis_Kendaraan) {
        this.jenis_Kendaraan = jenis_Kendaraan;
    }

    public String getNopol_Kendaraan() {
        return Nopol_Kendaraan;
    }

    public void setNopol_Kendaraan(String nopol_Kendaraan) {
        Nopol_Kendaraan = nopol_Kendaraan;
    }

    public String getMerk_Kendaraan() {
        return Merk_Kendaraan;
    }

    public void setMerk_Kendaraan(String merk_Kendaraan) {
        Merk_Kendaraan = merk_Kendaraan;
    }

    public int getTahun_Kendaraan() {
        return Tahun_Kendaraan;
    }

    public void setTahun_Kendaraan(int tahun_Kendaraan) {
        Tahun_Kendaraan = tahun_Kendaraan;
    }

    public String getWarna_Kendaraan() {
        return Warna_Kendaraan;
    }

    public void setWarna_Kendaraan(String warna_Kendaraan) {
        Warna_Kendaraan = warna_Kendaraan;
    }

    public String getNoSTNK_Kendaraan() {
        return NoSTNK_Kendaraan;
    }

    public void setNoSTNK_Kendaraan(String noSTNK_Kendaraan) {
        NoSTNK_Kendaraan = noSTNK_Kendaraan;
    }

    public String getKapasitas_Kendaraan() {
        return Kapasitas_Kendaraan;
    }

    public void setKapasitas_Kendaraan(String kapasitas_Kendaraan) {
        Kapasitas_Kendaraan = kapasitas_Kendaraan;
    }

    public String getNoMesin_Kendaraan() {
        return NoMesin_Kendaraan;
    }

    public void setNoMesin_Kendaraan(String noMesin_Kendaraan) {
        NoMesin_Kendaraan = noMesin_Kendaraan;
    }

    public int getHargaSewa_Kendaraan() {
        return HargaSewa_Kendaraan;
    }

    public void setHargaSewa_Kendaraan(int hargaSewa_Kendaraan) {
        HargaSewa_Kendaraan = hargaSewa_Kendaraan;
    }

    public int getMaksimalWaktu_Peminjaman() {
        return MaksimalWaktu_Peminjaman;
    }

    public void setMaksimalWaktu_Peminjaman(int maksimalWaktu_Peminjaman) {
        MaksimalWaktu_Peminjaman = maksimalWaktu_Peminjaman;
    }

    public String getStatus_Kendaraan() {
        return Status_Kendaraan;
    }

    public void setStatus_Kendaraan(String status_Kendaraan) {
        Status_Kendaraan = status_Kendaraan;
    }

    public String getStatus_ValidasiKendaraan() {
        return Status_ValidasiKendaraan;
    }

    public void setStatus_ValidasiKendaraan(String status_ValidasiKendaraan) {
        Status_ValidasiKendaraan = status_ValidasiKendaraan;
    }

    public Kendaraan() {
    }
    

    

    
}
