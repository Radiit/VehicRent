package com.TubesRpl.vehicrent.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Service, repo, controller masih temporary
//Karena tidak bisa tes client tanpa ada rekomendasi

@Entity
@Table(name = "Rekomendasi")  
public class Rekomendasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Rekomendasi;

    //setter getter
    public Integer getID_Rekomendasi() {
        return ID_Rekomendasi;
    }

    public void setID_Rekomendasi(Integer ID_Rekomendasi) {
        this.ID_Rekomendasi = ID_Rekomendasi;
    }

}