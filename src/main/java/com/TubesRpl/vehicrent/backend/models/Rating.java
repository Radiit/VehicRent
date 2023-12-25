package com.TubesRpl.vehicrent.backend.models;

import java.sql.Date;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRating;

    @Column
    private int rating;

    @Column
    private String komentar;

    @ManyToOne
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    private Client client;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idKendaraan", referencedColumnName = "idKendaraan")
    private Kendaraan kendaraan;

    @Column
    private LocalDateTime tanggalRating;

    @Column
    private boolean hidden;

    public Rating(int idRating, int rating, String komentar, Client client, Kendaraan kendaraan, LocalDateTime tanggalRating,
            boolean hidden) {
        this.idRating = idRating;
        this.rating = rating;
        this.komentar = komentar;
        this.client = client;
        this.kendaraan = kendaraan;
        this.tanggalRating = tanggalRating;
        this.hidden = hidden;
    }

    public Rating() {
    }

    public int getIdRating() {
        return idRating;
    }

    public void setIdRating(int idRating) {
        this.idRating = idRating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
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

    public LocalDateTime getTanggalRating() {
        return tanggalRating;
    }

    public void setTanggalRating(LocalDateTime tanggalRating) {
        this.tanggalRating = tanggalRating;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}