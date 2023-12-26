package com.TubesRpl.vehicrent.backend.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Kendaraan")
public class Kendaraan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKendaraan;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ID_Regent")
    private Regent regent;

    @OneToMany(mappedBy = "kendaraan", cascade = CascadeType.ALL)
    private List<ImageKendaraan> imageKendaraan;

    @OneToMany(mappedBy = "kendaraan", cascade = CascadeType.ALL)
    private List<Rating> rating;

    @Column
    private String jenisKendaraan;

    @Column
    private String merkKendaraan;

    @Column
    private String model;

    @Column
    private String nomorPlat;

    @Column
    private String warna;

    @Column
    private int tahun;

    @Column
    private String nomorMesin;

    @Column
    private String transmisi;

    @Column
    private int hargaSewa;

    @Column
    private String kondisiKendaraan;

    @Column
    private String stnk;

    @Column
    private float totalRating;

    @Column
    private int totalOrdered;

    @Column
    private String valid;

    @Column
    private boolean hidden;

    public Kendaraan(int idKendaraan, Regent regent, List<ImageKendaraan> imageKendaraan, List<Rating> rating,
            String jenisKendaraan, String merkKendaraan, String model, String nomorPlat, String warna, int tahun,
            String nomorMesin, String transmisi, int hargaSewa, String kondisiKendaraan, String stnk, String valid,
            boolean hidden, float totalRating, int totalOrdered) {
        this.idKendaraan = idKendaraan;
        this.regent = regent;
        this.imageKendaraan = imageKendaraan;
        this.rating = rating;
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
        this.valid = valid;
        this.hidden = hidden;
        this.totalRating = totalRating;
        this.totalOrdered = totalOrdered;
    }

    public Kendaraan() {
    }

    public float getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(float totalRating) {
        this.totalRating = totalRating;
    }

    public int getTotalOrdered() {
        return totalOrdered;
    }

    public void setTotalOrdered(int totalOrdered) {
        this.totalOrdered = totalOrdered;
    }

    public int getIdKendaraan() {
        return idKendaraan;
    }

    public void setIdKendaraan(int idKendaraan) {
        this.idKendaraan = idKendaraan;
    }

    public Regent getRegent() {
        return regent;
    }

    public void setRegent(Regent regent) {
        this.regent = regent;
    }

    public List<ImageKendaraan> getImageKendaraan() {
        return imageKendaraan;
    }

    public void setImageKendaraan(List<ImageKendaraan> imageKendaraan) {
        this.imageKendaraan = imageKendaraan;
    }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
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

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}