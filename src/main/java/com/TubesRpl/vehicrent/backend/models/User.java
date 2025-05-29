package com.TubesRpl.vehicrent.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "nik")
    private Integer nik;

    @Column(name = "role_user")
    private String role_user;

    @Column(name = "nama_depan")
    private String nama_depan;

    @Column(name = "nama_belakang")
    private String nama_belakang;

    @Column(name = "no_telepon")
    private String noTelepon;

    @Column(name = "kontak_darurat")
    private String kontakDarurat;

    @Column(name = "umur")
    private Integer umur;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "ktp")
    private String ktp;

    @Column(name = "foto_diri")
    private String fotoDiri;

    @Column(name = "hidden")
    private Boolean hidden;

    @Column(name = "valid")
    private String valid;

    public User(Integer nik, String role_user, String nama_depan, String nama_belakang, String noTelepon,
            String kontakDarurat, Integer umur, String email, String Password, String alamat, String ktp,
            String fotoDiri, Boolean hidden, String valid) {
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
        this.valid = valid;
    }

    public User() {
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getValid() {
        return valid;
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