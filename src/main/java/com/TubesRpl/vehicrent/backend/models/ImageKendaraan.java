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
@Table(name = "ImageKendaraan")
public class ImageKendaraan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "ID_ImageKendaraan")
    private Integer ID_ImageKendaraan;

    @ManyToOne
    @JoinColumn(name = "ID_Kendaraan", referencedColumnName = "ID_Kendaraan")
    @JsonIgnore
    private Kendaraan kendaraan;

    @Column(name = "image")
    private String image;

    public ImageKendaraan(Integer ID_ImageKendaraan, Kendaraan kendaraan, String image) {
        this.ID_ImageKendaraan = ID_ImageKendaraan;
        this.kendaraan = kendaraan;
        this.image = image;
    }

    public ImageKendaraan() {
    }

    public Integer getID_ImageKendaraan() {
        return ID_ImageKendaraan;
    }

    public void setID_ImageKendaraan(Integer ID_ImageKendaraan) {
        this.ID_ImageKendaraan = ID_ImageKendaraan;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}