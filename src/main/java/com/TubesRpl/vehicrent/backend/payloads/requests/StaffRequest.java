package com.TubesRpl.vehicrent.backend.payloads.requests;

public class StaffRequest {
    
    private Integer nik;

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer NIK_User) {
        this.nik = NIK_User;
    }

    public StaffRequest() {
    }

    public StaffRequest(Integer NIK_User) {
        this.nik = NIK_User;
    }

}