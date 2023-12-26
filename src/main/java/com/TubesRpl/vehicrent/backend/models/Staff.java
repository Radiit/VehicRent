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
@Table(name = "Staff")
public class Staff {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStaff;

    @ManyToOne
    @JoinColumn(name = "nik", referencedColumnName = "nik")
    private User user;

    @Column
    private boolean hidden;
    
    public Staff() {
    }

    public Staff(int ID_Staff, User user, boolean hidden) {
        this.idStaff = ID_Staff;
        this.user = user;
        this.hidden = hidden;

    }

    //setter and getter

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isHidden() {
        return hidden;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int ID_Staff) {
        this.idStaff = ID_Staff;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}