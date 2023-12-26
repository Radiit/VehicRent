package com.TubesRpl.vehicrent.backend.payloads.requests;

public class UserRequest {

    private Integer nik;
    private String role_user;
    private String nama_depan;
    private String nama_belakang;
    private String noTelepon;
    private String kontakDarurat;
    private Integer umur;
    private String email;
    private String password;
    private String alamat;
    private String ktp;
    private String fotoDiri;

    public UserRequest(Integer NIK_User, String role_user, String nama_depan, String nama_belakang, String noTelepon, String kontakDarurat, Integer umur, String email, String Password, String alamat, String ktp, String fotoDiri) {
        this.nik = NIK_User;
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
    }

    public UserRequest() {
    }

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer NIK_User) {
        this.nik = NIK_User;
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