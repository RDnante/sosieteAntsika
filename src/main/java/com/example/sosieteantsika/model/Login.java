package com.example.sosieteantsika.model;

public class Login {
    int id_login;
    int id_service;
    int id_poste;
    String password;
    
    public Login(int id_login, int id_service, int id_poste, String password) {
        this.id_login = id_login;
        this.id_service = id_service;
        this.id_poste = id_poste;
        this.password = password;
    }
    public Login() {
    }
    public int getId_login() {
        return id_login;
    }
    public void setId_login(int id_login) {
        this.id_login = id_login;
    }
    public int getId_service() {
        return id_service;
    }
    public void setId_service(int id_service) {
        this.id_service = id_service;
    }
    public int getId_poste() {
        return id_poste;
    }
    public void setId_poste(int id_poste) {
        this.id_poste = id_poste;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
