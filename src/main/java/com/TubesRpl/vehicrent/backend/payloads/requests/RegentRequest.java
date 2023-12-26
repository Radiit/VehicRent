package com.TubesRpl.vehicrent.backend.payloads.requests;

import java.util.List;

import com.TubesRpl.vehicrent.backend.models.Kendaraan;

public class RegentRequest {
    private Integer NIK_User;
    private String Password;
    private String Norek_Regent;
    private List<Kendaraan> listKendaraan;

    public Integer getNIK_User() {
        return NIK_User;
    }

    public void setNIK_User(Integer NIK_User) {
        this.NIK_User = NIK_User;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNorek_Regent() {
        return Norek_Regent;
    }

    public void setNorek_Regent(String Norek_Regent) {
        this.Norek_Regent = Norek_Regent;
    }

    public List<Kendaraan> getListKendaraan() {
        return listKendaraan;
    }

    public void setListKendaraan(List<Kendaraan> listKendaraan) {
        this.listKendaraan = listKendaraan;
    }
}
