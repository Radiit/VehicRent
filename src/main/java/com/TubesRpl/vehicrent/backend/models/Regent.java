package com.TubesRpl.vehicrent.backend.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Regent")
public class Regent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Regent;

    @ManyToOne
    @JoinColumn(name = "NIK_User", referencedColumnName = "NIK_User")
    private User user;

    @Column
    private String Norek_Regent;

    @Column(name = "listKendaraan")
    @OneToMany(mappedBy = "regent", cascade = CascadeType.ALL)
    private List<Kendaraan> listKendaraan;

    public Regent(Integer ID_Regent, User user, String norek_Regent, List<Kendaraan> listKendaraan) {
        this.ID_Regent = ID_Regent;
        this.user = user;
        Norek_Regent = norek_Regent;
        this.listKendaraan = listKendaraan;
    }

    public Regent() {
    }

    public void setID_Regent(Integer ID_Regent) {
        this.ID_Regent = ID_Regent;
    }

    public Integer getID_Regent() {
        return ID_Regent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNorek_Regent() {
        return Norek_Regent;
    }

    public void setNorek_Regent(String norek_Regent) {
        Norek_Regent = norek_Regent;
    }

    public List<Kendaraan> getListKendaraan() {
        return listKendaraan;
    }

    public void setListKendaraan(List<Kendaraan> listKendaraan) {
        this.listKendaraan = listKendaraan;
    }

}
