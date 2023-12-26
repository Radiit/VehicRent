package com.TubesRpl.vehicrent.backend.models;

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
    private int ID_Staff;

    @ManyToOne
    @JoinColumn(name = "NIK_User", referencedColumnName = "NIK_User")
    private User user;
    
    public Staff() {
    }

    public Staff(int ID_Staff, User user) {
        this.ID_Staff = ID_Staff;
        this.user = user;
    }

    //setter and getter
    public int getID_Staff() {
        return ID_Staff;
    }

    public void setID_Staff(int ID_Staff) {
        this.ID_Staff = ID_Staff;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
