package com.TubesRpl.vehicrent.backend.payloads.requests;

public class ClientRequest {
    private Integer NIK_User;
    private String no_SIM;
    private Integer ID_Rekomendasi;

    public Integer getNIK_User() {
        return NIK_User;
    }

    public void setNIK_User(Integer NIK_User) {
        this.NIK_User = NIK_User;
    }

    public String getNo_SIM() {
        return no_SIM;
    }

    public void setNo_SIM(String no_SIM) {
        this.no_SIM = no_SIM;
    }

    public Integer getID_Rekomendasi() {
        return ID_Rekomendasi;
    }

    public void setID_Rekomendasi(Integer ID_Rekomendasi) {
        this.ID_Rekomendasi = ID_Rekomendasi;
    }
}
