package com.TubesRpl.vehicrent.backend.payloads.requests;

public class UserRequest {

    private Integer NIK_User;
    private String Role_User;
    private String Nama_User;
    private String JenisKelamin_User;
    private Integer Umur_User;
    private String Email_User;
    private String Username;
    private String Password;

    public Integer getNIK_User() {
        return NIK_User;
    }

    public void setNIK_User(Integer NIK_User) {
        this.NIK_User = NIK_User;
    }

    public String getRole_User() {
        return Role_User;
    }

    public void setRole_User(String Role_User) {
        this.Role_User = Role_User;
    }

    public String getNama_User() {
        return Nama_User;
    }

    public void setNama_User(String Nama_User) {
        this.Nama_User = Nama_User;
    }

    public String getJenisKelamin_User() {
        return JenisKelamin_User;
    }

    public void setJenisKelamin_User(String JenisKelamin_User) {
        this.JenisKelamin_User = JenisKelamin_User;
    }

    public Integer getUmur_User() {
        return Umur_User;
    }

    public void setUmur_User(Integer Umur_User) {
        this.Umur_User = Umur_User;
    }

    public String getEmail_User() {
        return Email_User;
    }

    public void setEmail_User(String Email_User) {
        this.Email_User = Email_User;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}