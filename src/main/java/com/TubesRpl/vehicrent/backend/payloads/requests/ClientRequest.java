package com.TubesRpl.vehicrent.backend.payloads.requests;

public class ClientRequest {
    private Integer nik;
    private String sim;
    private Integer idRekomendasi;

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer NIK_User) {
        this.nik = NIK_User;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String no_SIM) {
        this.sim = no_SIM;
    }

    public Integer getIdRekomendasi() {
        return idRekomendasi;
    }

    public void setIdRekomendasi(Integer ID_Rekomendasi) {
        this.idRekomendasi = ID_Rekomendasi;
    }

    public ClientRequest(Integer NIK_User, String no_SIM, Integer ID_Rekomendasi) {
        this.nik = NIK_User;
        this.sim = no_SIM;
        this.idRekomendasi = ID_Rekomendasi;
    }
}
