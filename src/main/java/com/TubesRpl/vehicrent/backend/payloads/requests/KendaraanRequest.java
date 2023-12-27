package com.TubesRpl.vehicrent.backend.payloads.requests;

import java.util.List;

import io.micrometer.common.lang.Nullable;

public class KendaraanRequest {
    @Nullable
    private int idRegent;

    @Nullable
    private int idRental;

    @Nullable
    private List<ImageKendaraanRequest> imageKendaraan;

    @Nullable
    private String jenisKendaraan;

    @Nullable
    private String merkKendaraan;

    @Nullable
    private String model;

    @Nullable
    private String nomorPlat;

    @Nullable
    private String warna;

    @Nullable
    private int tahun;

    @Nullable
    private String nomorMesin;

    @Nullable
    private String transmisi;

    @Nullable
    private int hargaSewa;

    @Nullable
    private String kondisiKendaraan;

    @Nullable
    private String stnk;

    @Nullable
    private String mainImage;

    public KendaraanRequest(int idRegent, int idRental, List<ImageKendaraanRequest> imageKendaraan,
            String jenisKendaraan,
            String merkKendaraan, String model, String nomorPlat, String warna, int tahun, String nomorMesin,
            String transmisi, int hargaSewa, String kondisiKendaraan, String stnk, String mainImage) {
        this.idRegent = idRegent;
        this.idRental = idRental;
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
        this.mainImage = mainImage;
    }

    public KendaraanRequest() {
    }

    public int getIdRental() {
        return idRental;
    }

    public void setIdRental(int idRental) {
        this.idRental = idRental;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(@Nullable String mainImage) {
        this.mainImage = mainImage;
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