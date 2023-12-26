package com.TubesRpl.vehicrent.backend.payloads.requests;

import java.util.List;

import io.micrometer.common.lang.Nullable;

public class KendaraanRequest {
    
    private int idRegent;

    @Nullable
    private List<ImageKendaraanRequest> imageKendaraan;

    private String jenisKendaraan;
    private String merkKendaraan;
    private String model;
    private String nomorPlat;
    private String warna;
    private int tahun;
    private String nomorMesin;
    private String transmisi;
    private int hargaSewa;
    private String kondisiKendaraan;
    private String stnk;

    public KendaraanRequest(int idRegent, List<ImageKendaraanRequest> imageKendaraan, String jenisKendaraan, String merkKendaraan, String model, String nomorPlat, String warna, int tahun, String nomorMesin, String transmisi, int hargaSewa, String kondisiKendaraan, String stnk) {
        this.idRegent = idRegent;
        this.imageKendaraan = imageKendaraan;
        this.jenisKendaraan = jenisKendaraan;
        this.merkKendaraan = merkKendaraan;
        this.model = model;
        this.nomorPlat = nomorPlat;
        this.warna = warna;
        this.tahun = tahun;
        this.nomorMesin = nomorMesin;
        this.transmisi = transmisi;
        this.hargaSewa = hargaSewa;
        this.kondisiKendaraan = kondisiKendaraan;
        this.stnk = stnk;
    }

    public KendaraanRequest() {
    }

    // Setter and Getter methods
    public int getIdRegent() {
        return idRegent;
    }

    public void setIdRegent(int idRegent) {
        this.idRegent = idRegent;
    }

    @Nullable
    public List<ImageKendaraanRequest> getImageKendaraan() {
        return imageKendaraan;
    }

    public void setImageKendaraan(@Nullable List<ImageKendaraanRequest> imageKendaraan) {
        this.imageKendaraan = imageKendaraan;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getMerkKendaraan() {
        return merkKendaraan;
    }

    public void setMerkKendaraan(String merkKendaraan) {
        this.merkKendaraan = merkKendaraan;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNomorPlat() {
        return nomorPlat;
    }

    public void setNomorPlat(String nomorPlat) {
        this.nomorPlat = nomorPlat;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getNomorMesin() {
        return nomorMesin;
    }

    public void setNomorMesin(String nomorMesin) {
        this.nomorMesin = nomorMesin;
    }

    public String getTransmisi() {
        return transmisi;
    }

    public void setTransmisi(String transmisi) {
        this.transmisi = transmisi;
    }

    public int getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(int hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public String getKondisiKendaraan() {
        return kondisiKendaraan;
    }

    public void setKondisiKendaraan(String kondisiKendaraan) {
        this.kondisiKendaraan = kondisiKendaraan;
    }

    public String getStnk() {
        return stnk;
    }

    public void setStnk(String stnk) {
        this.stnk = stnk;
    }
}