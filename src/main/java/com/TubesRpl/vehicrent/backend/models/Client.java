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
    private Integer idClient;

    @ManyToOne
    @JoinColumn(name = "nik", referencedColumnName = "nik")
    private User user;

    @Column
    private String sim;

    @Column
    private boolean hidden;

    @Column
    private String valid;

    @ManyToOne
    @JoinColumn(name = "ID_Rekomendasi", referencedColumnName = "ID_Rekomendasi")
    private Rekomendasi rekomendasi;

    public Client(Integer ID_Client, User user, String noSIM, Rekomendasi rekomendasi, boolean hidden, String valid) {
        this.idClient = ID_Client;
        this.user = user;
        sim = noSIM;
        this.rekomendasi = rekomendasi;
        this.hidden = hidden;
        this.valid = valid;
    }

    public Client() {
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getValid() {
        return valid;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setIdClient(Integer ID_Client) {
        this.idClient = ID_Client;
    }

    public Integer getIdClient() {
        return idClient;
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

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

}