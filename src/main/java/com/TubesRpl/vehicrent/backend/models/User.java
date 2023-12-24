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
    private Integer NIK_User;

    @Column
    private String Role_User;
    
    @Column
    private String Nama_User;

    @Column
    private String JenisKelamin_User;

    @Column
    private Integer Umur_User;

    @Column
    private String Email_User;

    @Column
    @JsonIgnore
    private String Username;

    @Column
    @JsonIgnore
    private String Password;

    @Column
    private String ktp;

    @Column
    private String foto;

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public Integer getNIK_User() {
        return NIK_User;
    }

    public void setNIK_User(Integer nIK_User) {
        NIK_User = nIK_User;
    }

    public String getRole_User() {
        return Role_User;
    }

    public void setRole_User(String role_User) {
        Role_User = role_User;
    }

    public String getNama_User() {
        return Nama_User;
    }

    public void setNama_User(String nama_User) {
        Nama_User = nama_User;
    }

    public String getJenisKelamin_User() {
        return JenisKelamin_User;
    }

    public void setJenisKelamin_User(String jenisKelamin_User) {
        JenisKelamin_User = jenisKelamin_User;
    }

    public Integer getUmur_User() {
        return Umur_User;
    }

    public void setUmur_User(Integer umur_User) {
        Umur_User = umur_User;
    }

    public String getEmail_User() {
        return Email_User;
    }

    public void setEmail_User(String email_User) {
        Email_User = email_User;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public User(Integer nIK_User, String role_User, String nama_User, String jenisKelamin_User, Integer umur_User,
            String email_User, String username, String password, String ktp, String foto) {
        NIK_User = nIK_User;
        Role_User = role_User;
        Nama_User = nama_User;
        JenisKelamin_User = jenisKelamin_User;
        Umur_User = umur_User;
        Email_User = email_User;
        Username = username;
        Password = password;
        this.ktp = ktp;
        this.foto = foto;
    }

    public User() {
    }
}
