package com.TubesRpl.vehicrent.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Client;

    @ManyToOne
    @JoinColumn(name = "NIK_User", referencedColumnName = "NIK_User")
    private User user;

    @Column
    private String No_SIM;

    @ManyToOne
    @JoinColumn(name = "ID_Rekomendasi", referencedColumnName = "ID_Rekomendasi")
    private Rekomendasi rekomendasi;

    public Client(Integer ID_Client, User user, String noSIM, Rekomendasi rekomendasi) {
        this.ID_Client = ID_Client;
        this.user = user;
        No_SIM = noSIM;
        this.rekomendasi = rekomendasi;
    }

    public Client() {
    }

    public void setID_Client(Integer ID_Client) {
        this.ID_Client = ID_Client;
    }

    public Integer getID_Client() {
        return ID_Client;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rekomendasi getRekomendasi() {
        return rekomendasi;
    }

    public void setRekomendasi(Rekomendasi rekomendasi) {
        this.rekomendasi = rekomendasi;
    }

    public String getNoSIM() {
        return No_SIM;
    }

    public void setNoSIM(String noSIM) {
        No_SIM = noSIM;
    }

}
