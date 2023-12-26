package com.TubesRpl.vehicrent.backend.payloads.requests;

import java.util.List;

import com.TubesRpl.vehicrent.backend.models.Kendaraan;

public class RegentRequest {
    private Integer nik;
    private List<Kendaraan> listKendaraan;

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer NIK_User) {
        this.nik = NIK_User;
    }

    public List<Kendaraan> getListKendaraan() {
        return listKendaraan;
    }

    public void setListKendaraan(List<Kendaraan> listKendaraan) {
        this.listKendaraan = listKendaraan;
    }
}