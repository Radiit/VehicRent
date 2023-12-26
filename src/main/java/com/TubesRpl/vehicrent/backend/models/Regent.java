package com.TubesRpl.vehicrent.backend.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import jakarta.persistence.Table;

@Entity
@Table(name = "Regent")
public class Regent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegent;

    @ManyToOne
    @JoinColumn(name = "nik", referencedColumnName = "nik")
    private User user;

    // @Column
    // private String name;

    @Column(name = "listKendaraan")
    @JsonIgnore
    @OneToMany(mappedBy = "regent", cascade = CascadeType.ALL)
    private List<Kendaraan> listKendaraan;

    @Column
    private String valid;

    @Column
    private boolean hidden;

    // public Regent(Integer ID_Regent, User user, String name, List<Kendaraan>
    // listKendaraan, String valid, boolean hidden) {
    public Regent(Integer ID_Regent, User user, List<Kendaraan> listKendaraan, String valid, boolean hidden) {

        this.idRegent = ID_Regent;
        this.user = user;
        // this.name = name;
        this.listKendaraan = listKendaraan;
        this.valid = valid;
        this.hidden = hidden;
    }

    public Regent() {
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getValid() {
        return valid;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setIdRegent(Integer ID_Regent) {
        this.idRegent = ID_Regent;
    }

    public Integer getIdRegent() {
        return idRegent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Kendaraan> getListKendaraan() {
        return listKendaraan;
    }

    public void setListKendaraan(List<Kendaraan> listKendaraan) {
        this.listKendaraan = listKendaraan;
    }

}
