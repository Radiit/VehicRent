package com.TubesRpl.vehicrent.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(length = 16)
    private Integer nik;

    @Column
    private String role_user;

    @Column
    private String nama_depan;

    @Column
    private String nama_belakang;

    @Column
    private String noTelepon;

    @Column
    private String kontakDarurat;

    @Column
    private Integer umur;

    @Column
    private String email;

    @Column
    @JsonIgnore
    private String password;

    @Column
    private String alamat;

    @Column
    private String ktp;

    @Column
    private String fotoDiri;

    @Column
    private Boolean hidden;

    public User(Integer nik, String role_user, String nama_depan, String nama_belakang, String noTelepon,
            String kontakDarurat, Integer umur, String email, String Password, String alamat, String ktp,
            String fotoDiri, Boolean hidden) {
        this.nik = nik;
        this.role_user = role_user;
        this.nama_depan = nama_depan;
        this.nama_belakang = nama_belakang;
        this.noTelepon = noTelepon;
        this.kontakDarurat = kontakDarurat;
        this.umur = umur;
        this.email = email;
        this.password = Password;
        this.alamat = alamat;
        this.ktp = ktp;
        this.fotoDiri = fotoDiri;
        this.hidden = hidden;
    }

    public User() {
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Integer getNIK_User() {
        return nik;
    }

    public void setNIK_User(Integer nik) {
        this.nik = nik;
    }

    public String getRole_user() {
        return role_user;
    }

    public void setRole_user(String role_user) {
        this.role_user = role_user;
    }

    public String getNama_depan() {
        return nama_depan;
    }

    public void setNama_depan(String nama_depan) {
        this.nama_depan = nama_depan;
    }

    public String getNama_belakang() {
        return nama_belakang;
    }

    public void setNama_belakang(String nama_belakang) {
        this.nama_belakang = nama_belakang;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getKontakDarurat() {
        return kontakDarurat;
    }

    public void setKontakDarurat(String kontakDarurat) {
        this.kontakDarurat = kontakDarurat;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getFotoDiri() {
        return fotoDiri;
    }

    public void setFotoDiri(String fotoDiri) {
        this.fotoDiri = fotoDiri;
    }
}